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
    public List<Producto> precioMenor(@PathParam("precio_p") Double precio_p, @PathParam("stock") Integer stock){
        return productoService.precioMenor(precio_p, stock);
    }

    //Mostar producto busqueda por nombre
    @GetMapping("/buscar/nombre")
    public List<Producto> buscarPorNombre(@PathParam("nombreProducto") String nombre){
       return productoService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/nombre/precio")
    public List<Producto> buscarPorNombreYPrecio(@PathParam("nombreProducto") String nombre,
                                                 @PathParam("precioProducto") Double precio){
        return productoService.buscarPorNombreYPrecio(nombre, precio);
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
    public String delete(@RequestBody Producto producto){
        return productoService.delete(producto);
    }

}
