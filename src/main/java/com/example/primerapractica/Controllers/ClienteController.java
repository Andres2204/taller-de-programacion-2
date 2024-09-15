package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("")
    public String Listar(Model model) {
        model.addAttribute("titulo", "Clientes encontrados.");
        model.addAttribute("cliente", clienteDao.findAll());

        return "listar";
    }

    @GetMapping("/nuevo")
    public String crear(Model model) { // crear un nuevo cliente
        Cliente cliente = new Cliente();

        model.addAttribute("titulo", "Formulario de Cliente");
        model.addAttribute("cliente", cliente);

        return "nuevo";
    }

    @PostMapping("/validar/{returnPage}") // <- posible metodo de enumerar clientes!
    //para validar se agrega el valid y el bindingResul, estos siempre deben estar juntos uno tras otro
    public String validarCliente(@Valid Cliente cliente, BindingResult result, @PathVariable String returnPage, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente ********");
            model.addAttribute("err", result.getAllErrors());
            return returnPage;
        }

        clienteDao.Save(cliente);
        //Status.setComplete();
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}") //editar un cliente existente
    public String Editar(@PathVariable Long id, Model model) {
        // verificar que la ide sea valida
        if (id <= 0) return "redirect:/listar";

        // encontrar cliente para enviar datos a editar
        Cliente cliente = clienteDao.findOne(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Editar Cliente");

        return "edit";
    }

    @GetMapping("/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        if (id > 0) {
            clienteDao.Delete(id);
        }
        return "redirect:/clientes";
    }

}


