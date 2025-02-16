package com.example.tiendainn13.controller;

import com.example.tiendainn13.response.Pelicula;
import com.example.tiendainn13.service.impl.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PeliculaController {
    //Apis con los metodos crud consumiendo apis de terceros
    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/mostrar/peliculas")
    public List<Pelicula> readAll(){
        return peliculaService.readAll();
    }

    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> readById(@PathVariable Long id){
        return peliculaService.readById(id);
    }

    @PostMapping("/crear/peliculas")
    public Pelicula postData(@RequestBody Pelicula peliculaCreada) {
        return peliculaService.postData(peliculaCreada);
    }



    @PutMapping("/actualizar/pelicula/{id}")
    public Optional<Pelicula> update(@PathVariable("id") Long id, @RequestBody Pelicula peliculaActualizada) {
        return peliculaService.update(id, peliculaActualizada);
    }

    @DeleteMapping("/borrar/pelicula/{id}")
    public void delete(@PathVariable("id") Long id) {
         peliculaService.delete(id);
        System.out.println("Se elimino la pelicula con id: " + id);

    }
}
