package com.example.tienda.controller;

import com.example.tienda.entity.Empleados;
import com.example.tienda.response.EmpleadosResponse;
import com.example.tienda.service.impl.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4")

public class EmpleadosController {
    @Autowired
    EmpleadosService empleadosService;

    @GetMapping("/empleados")
    public List<Empleados> readAll() {
        return empleadosService.readAll();
    }

    @GetMapping("/empleado/{id}")
    public Optional<Empleados> readById(@PathVariable int id){
        return empleadosService.readById(id);
    }

    @PostMapping("/empleados")
    public EmpleadosResponse create(@RequestBody Empleados empleado){ // requestbody para pedir todos los atributos
        return empleadosService.create(empleado);
    }

    @PutMapping("/empleados")
    public Empleados update(@RequestBody Empleados empleado){ // requestbody para pedir todos los atributos
        return empleadosService.update(empleado);
    }

    @DeleteMapping("/departamentos")
    public void delete(@RequestBody Empleados empleado){
        empleadosService.delete(empleado);
    }
}
