package com.example.tienda.service;

import com.example.tienda.entity.Proveedores;
import com.example.tienda.response.ProveedoresResponse;

import java.util.List;
import java.util.Optional;

public interface IProveedores {
    public List<Proveedores> readAll();
    public Optional<Proveedores> readById(int id);
    public ProveedoresResponse create(Proveedores proveedor);
    public Proveedores update(Proveedores proveedor);
    public void delete(Proveedores proveedor);
}
