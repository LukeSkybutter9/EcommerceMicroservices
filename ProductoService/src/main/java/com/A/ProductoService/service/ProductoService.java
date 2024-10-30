package com.A.ProductoService.service;

import com.A.ProductoService.entity.Producto;

public interface ProductoService {

    public Producto registrarProducto(Producto product);

    public Producto buscarProductoPorId(Long id);

    public Producto actualizarProducto(Long id, Producto productoDetalle);

    public void eliminarProducto(Long id);
}
