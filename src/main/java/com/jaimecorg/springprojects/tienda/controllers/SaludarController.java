package com.jaimecorg.springprojects.tienda.controllers;
/* package com.jaimecorg.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaimecorg.springprojects.tienda.model.Producto;


@Controller
@RequestMapping("/saludar")

public class SaludarController {
    @GetMapping(value = {"/hola", "/buenas"})
    public String hola() {
        return "hola";
    }
    @GetMapping(value = {"/adios", "/hastaluego"})
    public String adios() {
        return "adios";
    }

    @GetMapping(value = "/inicio")
    public String inicio(Model model) {

        model.addAttribute("listaProductos", getProductos());

        return "indice";         
    }

    @GetMapping(value = "/producto")
    public String producto(@RequestParam(name = "codigo") int codigo, Model model) {

        model.addAttribute("productoSel", getProducto(codigo));


        return "producto";         
    }

    @GetMapping(value = "/producto/{codigo}")
    public String product(@PathVariable(name = "codigo", required = true) int codigo, Model model) {

        model.addAttribute("productoSel", getProducto(codigo));


        return "producto";         
    }

    private Producto getProducto(int codigo) {
        ArrayList <Producto> productos = (ArrayList<Producto>) getProductos();
        Producto productoSel = null;

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                productoSel = producto;
                break;
            }   
        }

        return productoSel;
    }

    private List<Producto> getProductos() {
        Producto p1 = new Producto(1, "nombre1", "descripcion1", "/img/coca.jpg", null);
        Producto p2 = new Producto(2, "nombre2", "descripcion2", "/img/fanta.jpg", null);
        Producto p3 = new Producto(3, "nombre3", "descripcion3", "/img/pepsi.png", null);
        Producto p4 = new Producto(4, "nombre4", "descripcion4", "/img/sprite.jpg", null);

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4); 

        return listaProductos;
    }

}
 */