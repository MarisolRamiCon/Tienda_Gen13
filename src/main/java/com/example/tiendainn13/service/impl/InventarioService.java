package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Inventario;
import com.example.tiendainn13.repository.IInventarioRepository;
import com.example.tiendainn13.response.InventarioResponse;
import com.example.tiendainn13.service.IInventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InventarioService implements IInventarioService {
    @Autowired
    IInventarioRepository iInventarioRepository;
    @Override
    public List<Inventario> readAll() {
        return iInventarioRepository.findAll().stream().filter(inventario -> inventario.getEsActivo()==true).toList();
    }

    @Override
    public Optional<Inventario> readById(int id) {
        Optional<Inventario> inventario = iInventarioRepository.findById(id);
        return inventario;
    }

    @Override
    public InventarioResponse create(Inventario inventario) {
        iInventarioRepository.save(inventario);
        InventarioResponse inventarioResponse = new InventarioResponse(inventario.getCantidadStockInve());
        return inventarioResponse;
    }

    @Override
    public InventarioResponse update(Inventario inventario) {
        iInventarioRepository.save(inventario);
        InventarioResponse inventarioResponse = new InventarioResponse(inventario.getCantidadStockInve());
        return inventarioResponse;
    }

    @Override
    public String delete(Inventario inventario) {
        Optional<Inventario> inventarioOptional = iInventarioRepository.findById(inventario.getIdInventario());
        if (inventarioOptional.isPresent()){
            Inventario inventarioABorrar = inventarioOptional.get();
            inventarioABorrar.setEsActivo(false);
            try{
                iInventarioRepository.save(inventarioABorrar);
                log.info("El Inventario ha sido borrado");
                return "El Inventario ha sido borrado satisfactoriamente";
            }catch (Exception e){
                log.error("Error " + e.getMessage());
                log.error("Rastreo: " + e.getStackTrace());
                return  "Hubo un error en la base de datos";
            }
        }else {
            log.info("El inventario no existe");
            return "El inventario no existe";
        }
    }

    @Override
    public List<Inventario> buscarPorCantidadStockInve(Integer stock) {
        return iInventarioRepository.findByCantidadStockInve(stock);
    }
}
