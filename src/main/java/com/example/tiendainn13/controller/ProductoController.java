package com.example.tiendainn13.controller;

import com.example.tiendainn13.entity.Producto;
import com.example.tiendainn13.response.ProductoResponse;
import com.example.tiendainn13.service.impl.ProductoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/mostrar/productos")
    public List<Producto> readAll(){
        return productoService.readAll();
    }

    @GetMapping("/mostrar/producto/{id}")
    public Optional<Producto> readById(@PathVariable int id){
        return productoService.readById(id);
    }

    //Mostrar producto por precio menor a? y a categoria especifica
    @GetMapping("/mostrar/preciomenor")
    public List<Producto> precioMenor(@PathParam("precio_p") Double precio_p){
        return productoService.precioMenor(precio_p);
    }


    @PostMapping("/crear/producto")
    public ProductoResponse create(@RequestBody Producto producto){
        return productoService.create(producto);
    }

    @PutMapping("/actualizar/producto")
    public  ProductoResponse update(@RequestBody Producto producto){
        return  productoService.update(producto);
    }

    @DeleteMapping("/eliminar/producto")
    public void delete(@RequestBody Producto producto){
        productoService.delete(producto);
    }

}
