package com.A.OrdenService.controller;


import com.A.OrdenService.entity.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ProductoService")
public interface ProductoServiceClient {

    @GetMapping("/producto/{id}")
    Producto buscarProductoPorId(@PathVariable Long id);
}
