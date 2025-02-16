package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {


}

