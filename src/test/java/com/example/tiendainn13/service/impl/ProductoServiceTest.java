package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Producto;
import com.example.tiendainn13.repository.IProductoRepository;
import com.example.tiendainn13.response.ProductoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {
    @Mock
    private IProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp(){
        //configuracion inicial si es necesaria
    }

    @Test
    void readAll() { //Listar Productos
        Producto producto1 = new Producto(1, "Galletas marias", "Marias Gamesa", 25.25, "Alimentos", 1, 20);
        Producto producto2 = new Producto(2, "Papas adobadas", "Sabritas", 18.20, "Frituras", 3, 40);
        List<Producto> productos = Arrays.asList(producto1, producto2);

        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = productoService.readAll();

        assertEquals(2, resultado.size());
        assertEquals("Galletas marias", resultado.get(0).getNombreProducto());
        assertEquals("Papas adobadas", resultado.get(1).getNombreProducto());
    }

    @Test
    void readByIdWhenProductoExists() {
        int idProducto = 1;
        Producto producto = new Producto(idProducto, "Producto 1", "Gamesa", 23.23, "Alimentos", 1, 20);
        when(productoRepository.findById(idProducto)).thenReturn(Optional.of(producto));

        Optional<Producto> resultado = productoService.readById(idProducto);

        assertTrue(resultado.isPresent()); //Verifica que el oprional contenga un valor
        assertEquals(idProducto, resultado.get().getIdProducto());
        assertEquals("Producto 1", resultado.get().getNombreProducto());
    }

    @Test
    void readByIdWhenProductoDoesNotExist(){
        int idProducto = 999; //Id que no existe
        when(productoRepository.findById(idProducto)).thenReturn(Optional.empty());
        Optional<Producto> resultado = productoService.readById(idProducto);
        assertTrue(resultado.isEmpty());// Verifica que el optional este vacio
    }

    @Test
    void create() {
        Producto productoCreado = new Producto(1, "Powerade", "Bebida Hidratante", 20.50, "Bebidad", 1, 50);
        ProductoResponse productoRespuestaEsperado = new ProductoResponse("Powerade", 20.50);

        when(productoRepository.save(productoCreado)).thenReturn(productoCreado);

        ProductoResponse productoResponse = productoService.create(productoCreado);

        assertEquals(productoRespuestaEsperado.getNombreProducto(), productoResponse.getNombreProducto());
        assertEquals(productoRespuestaEsperado.getPrecioProducto(), productoResponse.getPrecioProducto());
        //Verifica que se llamo a productoRepository.save() con el producto correcto
        verify(productoRepository, times(1)).save(productoCreado);
    }


    @Test
    void updateWhenProductoExists() {
        int idProducto = 1;
        Producto productoActualizado = new Producto(idProducto, "Coca Cola", "Bebida de sabor", 50.00, "Bebidas", 4, 30);
        ProductoResponse productoRespuesta = new ProductoResponse("Coca Cola", 50.00);

        when(productoRepository.save(productoActualizado)).thenReturn(productoActualizado);

        ProductoResponse productoResponse = productoService.update(productoActualizado);

        assertEquals(productoRespuesta.getNombreProducto(), productoResponse.getNombreProducto());
        assertEquals(productoRespuesta.getPrecioProducto(), productoResponse.getPrecioProducto());
        verify(productoRepository, times(1)).save(productoActualizado);
    }
    @Test
    void updateWhenProductoDoesNotExist(){
        int idProducto = 999;
        Producto productoActualizado = new Producto(idProducto, "Coca Cola", "Bebida dde sabor", 50.0, "bebida", 3, 30);
        ProductoResponse productoRespuestaEsperado = new ProductoResponse("Coca Cola", 50.0);
        when(productoRepository.save(productoActualizado)).thenReturn(productoActualizado);

        ProductoResponse productoResponse = productoService.update(productoActualizado);

        assertEquals(productoRespuestaEsperado.getNombreProducto(), productoResponse.getNombreProducto());
        assertEquals(productoRespuestaEsperado.getPrecioProducto(), productoResponse.getPrecioProducto());
        verify(productoRepository, times(1)).save(productoActualizado);
    }

    @Test
    void delete() {
        Producto producto = new Producto(1,"Aceite Patrona", "Producto para cocina", 15.23, "De uso domestico", 3, 45);
        productoService.delete(producto);

        verify(productoRepository, times(1)).delete(producto);
    }

    @Test
    void precioMenor() {
        double precioP = 100.0;
        int stock = 10;

        Producto producto1 = new Producto(1, "Producto1", "Descripcion producto1", 50.0, "Categoria Producto1", 15, 15);
        Producto producto2 = new Producto(2, "Producto2", "Descripcion producto2", 80.0, "Categoria Producto2", 20, 20);
        List<Producto> productosEsperados = Arrays.asList(producto1, producto2);

        //Simula el comportamiento de productoRepository.precioMenor()
        when(productoRepository.precioMenor(precioP, stock)).thenReturn(productosEsperados);

//        Act: Se llama al metodo precioMenor(precioP, stock) del servicio
        List<Producto> productos = productoService.precioMenor(precioP, stock);

        //Assert: Se verifica que la lista devuelta tenga el tamaño esperado (2 productos) y que los nombres de los productos coincidan con los datos simulados.
        assertEquals(2, productos.size()); //Verifica que la lista tenga dos productos
        assertEquals("Producto1", productos.get(0).getNombreProducto());
        assertEquals("Producto2", productos.get(1).getNombreProducto());
    }
}