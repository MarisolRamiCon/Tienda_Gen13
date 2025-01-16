package com.example.tienda.service.impl;

import com.example.tienda.repository.EmpleadosRepository;
import com.example.tienda.entity.Empleados;
import com.example.tienda.response.EmpleadosResponse;
import com.example.tienda.service.IEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService implements IEmpleados {
    @Autowired
    EmpleadosRepository empleadosRepository;


    @Override
    public List<Empleados> readAll() {
        return empleadosRepository.findAll().stream().filter(empleados -> empleados.getActive() == true).toList();
    }

    @Override
    public Optional<Empleados> readById(int id) {
        Optional<Empleados> empleados = empleadosRepository.findById(id);
        return empleados;
    }

    @Override
    public EmpleadosResponse create(Empleados empleado) {
        empleadosRepository.save(empleado);
        EmpleadosResponse empleadosResponse = new EmpleadosResponse(empleado.getNombre(), empleado.getPuesto());
        return empleadosResponse;
    }

    @Override
    public Empleados update(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public void delete(Empleados empleado) {
        Optional<Empleados> empleadoOpcional= empleadosRepository.findById(empleado.getIdEmpleado());
        if(empleadoOpcional.isPresent()){
            Empleados empleadoABorrar=empleadoOpcional.get();
            empleadoABorrar.setActive(false);
            System.out.println("El empleado ha sido borrado satisfactoriamente");
            empleadosRepository.save(empleadoABorrar);
        }else{
            System.out.println("El empleado con id no existe");
        }

    }
}
