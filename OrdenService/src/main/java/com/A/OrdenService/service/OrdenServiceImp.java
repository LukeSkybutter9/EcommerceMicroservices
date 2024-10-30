package com.A.OrdenService.service;

import com.A.OrdenService.entity.Orden;
import com.A.OrdenService.repository.OrdenRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImp implements OrdenService{

    private final OrdenRepository ordenRepository;

    public OrdenServiceImp(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    public Orden registrarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public Orden buscarOrdenPorId(Long id) {
        return ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));
    }

    @Override
    public Orden actualizarOrden(Long id, Orden ordenDetalles) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));
        orden.setId(ordenDetalles.getId());
        orden.setUserId(ordenDetalles.getUserId());
        orden.setProductId(ordenDetalles.getProductId());
        orden.setQuantity(ordenDetalles.getQuantity());
        orden.setStatus(ordenDetalles.getStatus());
        return ordenRepository.save(orden);
    }

    @Override
    public Orden modificarStatusOrden(Long id, Boolean status) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));
        orden.setStatus(status);
        return ordenRepository.save(orden);
    }

    @Override
    public void eliminarOrden(Long id) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));
        ordenRepository.delete(orden);
    }
}
