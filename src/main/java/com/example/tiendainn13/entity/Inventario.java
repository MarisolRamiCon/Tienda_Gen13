package com.example.tiendainn13.entity;

import com.example.tiendainn13.response.ProductoResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer idInventario;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "id_p")
    private Producto producto;

//    @Column(name = "producto")
//    private Integer productoIn;

    @Column(name = "cantidad_stock")
    private Integer cantidadStockInve;



}
