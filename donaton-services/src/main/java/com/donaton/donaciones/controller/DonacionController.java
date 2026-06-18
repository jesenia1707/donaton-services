package com.donaton.donaciones.controller;

import com.donaton.donaciones.entity.Donacion;
import com.donaton.donaciones.producer.DonacionProducer;
import com.donaton.donaciones.service.DonacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {


private final DonacionService service;
private final DonacionProducer producer;

public DonacionController(
        DonacionService service,
        DonacionProducer producer) {

    this.service = service;
    this.producer = producer;
}

@GetMapping
public List<Donacion> listarTodas() {
    return service.listarTodo();
}

@GetMapping("/usuario/{usuarioId}")
public List<Donacion> listarPorUsuario(@PathVariable Long usuarioId) {
    return service.obtenerPorUsuario(usuarioId);
}

@PostMapping
public Donacion crear(@RequestBody Donacion donacion) {

    Donacion nuevaDonacion = service.guardar(donacion);

    producer.enviarMensaje(
            "Nueva donacion creada ID: " +
            nuevaDonacion.getId()
    );

    return nuevaDonacion;
}

@GetMapping("/enviar")
public String enviarPrueba() {

    producer.enviarMensaje(
            "Mensaje de prueba RabbitMQ"
    );

    return "Mensaje enviado RabbitMQ";
}


}
