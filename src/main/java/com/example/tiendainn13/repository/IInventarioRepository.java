package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
}
