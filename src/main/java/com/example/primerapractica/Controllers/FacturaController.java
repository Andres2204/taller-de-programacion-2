package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.DetalleDaoImp;
import com.example.primerapractica.Models.DAO.IDetalleDao;
import com.example.primerapractica.Models.DAO.IEncabezadoDAO;
import com.example.primerapractica.Models.DAO.IProductoDao;
import com.example.primerapractica.Models.Entity.Detalle;
import com.example.primerapractica.Models.Entity.Encabezado;
import com.example.primerapractica.Models.Entity.Producto;
import com.example.primerapractica.Services.PDFbean;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.io.IOException;
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
    private PDFbean pdfService;

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



    // Este endpoint genera el PDF usando datos de Encabezado y Detalle
    @PostMapping("/generar")
    public String generatePdf(@RequestBody Encabezado encabezado,
                            @RequestBody List<Detalle> detalleList,
                            HttpServletResponse response, @PathVariable String returnPage) {
        try {
            // Establecer los headers para la respuesta como PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=factura.pdf");

            // Llamar al servicio para generar el PDF
            pdfService.generate(encabezado, detalleList, response);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        return "redirect:/factura/"+encabezado.getId();
    }

}
