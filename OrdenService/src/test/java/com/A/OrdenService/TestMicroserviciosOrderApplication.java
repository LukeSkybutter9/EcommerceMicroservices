package com.A.OrdenService;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosOrderApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrdenServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
