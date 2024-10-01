package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.DetalleDaoImp;
import com.example.primerapractica.Models.DAO.IDetalleDao;
import com.example.primerapractica.Models.DAO.IEncabezadoDAO;
import com.example.primerapractica.Models.DAO.IProductoDao;
import com.example.primerapractica.Models.Entity.Detalle;
import com.example.primerapractica.Models.Entity.Encabezado;
import com.example.primerapractica.Models.Entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/factura")
public class FacturaController {

    /**
     *
     */
    @Autowired
    private IEncabezadoDAO encabezadoDao;

    @Autowired
    private IDetalleDao detalleDao;

    @Autowired
    private IProductoDao productoDao;


    @GetMapping("/{id}")
    public String Listar(@PathVariable Long id, Model model) {

        if(id<=0){
            return "";
        }
        ArrayList<Detalle> detalles = (ArrayList<Detalle>) detalleDao.findAll(id);
        System.out.println(detalles.get(0).getId()+"----------------");
        Encabezado encabezado = encabezadoDao.findOne(id);
        model.addAttribute("titulo", "Factura Nº"+encabezado.getId());
        model.addAttribute("encabezado",encabezado);
        model.addAttribute("detalles",detalles);
        return "factura";
    }

}
