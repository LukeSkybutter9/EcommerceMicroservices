package com.A.ProductoService;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosOrderApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProductoServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
