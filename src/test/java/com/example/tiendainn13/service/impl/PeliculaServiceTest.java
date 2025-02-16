package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.feign.PeliculaClient;
import com.example.tiendainn13.response.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PeliculaServiceTest {

    @Mock
    private PeliculaClient peliculaClient;

    @InjectMocks
    private PeliculaService peliculaService;

    @BeforeEach
    void setUp(){
        // Configuración inicial si es necesaria
    }
    //Listar Peliculas
    @Test
    void readAll() {
        Pelicula pelicula1 = new Pelicula(1L, "Pelicula 1", "Genero Pelicla1", "2025");
        Pelicula pelicula2 = new Pelicula( 2L,"Pelicula 2", "Genero Pelicula2", "2025");
        List<Pelicula> peliculas = Arrays.asList(pelicula1, pelicula2);

        when(peliculaClient.getData()).thenReturn(peliculas);

        List<Pelicula> resultado = peliculaService.readAll();

        assertEquals(2, resultado.size());
        assertEquals("Pelicula 1", resultado.get(0).getNombre());
        assertEquals("Pelicula 2", resultado.get(1).getNombre());
    }

    //Listar PeliculaPorId
    @Test
    void readByIdWhenPeliculaExists(){
        Long peliculaId = 1L;
        Pelicula pelicula = new Pelicula(peliculaId, "Pelicula 1", "Genero Pelicula 1", "2025");
        // Simula el comportamiento de peliculaClient.readById()
        when(peliculaClient.readById(peliculaId)).thenReturn(Optional.of(pelicula));

        Optional<Pelicula> resultado = peliculaService.readById(peliculaId);

        assertTrue(resultado.isPresent()); // Verifica que el Optional contenga un valor
        assertEquals(peliculaId, resultado.get().getId());
        assertEquals("Pelicula 1", resultado.get().getNombre());
    }

    @Test
    void readByIdWhenPeliculaDoesNotExist(){
        Long peliculaId = 999L; //Id que no existe
        when(peliculaClient.readById(peliculaId)).thenReturn(Optional.empty());
        Optional<Pelicula> resultado = peliculaService.readById(peliculaId);
        assertTrue(resultado.isEmpty());// verifica que el optional este vacio
    }

    //Crear pelicula
    @Test
    void postData(){
        Pelicula peliculaCreada  = new Pelicula(1L, "Pelicula creada 1", "terror", "2025");
        Pelicula peliculaRespuesta = new Pelicula();
        peliculaRespuesta.setNombre("Pelicula creada 1");
        peliculaRespuesta.setGenero("terror");

        when(peliculaClient.postData(peliculaCreada)).thenReturn(peliculaRespuesta);
        Pelicula resultado = peliculaService.postData(peliculaCreada);

        assertEquals(peliculaRespuesta.getId(), resultado.getId());
        assertEquals(peliculaRespuesta.getNombre(), resultado.getNombre());
    }

    //Actualizar pelicula
    @Test
    void updateWhenPeliculaExists(){
        Long peliculaId = 1L;
        Pelicula peliculaActualizada = new Pelicula(peliculaId, "Pelicula Actualizada", "Terror", "2025");
        Pelicula peliculaRespuesta = new Pelicula(peliculaId, "Pelicula Actualizada", "Terror", "2025");

        when(peliculaClient.update(peliculaId,peliculaActualizada)).thenReturn(Optional.of(peliculaRespuesta));

        Optional<Pelicula> resultado = peliculaService.update(peliculaId, peliculaActualizada);

        assertTrue(resultado.isPresent());
        assertEquals(peliculaId, resultado.get().getId());
        assertEquals("Pelicula Actualizada", resultado.get().getNombre());
    }

    @Test
    void updateWhenPeliculaDoesNotExist() {
        Long peliculaId = 999L;
        Pelicula peliculaActualizada = new Pelicula(peliculaId, "Pelicula Actualizada", "Terror", "2025");

        when(peliculaClient.update(peliculaId, peliculaActualizada)).thenReturn(Optional.empty());

        Optional<Pelicula> resultado = peliculaService.update(peliculaId, peliculaActualizada);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deletePelicula(){
        Long peliculaId = 1L;

        peliculaService.delete(peliculaId);

        verify(peliculaClient, times(1)).delete(peliculaId);
    }
}