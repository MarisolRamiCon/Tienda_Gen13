package com.example.tienda.repository;

import com.example.tienda.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepository extends JpaRepository<Empleados,Integer> {
}
