package com.example.tienda.service;

import com.example.tienda.entity.Empleados;
import com.example.tienda.response.EmpleadosResponse;

import java.util.List;
import java.util.Optional;

public interface IEmpleados {
    public List<Empleados> readAll();
    public Optional<Empleados> readById(int id);
    public EmpleadosResponse create(Empleados empleado);
    public Empleados update(Empleados empleado);
    public void delete(Empleados empleado);
}
