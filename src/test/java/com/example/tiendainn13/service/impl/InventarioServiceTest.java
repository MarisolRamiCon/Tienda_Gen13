package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.repository.IInventarioRepository;
import com.example.tiendainn13.response.InventarioResponse;
import com.example.tiendainn13.service.IProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventarioServiceTest {

    @Mock
    private IInventarioRepository iInventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    @BeforeEach
    void setUp(){
        //Configuracion inicial si es necesaria
    }

    @Test
    void readAll() {
        Inventario inventario1 = new Inventario(1, 1,30);
        Inventario inventario2 = new Inventario(2, 2, 40);
        List<Inventario> inventarios = Arrays.asList(inventario1, inventario2);

        when(iInventarioRepository.findAll()).thenReturn(inventarios);

        List<Inventario> resultado = inventarioService.readAll();

        assertEquals(2, resultado.size());
        assertEquals(1, resultado.get(0).getIdInventario());
        assertEquals(2, resultado.get(1).getIdInventario());
    }

    @Test
    void readByIdWhenInventarioExists() {
        int idInventario = 1;
        Inventario inventario = new Inventario(1, 2, 3);
        when(iInventarioRepository.findById(idInventario)).thenReturn(Optional.of(inventario));

        Optional<Inventario> resultado = inventarioService.readById(idInventario);

        assertTrue(resultado.isPresent());
        assertEquals(idInventario, resultado.get().getIdInventario());
        assertEquals(3, resultado.get().getCantidadStockInve());
    }

    @Test
    void readByIdWhenInventarioDoesNotExist(){
        int idInventario = 999;
        when(iInventarioRepository.findById(idInventario)).thenReturn(Optional.empty());
        Optional<Inventario> resultado = inventarioService.readById(idInventario);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void create() {
        Inventario inventarioCreado = new Inventario(1,2,25);
        Inventario inventarioRespuesta = new Inventario(1,2,25);

        when(iInventarioRepository.save(inventarioCreado)).thenReturn(inventarioRespuesta);
        InventarioResponse inventarioResultado = inventarioService.create(inventarioCreado);

        assertEquals(inventarioRespuesta.getProductoIn(), inventarioResultado.getProductoIn());
        assertEquals(inventarioRespuesta.getCantidadStockInve(), inventarioResultado.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioCreado);


    }

    @Test
    void updateWhenInventarioExists() {
        int idInventario = 1;
        Inventario inventarioActualizado = new Inventario(idInventario,2,26);
        InventarioResponse inventarioRespuesta = new InventarioResponse(2, 26);

        when(iInventarioRepository.save(inventarioActualizado)).thenReturn(inventarioActualizado);

        Inventario inventarioResponse = inventarioService.update(inventarioActualizado);

        assertEquals(inventarioRespuesta.getProductoIn(), inventarioResponse.getProductoIn());
        assertEquals(inventarioRespuesta.getCantidadStockInve(), inventarioResponse.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioActualizado);
    }

    @Test
    void updateWhenInventarioDoesNotExist(){
        int idInventario = 999;
        Inventario inventarioActualizado = new Inventario(idInventario, 2, 50);
        InventarioResponse inventarioRespuestaEs = new InventarioResponse(2, 50);
        when(iInventarioRepository.save(inventarioActualizado)).thenReturn(inventarioActualizado);

        Inventario inventarioResponse = inventarioService.update(inventarioActualizado);

        assertEquals(inventarioRespuestaEs.getProductoIn(), inventarioResponse.getProductoIn());
        assertEquals(inventarioRespuestaEs.getCantidadStockInve(), inventarioResponse.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioActualizado);
    }


    @Test
    void delete() {
        Inventario inventario = new Inventario(1,2,30);
        inventarioService.delete(inventario);

        verify(iInventarioRepository, times(1)).delete(inventario);
    }
}