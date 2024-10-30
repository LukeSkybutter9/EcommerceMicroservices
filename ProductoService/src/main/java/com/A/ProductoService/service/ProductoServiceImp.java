package com.A.ProductoService.service;
import com.A.ProductoService.entity.Producto;
import com.A.ProductoService.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto registrarProducto(Producto product) {
        return productoRepository.save(product);
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoDetalles) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
        producto.setName(productoDetalles.getName());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setStock(productoDetalles.getStock());
        producto.setPrice(productoDetalles.getPrice());
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado con id " + id));
        productoRepository.delete(producto);
    }
}
