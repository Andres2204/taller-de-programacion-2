package com.example.primerapractica.Controllers;

import com.example.primerapractica.Controllers.GenericForm.GenericForm;
import com.example.primerapractica.Controllers.GenericForm.GenericFormField;
import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/nuevoGenerado")
    public String crearGenerado(Model model) { // crear un nuevo cliente
        Cliente cliente = new Cliente();
        model.addAttribute("titulo", "Formulario de Cliente");

        List<GenericFormField> fields = new ArrayList<>();
        fields.add(new GenericFormField("nombre", "Nombre", "text", true));
        fields.add(new GenericFormField("apellido", "Apellido", "text", true));
        fields.add(new GenericFormField("email", "Email", "email", true));

        GenericForm form = new GenericForm("/clientes/validarGenerado/genericForm", fields);
        form.setValidationUrl("/clientes/validarGenerado/returnPage");
        form.setObj(cliente);

        model.addAttribute("dynamicForm", form);

        return "genericForm";
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
                model.addAttribute("titulo", "Formulario de Cliente");
            model.addAttribute("err", result.getModel());
            return returnPage;
        }
        clienteDao.Save(cliente);

        return "redirect:/clientes";
    }

    @PostMapping("/validarGenerado/{returnPage}") // <- posible metodo de enumerar clientes!
    // para validar se agrega el valid y el bindingResul, estos siempre deben estar
    // juntos uno tras otro
    public String validarGenerado(
            @Valid Cliente cliente,
            BindingResult result,
            @PathVariable String returnPage,
            Model model) {
        System.out.println("\n[+] verificando cliente: " + cliente.toString() + "\n");
        System.out.println("\n[+] verificando res: " + result.toString() + "\n");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Cliente> violation : violations) {
                System.out.println(violation.getMessage());
            }
            throw new RuntimeException("El objeto Cliente no es válido");
        }

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            model.addAttribute("err", result.getModel());
            return returnPage;
        }
        clienteDao.Save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}") // editar un cliente existente
    public String Editar(@PathVariable Long id, Model model) {
        // verificar que la ide sea valida
        if (id <= 0)
            return "redirect:/listar";

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
