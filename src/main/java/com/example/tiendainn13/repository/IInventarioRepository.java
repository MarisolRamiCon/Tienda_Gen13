package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
    public List<Inventario> findByCantidadStockInve(Integer  cantidadStockInve);
    //JPA Query
    //Donde es_activo=true  cantidad_stock sea menor a
    @Query(value = "SELECT * from inventario   where  es_activo=:es_activo && cantidad_stock<:cantidad_stock", nativeQuery = true)
    public List<Inventario> esActivo(Boolean es_activo, Integer cantidad_stock);
}
