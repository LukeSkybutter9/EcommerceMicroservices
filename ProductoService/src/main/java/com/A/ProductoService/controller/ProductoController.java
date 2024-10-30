package com.A.ProductoService.controller;

import com.A.ProductoService.entity.Producto;
import com.A.ProductoService.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
            return ResponseEntity.ok(productoService.registrarProducto(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id){
        return ResponseEntity.ok(productoService.buscarProductoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return null;
    }

}
