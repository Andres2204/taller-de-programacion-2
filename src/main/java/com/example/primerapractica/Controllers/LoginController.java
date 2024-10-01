package com.example.primerapractica.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping({ "" })
    public String login(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model) {

        model.addAttribute("titulo", "Formulario de Registro");
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

     @PostMapping("/validar/{returnPage}") // <- posible metodo de enumerar clientes!
    // para validar se agrega el valid y el bindingResul, estos siempre deben estar
    // juntos uno tras otro
    public String validarCliente(
            @Valid Cliente cliente,
            BindingResult result,
            @PathVariable String returnPage,
            Model model) {
        System.out.println("\n[+] verificando cliente: " + cliente.toString() + "\n");
        if (result.hasErrors() || (clienteDao.findByEmail(cliente.getEmail()) != null)) {
            if (clienteDao.findByEmail(cliente.getEmail()) != null) {
                result.rejectValue("email", "error.cliente", "El correo electrónico ya está en uso.");
                model.addAttribute("mensajeError", "El correo electrónico ya está en uso.");
            } else
                model.addAttribute("titulo", "Registro exitoso");
            model.addAttribute("err", result.getModel());
            return returnPage;
        }
        clienteDao.Save(cliente);

        return "redirect:/login";
    }
}
