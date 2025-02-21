package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    //JPA hibernate busqueda por atributos
    public List<Pedido> findByTotalPedido(Integer totalPedido);

    //jpa Query
    @Query(value = "SELECT * FROM pedidos WHERE total_pe<:total_pe", nativeQuery = true)
    public List<Pedido> findByTotalPedidoMenorA(Integer total_pe);

}

