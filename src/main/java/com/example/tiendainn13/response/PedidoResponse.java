package com.example.tiendainn13.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
    private String fechaPedido;
    private Integer clientePedido;
}
