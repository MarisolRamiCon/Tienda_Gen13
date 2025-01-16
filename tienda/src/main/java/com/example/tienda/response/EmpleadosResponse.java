package com.example.tienda.response;

public class EmpleadosResponse {
    private String nombre;
    private String puesto;

    public EmpleadosResponse() {
    }

    public EmpleadosResponse(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
