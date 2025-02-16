package com.example.tiendainn13.feign;

import com.example.tiendainn13.response.Pelicula;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Peliculas", url = "https://6791d401cf994cc680479068.mockapi.io/api/v1/peliculas")
public interface PeliculaClient {
    @GetMapping("/peliculas")
    public List<Pelicula> getData();

    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> readById(@PathVariable("id") Long id);

    @PostMapping("/peliculas")
    public Pelicula postData(@RequestBody Pelicula peliculaCreada);

    @PutMapping("/peliculas/{id}")
    public Optional<Pelicula> update(@PathVariable("id") Long id, @RequestBody Pelicula peliculaActualizada);

    @DeleteMapping("/peliculas/{id}")
    public void delete(@PathVariable("id") Long id);

}
