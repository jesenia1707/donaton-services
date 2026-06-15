package com.donaton.donaciones.service;

import com.donaton.donaciones.entity.Donacion;
import com.donaton.donaciones.repository.DonacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonacionService {

    private final DonacionRepository repository;

    public DonacionService(DonacionRepository repository) {
        this.repository = repository;
    }

    public List<Donacion> listarTodo() {
        return repository.findAll();
    }

    // ✅ Este es el que arregla la línea roja de tu imagen
    public List<Donacion> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Donacion guardar(Donacion donacion) {
        return repository.save(donacion);
    }
}