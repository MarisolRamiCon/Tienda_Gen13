package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
    public List<Inventario> findByCantidadStockInve(Integer  cantidadStockInve);
}
