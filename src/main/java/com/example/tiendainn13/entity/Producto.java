package com.example.tiendainn13.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "id_p")
    private Integer idProducto;

    @Column(name = "nombre_p")
    private String nombreProducto;

    @Column(name = "descripcion_p")
    private String descripcionProducto;

    @Column(name = "precio_p")
    private  Double precioProducto;

    @Column(name = "categoria_p")
    private String categoriaProducto;

    @Column(name = "proveedor_p")
    private Integer proveedorProducto;

    @Column(name = "stock")
    private Integer stockProducto;


}
