package com.example.tiendainn13.service;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.entity.Pedido;
import com.example.tiendainn13.response.PedidoResponse;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    public List<Pedido> readAll();
    public Optional<Pedido> readById(int id);
    public PedidoResponse create (Pedido pedido);
    public PedidoResponse update (Pedido pedido);
    public String delete (Pedido pedido);
    public List<Pedido> buscarPorTotalPedido(Integer tPedido);
    public List<Pedido> totalPedidoMenorA(Integer totalPedido);

}
