package com.example.primerapractica.Controllers.GenericForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GenericFormController<T> {

    @PostMapping("/generateForm")
    public String generateForm(@ModelAttribute T o) {



        return "";
    }

    @GetMapping("/genericForm")
    public String genericForm() {


        return "";
    }

}
