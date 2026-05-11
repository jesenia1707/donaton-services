package com.donaton.donaciones.controller;

import com.donaton.donaciones.entity.Donacion;
import com.donaton.donaciones.service.DonacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    private final DonacionService service;

    public DonacionController(DonacionService service) {
        this.service = service;
    }

    // Para que cada usuario vea SOLO lo suyo
    @GetMapping("/usuario/{usuarioId}")
    public List<Donacion> listarPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId);
    }

    // Si quieres una ruta para ver todas (opcional)
    @GetMapping
    public List<Donacion> listarTodas() {
        return service.listarTodo();
    }

    @PostMapping
    public Donacion crear(@RequestBody Donacion donacion) {
        return service.guardar(donacion);
    }
}