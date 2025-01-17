package com.example.tienda.repository;

import com.example.tienda.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
}
