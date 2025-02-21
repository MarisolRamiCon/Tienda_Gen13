package com.example.tiendainn13.service;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.response.InventarioResponse;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {
    public List<Inventario> readAll();
    public Optional<Inventario> readById(int id);
    public InventarioResponse create (Inventario inventario);
    public InventarioResponse update (Inventario inventario);
    public String delete(Inventario inventario);
    public List<Inventario> buscarPorCantidadStockInve(Integer stock);
    public List<Inventario> buscarEsActivoYCantidadStock(Boolean activo, Integer stock);
}
