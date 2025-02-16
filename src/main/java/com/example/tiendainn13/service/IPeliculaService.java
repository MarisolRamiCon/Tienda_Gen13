package com.example.tiendainn13.service;

import com.example.tiendainn13.response.Pelicula;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {
    public List<Pelicula> readAll();
    public Optional<Pelicula> readById(Long id);
    public Pelicula postData(Pelicula peliculaCreada);
    public Optional<Pelicula> update(Long id, Pelicula peliculaActualizada);
    public void delete(Long id);
}
