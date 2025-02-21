package com.example.tiendainn13.repository;

import com.example.tiendainn13.entity.Producto;
import com.example.tiendainn13.response.ProductoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepository  extends JpaRepository<Producto, Integer> {
    //JPA Hibernate busqueda por atributos
    public List<Producto> findByNombreProducto(String nombreProducto);
    public List<Producto> findByNombreProductoAndPrecioProducto(String nombreProducto, Double precioProducto);

    //JPA Query
    // Que el precio del producto sea menor a
    @Query(value = "SELECT * from productos where precio_p<:precio_p && stock<:stock",  nativeQuery = true)
    public List<Producto> precioMenor (Double precio_p, Integer stock);


}
