package com.example.tiendainn13.service;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    public List<Pedido> readAll();
    public Optional<Pedido> readById(int id);
    public Pedido create (Pedido pedido);
    public Pedido update (Pedido pedido);
    public String delete (Pedido pedido);
    public List<Pedido> buscarPorTotalPedido(Integer tPedido);

}
