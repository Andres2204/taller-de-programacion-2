package com.example.primerapractica.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private IClienteDao clienteDao;
    
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @GetMapping({"/"," ","/login"})
    public String login(Model model) {
        Cliente cliente = new Cliente("");
        model.addAttribute("cliente", cliente);
        return "login";
    }

    // @PostMapping("/validar/{returnPage}")
    // public String procesarLogin(@ModelAttribute("cliente") Cliente cliente, Model model) {
    //     Cliente ingresado = clienteDao.findByEmail(cliente.getEmail());
    //     ingresado.setPassword(passwordEncoder.encode(cliente.getPassword()));
    //     System.out.println(ingresado.getPassword());
    //     System.out.println(cliente.getPassword());
    //     if (ingresado.getEmail().equals(cliente.getEmail()) && ingresado.getPassword().equals(cliente.getPassword())) {
    //         return "redirect:/home"; // Redirige a la página de inicio
    //     } else {
    //         model.addAttribute("error", "Email o contraseña incorrectos");
    //         return "login"; // Devuelve a la página de login con un mensaje de error
    //     }
    // }

    //  @PostMapping("/validar/{returnPage}")
    // public String procesarLogin(@ModelAttribute("cliente") Cliente cliente, Model model) {
    //     Cliente ingresado = clienteDao.findByEmail(cliente.getEmail());
    //     if (ingresado !=null && passwordEncoder.encode(cliente.getPassword()).equals(ingresado.getPassword())) {
    //          return "redirect:/home"; // Redirige a la página de inicio
    //     } else {
    //         model.addAttribute("error", "Email");
    //         return "login"; // Devuelve a la página de login con un mensaje de error
    //     }
    // }

    @GetMapping("/registro")
    public String registro(Model model) {

        model.addAttribute("titulo", "Formulario de Registro");
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

    @PostMapping("/validar/registro/{returnPage}") // <- posible metodo de enumerar clientes!
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
                model.addAttribute("titulo", "Formulario de Registro");
            model.addAttribute("err", result.getModel());
            return returnPage;
        }
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        clienteDao.Save(cliente);

        return "redirect:/";
    }
}
