package com.example.tiendainn13.response;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Pelicula {
    private Long id;
    private String nombre;
    private String genero;
    private String aPublicacion;

    Pelicula(String nombre, String genero){
        this.nombre = nombre;
        this.genero = genero;
    }
}
