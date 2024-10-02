package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.DAO.IDetalleDao;
import com.example.primerapractica.Models.DAO.IEncabezadoDAO;
import com.example.primerapractica.Models.DAO.IProductoDao;
import com.example.primerapractica.Models.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    /*
        TODO: poner la tienda estilo amazon, es decir, cuando se de click en un producto llevarlo a la pagina del producto.
        De esta manera no se tiene que hacer una peticion para volver a la tienda de manera simulada.
        TODO: tener mayor precaucion con los stock de los productos para su interaccion antes de la compra
    */

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
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        User usr = (User) auth.getPrincipal();
        Cliente c = clienteDao.findByEmail(usr.getUsername());

        List<Producto> p = productoDao.findAll();
        m.addAttribute("productos", p);

        int cartCount = 0;
        Encabezado e = encabezadoDAO.findOne(c.getId());
        if (e != null) cartCount = detalleDao.findAll(e.getId()).size();

        m.addAttribute("cartCount", cartCount);
        return "tienda/tienda";
    }

    // TODO: Cambiar metodo y ruta a una mas apropiada
    @GetMapping("/cart/{id_producto}")
    public String cart(Model m , @PathVariable("id_producto") Long id_p) {

        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        User usr = (User) auth.getPrincipal();
        Cliente c;

        // verificar si hay un cliente y poducto con stock > 0
        c = clienteDao.findByEmail(usr.getUsername());
        Producto p = productoDao.findOne(id_p);
        Long id_u = c.getId();

        if (c==null || p==null) {
            m.addAttribute("error", "no existe el usuario o un producto asociado");
            return "redirect:/tienda";
        }

        // TODO: Organizar correctamente la actualizacion de totales y subtotales para los encabezados

        // Sí existe, encontrar su encabezado asociado y crear un detalle asociado al encabezado
        if (p.getStock() > 0) {
            Encabezado e = encabezadoDAO.findOne(id_u); // ⇽ deberia buscar basándonos en el id del usuario.

            // no hay encabezado asociado, crear uno
            if (e == null) {
                e = new Encabezado(c, new Date(), 1, p.getValorUnitario(), 1);
                encabezadoDAO.save(e);
            } else e.setTotal(e.getTotal()+p.getValorUnitario()); // sino aumentar el total.

            encabezadoDAO.save(e);

            Detalle d = new Detalle(e, p, 1, p.getValorUnitario(), 1);
            detalleDao.save(d);
        }

        return "redirect:/tienda#"+id_p;
    }

    // TODO: restar cuando se compre
    // Todo: cambiar el formato en el que se envia la informacion o enviar mas para tener una vista mas completa
    @GetMapping("cart")
    public String cart(Model m) {
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        User usr = (User) auth.getPrincipal();
        Cliente c = clienteDao.findByEmail(usr.getUsername());
        m.addAttribute("uid", c.getId());

        Encabezado e = encabezadoDAO.findOne(c.getId());
        m.addAttribute("encabezado", e);
        m.addAttribute("dettalles", detalleDao.findAll(e.getId()));

        return "tienda/cart";
    }

}
