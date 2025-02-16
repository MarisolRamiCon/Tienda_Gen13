package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Pedido;
import com.example.tiendainn13.repository.IPedidoRepository;
import com.example.tiendainn13.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {
    @Autowired
    IPedidoRepository pedidoRepository;
    @Override
    public List<Pedido> readAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> readById(int id) {
        Optional<Pedido>  pedido = pedidoRepository.findById(id);
        return pedido;
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        pedidoRepository.delete(pedido);
    }


}
