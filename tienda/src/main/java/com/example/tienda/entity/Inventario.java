package com.example.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @Column(name = "id_inventario")
    private Integer idInventario;

    @Column(name = "producto")
    private Integer productoIn;

    @Column(name = "cantidad_stock")
    private Integer cantidadStockInve;

    public Inventario() {
    }

    public Inventario(Integer idInventario, Integer productoIn, Integer cantidadStockInve) {
        this.idInventario = idInventario;
        this.productoIn = productoIn;
        this.cantidadStockInve = cantidadStockInve;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getProductoIn() {
        return productoIn;
    }

    public void setProductoIn(Integer productoIn) {
        this.productoIn = productoIn;
    }

    public Integer getCantidadStockInve() {
        return cantidadStockInve;
    }

    public void setCantidadStockInve(Integer cantidadStockInve) {
        this.cantidadStockInve = cantidadStockInve;
    }
}
