package com.example.tiendainn13.response;

public class InventarioResponse {
    private Integer cantidadStockInve;

    public InventarioResponse() {
    }

    public InventarioResponse(Integer cantidadStockInve) {
        this.cantidadStockInve = cantidadStockInve;
    }

    public Integer getCantidadStockInve() {
        return cantidadStockInve;
    }

    public void setCantidadStockInve(Integer cantidadStockInve) {
        this.cantidadStockInve = cantidadStockInve;
    }
}
