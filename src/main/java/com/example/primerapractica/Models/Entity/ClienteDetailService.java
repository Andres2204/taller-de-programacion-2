package com.example.primerapractica.Models.Entity;

import com.example.primerapractica.Models.DAO.IClienteDao;
import com.example.primerapractica.Models.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteDetailService implements UserDetailsService {

    // TODO: crear un clienteCreds

    @Autowired
    private IClienteDao repository;

    // TODO: CAMBIAR NOMBRE POR EMAIL
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente user = repository.findByEmail(username);
        if (user != null) {
            return User.builder()
                    .username(user.getNombre())
                    .password(user.getPassword())
                    .roles(getRoles(user))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }


    // TODO: ROLES
    private String[] getRoles(Cliente user) {
        return new String[]{"USER"};
        //if (user.getRole() == null) {
        //    return new String[]{"USER"};
        //}
        //return user.getRole().split(",");
    }
}