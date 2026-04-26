package com.donaton.donaciones.controller;

import com.donaton.donaciones.entity.Donacion;
import com.donaton.donaciones.service.DonacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin("*")
public class DonacionController {

    private final DonacionService service;

    public DonacionController(DonacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Donacion> listar() {
        return service.listar();
    }

    @PostMapping
    public Donacion guardar(@RequestBody Donacion donacion) {
        return service.guardar(donacion);
    }
}