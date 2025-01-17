package com.example.tienda.service;

import com.example.tienda.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    public List<Pedido> readAll();
    public Optional<Pedido> readById(int id);
    public Pedido create (Pedido pedido);
    public Pedido update (Pedido pedido);
    public void delete (Pedido pedido);
}