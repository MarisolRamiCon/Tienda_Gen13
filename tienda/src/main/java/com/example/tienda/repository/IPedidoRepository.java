package com.example.tienda.repository;

import com.example.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}
