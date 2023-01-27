package com.jaimecorg.springprojects.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Empleado;
import com.jaimecorg.springprojects.tienda.services.EmpleadosServices;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadosServices empleadosService;


    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    
    
    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Empleado empleado = empleadosService.findAll(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empleado", empleado);
        modelAndView.setViewName("empleados/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Empleado empleado) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empleado", new Empleado());
        modelAndView.setViewName("empleados/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Empleado empleado) {

        empleadosService.save(empleado);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + empleado.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Empleado empleado) {

        empleadosService.update(empleado);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + empleado.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

                empleadosService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }

}
