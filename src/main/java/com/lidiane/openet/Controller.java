package com.lidiane.openet;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    @GetMapping("/")
    public ModelAndView paginainicial(){
        return new ModelAndView("index");
    }
    @GetMapping("/restrito")
    public String restrito(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String nome;    

        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }
        return "Logado com o usuário"+nome;
    }
}
