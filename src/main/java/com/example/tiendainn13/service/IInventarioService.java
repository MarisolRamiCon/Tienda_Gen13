package com.example.tiendainn13.service;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.response.InventarioResponse;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {
    public List<Inventario> readAll();
    public Optional<Inventario> readById(int id);
    public InventarioResponse create (Inventario inventario);
    public Inventario update (Inventario inventario);
    public void delete(Inventario inventario);
}
