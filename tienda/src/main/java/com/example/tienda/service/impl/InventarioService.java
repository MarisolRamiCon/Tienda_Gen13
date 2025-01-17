package com.example.tienda.service.impl;

import com.example.tienda.entity.Inventario;
import com.example.tienda.repository.IInventarioRepository;
import com.example.tienda.response.InventarioResponse;
import com.example.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventarioService {
    @Autowired
    IInventarioRepository iInventarioRepository;

    @Override
    public List<Inventario> readAll() {
        return iInventarioRepository.findAll();
    }

    @Override
    public Optional<Inventario> readById(int id) {
        Optional<Inventario> inventario = iInventarioRepository.findById(id);
        return inventario;
    }

    @Override
    public InventarioResponse create(Inventario inventario) {
        iInventarioRepository.save(inventario) ;
        InventarioResponse inventarioResponse = new InventarioResponse(inventario.getCantidadStockInve());
        return inventarioResponse;
    }

    @Override
    public Inventario update(Inventario inventario) {
        return iInventarioRepository.save(inventario);
    }

    @Override
    public void delete(Inventario inventario) {
        iInventarioRepository.delete(inventario);
    }
}
