package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.repository.IInventarioRepository;
import com.example.tiendainn13.response.InventarioResponse;
import com.example.tiendainn13.service.IInventarioService;
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
        InventarioResponse inventarioResponse = new InventarioResponse(inventario.getProducto(),inventario.getCantidadStockInve());
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
