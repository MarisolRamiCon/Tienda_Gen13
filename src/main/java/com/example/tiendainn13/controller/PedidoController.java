package com.example.tiendainn13.controller;

import com.example.tiendainn13.entity.Pedido;
import com.example.tiendainn13.service.impl.PedidoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> readAll(){
        return pedidoService.readAll();
    }

    @GetMapping("/mostrar/pedidos/{id}")
    public Optional<Pedido> readById(@PathVariable int id){
        return pedidoService.readById(id);
    }


    @PostMapping("/crear/pedido")
    public Pedido create(@RequestBody Pedido pedido){
        return pedidoService.create(pedido);
    }

    @PutMapping("/actualizar/pedido")
    public Pedido update(@RequestBody Pedido pedido){
        return pedidoService.update(pedido);
    }

    @DeleteMapping("/eliminar/pedido")
    public void delete(@RequestBody Pedido pedido){
        pedidoService.delete(pedido);
    }
}
