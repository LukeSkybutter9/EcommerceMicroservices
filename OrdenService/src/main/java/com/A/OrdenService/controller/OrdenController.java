package com.A.OrdenService.controller;


import com.A.OrdenService.entity.Orden;
import com.A.OrdenService.service.OrdenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    private final OrdenService ordenService;


    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<Orden> registrarOrden(@RequestBody Orden orden) {
        return ResponseEntity.ok(ordenService.registrarOrden(orden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> buscarOrdenPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.buscarOrdenPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> actualizarOrden(@PathVariable Long id, @RequestBody Orden orden) {
        return ResponseEntity.ok(ordenService.actualizarOrden(id, orden));
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<Orden> modificarStatusOrden(@PathVariable Long id, @RequestBody Boolean Status) {
        Orden ordenmodificado = ordenService.modificarStatusOrden(id, Status);
        return ResponseEntity.ok(ordenmodificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
        return null;
    }

}
