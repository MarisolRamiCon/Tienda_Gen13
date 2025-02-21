package com.example.tiendainn13.controller;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.response.InventarioResponse;
import com.example.tiendainn13.service.impl.InventarioService;
import jakarta.websocket.server.PathParam;
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

    @GetMapping("/buscar/stock")
    public List<Inventario> buscarPorCantidadStockInve(@PathParam("cantidadStockInve") Integer stock){
        return inventarioService.buscarPorCantidadStockInve(stock);
    }

    //Mostrar si es activo o no y candidad stock menor a
    @GetMapping("/mostrar/esactivo")
    public List<Inventario> buscarEsActivoYCantidadStock(@PathParam("es_activo") Boolean activo, @PathParam("cantidad_stock") Integer stock){
        return inventarioService.buscarEsActivoYCantidadStock(activo, stock);
    }

    @PostMapping("/crear/inventario")
    public InventarioResponse create(@RequestBody Inventario inventario){
        return  inventarioService.create(inventario);
    }

    @PutMapping("/actualizar/inventario")
    public InventarioResponse update(@RequestBody Inventario inventario){
        return inventarioService.update(inventario);
    }

    @DeleteMapping("/eliminar/inventario")
    public String  delete(@RequestBody Inventario inventario){
         return inventarioService.delete(inventario);
    }
}
