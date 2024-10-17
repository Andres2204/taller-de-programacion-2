package com.example.primerapractica.Controllers;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientesapi")
public class ClienteRestController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping
    public List<Cliente> listarClientes() {
        return  clienteDao.findAll();
    }
}
