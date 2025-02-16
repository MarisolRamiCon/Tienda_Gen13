package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.feign.PeliculaClient;
import com.example.tiendainn13.response.Pelicula;
import com.example.tiendainn13.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    PeliculaClient peliculaClient;

    @Override
    public List<Pelicula> readAll() {
        return peliculaClient.getData();
    }

    @Override
    public Optional<Pelicula> readById(Long id) {
        Optional<Pelicula> pelicula = peliculaClient.readById(id);
        return pelicula;
    }

    @Override
    public Pelicula postData(Pelicula peliculaCreada) {
        return peliculaClient.postData(peliculaCreada);
    }

    public PeliculaService(PeliculaClient peliculaClient) {
        this.peliculaClient = peliculaClient;
    }
    @Override
        public Optional<Pelicula> update(Long id, Pelicula peliculaActualizada) {
            return peliculaClient.update(id, peliculaActualizada);
        }


    @Override
    public void delete(Long id) {
        peliculaClient.delete(id);
    }


}
