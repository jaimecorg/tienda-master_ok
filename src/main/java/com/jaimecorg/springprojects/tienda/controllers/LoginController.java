package com.jaimecorg.springprojects.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Usuario;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value="/signin")
    public ModelAndView signin() {
        

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("login/signin");

        return modelAndView;
    }

    //@PostMapping(value="/login")
    @RequestMapping(value = "/login")
    public ModelAndView login(Usuario usuario, HttpSession session) {

        //esto para no hacer login
        usuario = new Usuario();
        usuario.setNombre("Jaime");
        //
        
        String message = messageSource.getMessage("saludar.usuario", new String[] {usuario.getNombre()}, LocaleContextHolder.getLocale());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("greetings", message);
        modelAndView.setViewName("welcome");

        session.setAttribute("usuario", usuario);

        return modelAndView;
    }

    @GetMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("login/signin");

        //session.setAttribute("usuario", null);
        session.invalidate();

        return modelAndView;
    }

    @GetMapping(value="/welcome")
    public String welcome() {
        return "welcome";
    }
    
    
}
