package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.DAO.IDetalleDao;
import com.example.primerapractica.Models.DAO.IEncabezadoDAO;
import com.example.primerapractica.Models.DAO.IProductoDao;
import com.example.primerapractica.Models.Entity.Cliente;
import com.example.primerapractica.Models.Entity.Detalle;
import com.example.primerapractica.Models.Entity.Encabezado;
import com.example.primerapractica.Models.Entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private IProductoDao productoDao;
    @Autowired
    private IDetalleDao detalleDao;
    @Autowired
    private IEncabezadoDAO encabezadoDAO;
    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("")
    public String tienda(Model m) {
        List<Producto> p = productoDao.findAll();

        m.addAttribute("productos", p);

        return "tienda";
    }

    @GetMapping("/cart/{id_usr}/{id_producto}")
    public String cart(Model m, @PathVariable("id_usr") Long id_u, @PathVariable("id_producto") Long id_p) {

        // guardar en el carrito
        System.out.println("\n\n\nId card = " + id_p + "\n\n\n");

        // verificar si hay un cliente y poducto con stock > 0
        Cliente c = clienteDao.findOne(id_u);
        Producto p = productoDao.findOne(id_p);

        if (c==null || p==null) {
            m.addAttribute("error", "no existe el usuario o un producto asociado");
            return "redirect:/tienda";
        }

        // Sí existe, encontrar su encabezado asociado y crear un detalle asociado al encabezado
        if (p.getStock() > 0) {
            Encabezado e = encabezadoDAO.findOne(id_u); // ⇽ deberia buscar basándonos en el id del usuario.
            Detalle d = new Detalle(e, p, 1, p.getValorUnitario(), 1);
            encabezadoDAO.save(e);
            detalleDao.save(d);
        }

        return "redirect:/tienda#"+id_p;
    }

}
