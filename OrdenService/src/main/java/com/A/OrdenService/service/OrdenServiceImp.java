package com.A.OrdenService.service;


import com.A.OrdenService.controller.ProductoServiceClient;
import com.A.OrdenService.entity.Orden;
import com.A.OrdenService.entity.Producto;
import com.A.OrdenService.repository.OrdenRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImp implements OrdenService{

    private final OrdenRepository ordenRepository;
    private final ProductoServiceClient productoServiceClient;

    public OrdenServiceImp(OrdenRepository ordenRepository,
                           ProductoServiceClient productoServiceClient) {
        this.ordenRepository = ordenRepository;
        this.productoServiceClient = productoServiceClient;
    }

    @Override
    public Orden registrarOrden(Orden orden) {
        Producto producto = productoServiceClient.buscarProductoPorId(orden.getProductId());
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado");
        }
        return ordenRepository.save(orden);
    }

    @Override
    public Orden buscarOrdenPorId(Long id) {
        return ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));
    }

    @Override
    public Orden actualizarOrden(Long id, Orden ordenDetalles) {
        Orden orden = ordenRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la orden"));

        Producto producto = productoServiceClient.buscarProductoPorId(id);
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado");
        }

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
