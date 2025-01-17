package com.example.tienda.service;

import com.example.tienda.entity.Producto;
import com.example.tienda.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> readAll();
    public Optional<Producto> readById(int id);
    public ProductoResponse create (Producto producto);
    public ProductoResponse update (Producto producto);
    public void delete(Producto producto);
    public List<Producto> precioMenor(Double precio_p);

}
