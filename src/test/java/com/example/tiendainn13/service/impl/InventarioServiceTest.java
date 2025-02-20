package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.entity.Producto;
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
    Producto producto1 = new Producto(1, "Galletas Marias", "Gamesa", 23.20, "Alimentos", 1, 30, true);
    Producto producto2 = new Producto(2, "Powerade", "Hidratante", 34.12, "Bebida", 4, 23, true);

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

        Inventario inventario1 = new Inventario(1,producto1,30, true);
        Inventario inventario2 = new Inventario(2, producto2, 40, true);
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
        Inventario inventario = new Inventario(1, producto2, 3, true);
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
        Inventario inventarioCreado = new Inventario(1,producto2,25, true);
        Inventario inventarioRespuesta = new Inventario(1,producto2,25, true);

        when(iInventarioRepository.save(inventarioCreado)).thenReturn(inventarioRespuesta);
        InventarioResponse inventarioResultado = inventarioService.create(inventarioCreado);

        assertEquals(inventarioRespuesta.getProducto(), inventarioResultado.getProducto());
        assertEquals(inventarioRespuesta.getCantidadStockInve(), inventarioResultado.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioCreado);


    }

    @Test
    void updateWhenInventarioExists() {
        int idInventario = 1;
        Inventario inventarioActualizado = new Inventario(idInventario,producto2,26, true);
        InventarioResponse inventarioRespuesta = new InventarioResponse(producto2, 26);

        when(iInventarioRepository.save(inventarioActualizado)).thenReturn(inventarioActualizado);

        Inventario inventarioResponse = inventarioService.update(inventarioActualizado);

        assertEquals(inventarioRespuesta.getProducto(), inventarioResponse.getProducto());
        assertEquals(inventarioRespuesta.getCantidadStockInve(), inventarioResponse.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioActualizado);
    }

    @Test
    void updateWhenInventarioDoesNotExist(){
        int idInventario = 999;
        Inventario inventarioActualizado = new Inventario(idInventario, producto2, 50, true);
        InventarioResponse inventarioRespuestaEs = new InventarioResponse(producto2, 50);
        when(iInventarioRepository.save(inventarioActualizado)).thenReturn(inventarioActualizado);

        Inventario inventarioResponse = inventarioService.update(inventarioActualizado);

        assertEquals(inventarioRespuestaEs.getProducto(), inventarioResponse.getProducto());
        assertEquals(inventarioRespuestaEs.getCantidadStockInve(), inventarioResponse.getCantidadStockInve());
        verify(iInventarioRepository, times(1)).save(inventarioActualizado);
    }


    @Test
    void delete() {
        Inventario inventario = new Inventario(1,producto2,30, true);
        inventarioService.delete(inventario);

        verify(iInventarioRepository, times(1)).delete(inventario);
    }
}