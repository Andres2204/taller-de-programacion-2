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

    @PostMapping({ "/validar/{returnPage}" })
    public String validarCliente(@Valid Cliente cliente,
            BindingResult result,
            @PathVariable String returnPage,
            Model model) {
           Cliente cliente2 = clienteDao.findByEmail(cliente.getEmail());
               if(cliente2 != null && cliente2.getPassword().equals(cliente.getPassword())){
                  System.out.println("Valido exitosamente");
                  model.addAttribute("mensajeError", "El correo electrónico ya está en uso.");
                  return "redirect:/";
               }
               return "redirect:/login";      
    }
}
