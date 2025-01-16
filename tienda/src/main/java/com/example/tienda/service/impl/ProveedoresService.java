package com.example.tienda.service.impl;

import com.example.tienda.entity.Proveedores;
import com.example.tienda.repository.ProveedoresRepository;
import com.example.tienda.response.ProveedoresResponse;
import com.example.tienda.service.IProveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService implements IProveedores {
    @Autowired
    ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> readAll() {
        return proveedoresRepository.findAll().stream().filter(proveedor->proveedor.getActive() ==true).toList();
    }

    @Override
    public Optional<Proveedores> readById(int id) {
        Optional<Proveedores> proveedor = proveedoresRepository.findById(id);
        return proveedor;
    }

    @Override
    public ProveedoresResponse create(Proveedores proveedor) {
        proveedoresRepository.save(proveedor);

        ProveedoresResponse proveedoresResponse = new ProveedoresResponse(proveedor.getNombreEmpresa(), proveedor.getContacto(), proveedor.getCorreoElectronico(), proveedor.getTelefono());
        return proveedoresResponse;
    }

    @Override
    public Proveedores update(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    public void delete(Proveedores proveedor) {
        Optional<Proveedores> proveedoresOptional = proveedoresRepository.findById(proveedor.getIdProveedor());
        if (proveedoresOptional.isPresent()){
            Proveedores proveedorABorrar = proveedoresOptional.get();
            proveedorABorrar.setActive(false);
            System.out.println("El proveedor ha sido borrado satisfactoriamente");
            proveedoresRepository.save(proveedorABorrar);
        } else{
            System.out.println("El proveedor con id no existe");
        }
    }
}
