package com.example.tiendainn13.controller;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.response.InventarioResponse;
import com.example.tiendainn13.service.impl.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class InventarioController {
    @Autowired
    InventarioService inventarioService;

    @GetMapping("/inventario")
    public List<Inventario> readAll(){
        return  inventarioService.readAll();
    }

    @GetMapping("/mostrar/inventario/{id}")
    public Optional<Inventario> readById(@PathVariable int id){
        return inventarioService.readById(id);
    }

    @PostMapping("/crear/inventario")
    public InventarioResponse create(@RequestBody Inventario inventario){
        return  inventarioService.create(inventario);
    }

    @PutMapping("/actualizar/inventario")
    public Inventario update(@RequestBody Inventario inventario){
        return inventarioService.update(inventario);
    }

    @DeleteMapping("/eliminar/inventario")
    public void  delete(@RequestBody Inventario inventario){
         inventarioService.delete(inventario);
    }
}
