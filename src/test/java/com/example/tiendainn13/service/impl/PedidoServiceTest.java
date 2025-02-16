package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Pedido;
import com.example.tiendainn13.repository.IPedidoRepository;
import com.example.tiendainn13.service.IPedidoService;
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
class PedidoServiceTest {
    @Mock
    private IPedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    void setUp(){
        //configuracion inicial si es necesaria
    }

    @Test
    void readAll() {
        Pedido pedido1 = new Pedido(1, "2025-01-11", 2, 3);
        Pedido pedido2 = new Pedido(2, "2025-02-14", 3,4);
        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

        when(pedidoRepository.findAll()).thenReturn(pedidos);

        List<Pedido> resultado = pedidoService.readAll();

        assertEquals(2, resultado.size());
        assertEquals("2025-01-11", resultado.get(0).getFechaPedido());
        assertEquals("2025-02-14", resultado.get(1).getFechaPedido());
    }

    @Test
    void readByIdWhenPedidoExists() {
        int idPedido = 1;
        Pedido pedido = new Pedido(idPedido, "2025-02-14", 1, 3);
        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.of(pedido));

        Optional<Pedido> resultado = pedidoService.readById(idPedido);

        assertTrue(resultado.isPresent());
        assertEquals("2025-02-14", resultado.get().getFechaPedido());
        assertEquals(3, resultado.get().getTotalPedido());
    }

    @Test
    void readByIdPedidoWhenDoesNotExist(){
        int idPedido = 999;
        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.empty());
        Optional<Pedido> resultado = pedidoService.readById(idPedido);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void create() {
        Pedido pedidoCreado = new Pedido(1, "2025-02-14", 2, 3);
        Pedido pedidoRespuestaEs = new Pedido(1, "2025-02-14", 2,3);

        when(pedidoRepository.save(pedidoCreado)).thenReturn(pedidoCreado);

        Pedido pedidoResponse = pedidoService.create(pedidoCreado);

        assertEquals(pedidoRespuestaEs.getFechaPedido(), pedidoResponse.getFechaPedido());
        assertEquals(pedidoRespuestaEs.getTotalPedido(), pedidoResponse.getTotalPedido());
        verify(pedidoRepository, times(1)).save(pedidoCreado);
    }

    @Test
    void updateWhenPedidoExists() {
        int idPedido = 1;
        Pedido pedidoActualizado = new Pedido(idPedido, "2025-02-14", 2,30);
        Pedido pedidoRespuesta = new Pedido(idPedido, "2025-02-14", 2, 30);

        when(pedidoRepository.save(pedidoActualizado)).thenReturn(pedidoActualizado);

        Pedido pedidoResponse = pedidoService.update(pedidoActualizado);

        assertEquals(pedidoRespuesta.getFechaPedido(), pedidoResponse.getFechaPedido());
        assertEquals(pedidoRespuesta.getClientePedido(), pedidoResponse.getClientePedido());
        verify(pedidoRepository, times(1)).save(pedidoActualizado);
    }

    @Test
    void updateWhenPedidoDoesNotExist(){
        int idPedido = 999;
        Pedido pedidoActualizado = new Pedido(idPedido, "2025-01-28", 1,30);
        Pedido pedidoRespuestaEs = new Pedido(idPedido, "2025-01-28", 1, 30);
        when(pedidoRepository.save(pedidoActualizado)).thenReturn(pedidoActualizado);

        Pedido pedidoResponse = pedidoService.update(pedidoActualizado);

        assertEquals(pedidoRespuestaEs.getFechaPedido(), pedidoResponse.getFechaPedido());
        assertEquals(pedidoRespuestaEs.getIdPedido(), pedidoResponse.getIdPedido());
        verify(pedidoRepository, times(1)).save(pedidoActualizado);
    }

    @Test
    void delete() {
        Pedido pedido = new Pedido(1, "2025-02-14", 2,24);
        pedidoService.delete(pedido);
        verify(pedidoRepository, times(1)).delete(pedido);
    }
}