package com.example.tienda.service.impl;

import com.example.tienda.entity.Producto;
import com.example.tienda.repository.IProductoRepository;
import com.example.tienda.response.ProductoResponse;
import com.example.tienda.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll();
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
    public void delete(Producto producto) {
        productoRepository.delete(producto);
    }

    @Override
    public List<Producto> precioMenor(Double precio_p) {
        return productoRepository.precioMenor(precio_p);
    }


}
