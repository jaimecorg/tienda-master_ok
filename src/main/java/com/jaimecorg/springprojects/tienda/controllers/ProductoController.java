package com.jaimecorg.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.springprojects.tienda.model.DetallePedido;
import com.jaimecorg.springprojects.tienda.model.Pedido;
import com.jaimecorg.springprojects.tienda.model.Producto;
import com.jaimecorg.springprojects.tienda.services.ProductosServices;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductosServices productosService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {

        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
                directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Producto> page = productosService.findAll(pageable);

        List<Producto> productos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", productos);

        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}/{cesta}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo, @PathVariable(name = "cesta", required = false) boolean cesta) {

        Producto producto = productosService.findProducto(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", producto);
        modelAndView.addObject("cesta", cesta);

        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", new Producto());
        modelAndView.setViewName("productos/new");

        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Producto producto, @RequestParam("imageForm") MultipartFile multipartFile)
            throws IOException {

        byte[] image = multipartFile.getBytes();

        producto.setImg(image);

        productosService.insert(producto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + producto.getCodigo() + "/false");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Producto producto, @RequestParam("imageForm") MultipartFile multipartFile)
            throws IOException {

        byte[] image = multipartFile.getBytes();

        producto.setImg(image);

        productosService.update(producto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + producto.getCodigo( ) + "/false");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        productosService.delete(codigo);
        // List<Producto> productos = productosService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("productos", productos);
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }

    @RequestMapping(path = "/cantidad")
    public ModelAndView cantidad(@RequestParam(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();

        Producto producto = productosService.findProducto(codigo);
        modelAndView.addObject("producto", producto);
        modelAndView.setViewName("productos/cantidad");

        return modelAndView;
    }

    @RequestMapping(value = "/anadir/{codigo}")
    public ModelAndView anadir(@PathVariable(name = "codigo", required = true) int codigo,
            @RequestParam(name = "cantidad", required = true) int cantidad, HttpSession session) {

        Producto producto = productosService.findProducto(codigo);

        Pedido cesta = (Pedido) session.getAttribute("cesta");

        if(cesta == null){
            cesta = new Pedido();
        }
        
        List<DetallePedido> listaProductos = cesta.getDetallePedidos();

        double subtotal = producto.getPrecio() * cantidad;

        DetallePedido detallePedido = new DetallePedido();

        listaProductos.add(detallePedido);
        cesta.setDetallePedidos(listaProductos);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/productos/list");

        session.setAttribute("cesta", cesta);

        return modelAndView;
    }

}
