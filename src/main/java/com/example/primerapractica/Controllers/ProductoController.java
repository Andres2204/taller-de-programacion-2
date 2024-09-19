package com.example.primerapractica.Controllers;


import com.example.primerapractica.Models.DAO.IProductoDao;
import com.example.primerapractica.Models.Entity.Producto;
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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoDao productoDao;

    @GetMapping("")
    public String Listar(Model model) {
        model.addAttribute("titulo", "Productos encontrados.");
        model.addAttribute("producto", productoDao.findAll());

        return "listarProd";
    }

    @GetMapping("/nuevo")
    public String crear(Model model) { // crear un nuevo producto
        Producto producto = new Producto();

        model.addAttribute("titulo", "Formulario de Producto");
        model.addAttribute("producto", producto);

        return "nuevoProd";
    }

    @PostMapping("/validar/{returnPage}") // <- posible metodo de enumerar Productos!
    //para validar se agrega el valid y el bindingResul, estos siempre deben estar juntos uno tras otro
    public String validarCliente(@Valid Producto producto, BindingResult result, @PathVariable String returnPage, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Producto");
            model.addAttribute("err", result.getModel());
            return returnPage;
        }

        productoDao.Save(producto);
        //Status.setComplete();
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}") //editar un Producto existente
    public String Editar(@PathVariable Long id, Model model) {
        // verificar que la ide sea valida
        if (id <= 0) return "redirect:/listarProd";

        // encontrar cliente para enviar datos a editar
        Producto producto = productoDao.findOne(id);
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar Producto");

        return "editarProd";
    }

    @GetMapping("/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        if (id > 0) {
            productoDao.Delete(id);
        }
        return "redirect:/productos";
    }
    
}
