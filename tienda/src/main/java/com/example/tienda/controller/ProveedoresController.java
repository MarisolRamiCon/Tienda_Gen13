package com.example.tienda.controller;

import com.example.tienda.entity.Proveedores;
import com.example.tienda.response.ProveedoresResponse;
import com.example.tienda.service.impl.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4")

public class ProveedoresController {
    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping("/proveedores")
    public List<Proveedores> readAll() {
        return proveedoresService.readAll();
    }

    @GetMapping("/proveesor/{id}")
    public Optional<Proveedores> readById(@PathVariable int id){
        return proveedoresService.readById(id);
    }

    @PostMapping("/proveedores")
    public ProveedoresResponse create(@RequestBody Proveedores proveedor){ // requestbody para pedir todos los atributos
        return proveedoresService.create(proveedor);
    }

    @PutMapping("/proveedores")
    public Proveedores update(@RequestBody Proveedores proveedor){ // requestbody para pedir todos los atributos
        return proveedoresService.update(proveedor);
    }

    @DeleteMapping("/proveedores")
    public void delete(@RequestBody Proveedores proveedor){
        proveedoresService.delete(proveedor);
    }
}
