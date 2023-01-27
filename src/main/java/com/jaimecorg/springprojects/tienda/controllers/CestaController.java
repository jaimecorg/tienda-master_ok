package com.jaimecorg.springprojects.tienda.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.Cliente;
import com.jaimecorg.springprojects.tienda.model.DetallePedido;
import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.services.ClientesServices;

@Controller
@RequestMapping("/cesta")
public class CestaController {

    @Autowired
    ClientesServices clientesService;

    @GetMapping(value = { "/edit" })
    public ModelAndView cesta(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Pedido pedido = (Pedido) session.getAttribute("pedido");

        if(pedido == null) {
            pedido = new Pedido();
        }

        Cliente cliente = pedido.getCliente();


        modelAndView.addObject("cliente", cliente);
        modelAndView.addObject("pedido", pedido);
        modelAndView.setViewName("cesta/edit");
        return modelAndView;    
    }

    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta/list");
        return modelAndView;
    }

    @GetMapping(value = { "/delete" })
    public ModelAndView delete(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        session.setAttribute("pedido", null);

        modelAndView.setViewName("redirect:edit");
        return modelAndView;    
    }

    @GetMapping(value = "/deleteproducto/{codigo}")
    public ModelAndView addCliente(
        @PathVariable(name = "codigo", required = true) int codigo, HttpSession session) {

            Pedido pedido = (Pedido) session.getAttribute("pedido");

            List<DetallePedido> detallePedidos = pedido.getDetallePedidos();

            for (DetallePedido detallePedido : detallePedidos) {
                if(detallePedido.getProducto().getCodigo() == codigo){
                    detallePedidos.remove(detallePedido);
                    break;
                }
                
            }

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/cesta/edit");
            return modelAndView;
    }
}