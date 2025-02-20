package com.example.tiendainn13.service.impl;

import com.example.tiendainn13.entity.Pedido;
import com.example.tiendainn13.repository.IPedidoRepository;
import com.example.tiendainn13.service.IPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PedidoService implements IPedidoService {
    @Autowired
    IPedidoRepository pedidoRepository;
    @Override
    public List<Pedido> readAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> readById(int id) {
        Optional<Pedido>  pedido = pedidoRepository.findById(id);
        return pedido;
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public String delete(Pedido pedido) {
        Optional<Pedido>  pedidoOptional = pedidoRepository.findById(pedido.getIdPedido());
        if (pedidoOptional.isPresent()){
            Pedido pedidoABorrar = pedidoOptional.get();
            pedidoABorrar.setEsActivo(false);
            try{
                pedidoRepository.save(pedidoABorrar);
                log.info("El pedido ha sido borrado");
                return "EL pedido ha sido borrado satisfactoriamente";
            }catch (Exception e){
                log.error("Error " + e.getMessage());
                log.error("Rastreo: " + e.getStackTrace());
                return "Hubo un error con la base de datos";
            }
        }else {
            log.info("El pedido no existe");
            return "El pedido no existe";
        }
    }


}
