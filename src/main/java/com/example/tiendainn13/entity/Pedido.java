package com.example.tiendainn13.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name =  "id_pedido")
    private  Integer idPedido;

    @Column(name = "fecha_pedido")
    private  String fechaPedido;

    @Column(name = "cliente_pe")
    private Integer clientePedido;

    @Column(name = "total_pe")
    private Integer totalPedido;

    public Pedido() {
    }

    public Pedido(Integer idPedido, String fechaPedido, Integer clientePedido, Integer totalPedido) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.clientePedido = clientePedido;
        this.totalPedido = totalPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Integer getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Integer clientePedido) {
        this.clientePedido = clientePedido;
    }

    public Integer getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Integer totalPedido) {
        this.totalPedido = totalPedido;
    }
}
