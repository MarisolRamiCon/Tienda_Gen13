package com.example.tiendainn13.response;

import com.example.tiendainn13.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioResponse {
    private Producto producto;
    private Integer cantidadStockInve;


}
