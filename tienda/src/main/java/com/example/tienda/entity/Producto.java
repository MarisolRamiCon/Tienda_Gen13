package com.example.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



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

    public Producto() {
    }

    public Producto(Integer idProducto, String nombreProducto, String descripcionProducto,
                    String categoriaProducto, Double precioProducto, Integer proveedorProducto,
                    Integer stockProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioProducto = precioProducto;
        this.proveedorProducto = proveedorProducto;
        this.stockProducto = stockProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Integer getProveedorProducto() {
        return proveedorProducto;
    }

    public void setProveedorProducto(Integer proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stockProducto = stockProducto;
    }
}
