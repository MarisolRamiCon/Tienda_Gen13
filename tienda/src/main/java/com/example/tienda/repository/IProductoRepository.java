package com.example.tienda.repository;

import com.example.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepository  extends JpaRepository<Producto, Integer> {
    //Que el precio del producto sea menor a
    @Query(value = "SELECT * from productos where precio_p<:precio_p",  nativeQuery = true)
    public List<Producto> precioMenor (Double precio_p);


}
