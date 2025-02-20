package com.example.tiendainn13.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "es_activo")
    private Boolean esActivo = true;


}
