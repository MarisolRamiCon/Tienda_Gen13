package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Producto;
import com.example.tiendainn13.repository.IProductoRepository;
import com.example.tiendainn13.response.ProductoResponse;
import com.example.tiendainn13.service.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll().stream().filter(producto -> producto.getEsActivo()==true).toList();
    }

    @Override
    public Optional<Producto> readById(int id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto;
    }

    @Override
    public ProductoResponse create(Producto producto) {
        productoRepository.save(producto);
        ProductoResponse productoResponse = new ProductoResponse(producto.getNombreProducto(), producto.getPrecioProducto());
        return productoResponse;
    }

    @Override
    public ProductoResponse update(Producto producto) {
        productoRepository.save(producto);
        ProductoResponse productoResponse = new ProductoResponse(producto.getNombreProducto(), producto.getPrecioProducto());
        return  productoResponse;
    }

    @Override
    public String delete(Producto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(producto.getIdProducto());
        if (productoOptional.isPresent()){
            Producto productoABorrar = productoOptional.get();
            productoABorrar.setEsActivo(false);
            try {
                productoRepository.save(productoABorrar);
                log.info("El producto ha sido borrado");
                return "El producto ha sido Borrado satisfactoriamente";
            }catch (Exception e){
                log.error("Error " + e.getMessage());
                log.error("Rastreo: " + e.getStackTrace());
                return "Hubo un error con la base de datos";
            }
        }else{
            log.info("El producto  no existe");
            return "El producto no existe";
        }
    }

    @Override
    public List<Producto> precioMenor(Double precio_p, Integer stock) {
        return productoRepository.precioMenor(precio_p, stock);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreProducto(nombre);
    }

    @Override
    public List<Producto> buscarPorNombreYPrecio(String nombre, Double precio) {
        return productoRepository.findByNombreProductoAndPrecioProducto(nombre, precio);
    }


}
