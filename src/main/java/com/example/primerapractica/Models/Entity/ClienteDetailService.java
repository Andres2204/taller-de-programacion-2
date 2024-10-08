package com.example.primerapractica.Models.Entity;

import com.example.primerapractica.Models.DAO.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteDetailService implements UserDetailsService {


    @Autowired
    private IClienteDao repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente user = repository.findByEmail(email);
        if (user != null) {
            System.out.println("2--------------");   
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(getRoles(user))
                    .build();
        } else {
            throw new UsernameNotFoundException(email);
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