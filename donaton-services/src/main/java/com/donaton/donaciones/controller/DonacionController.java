package com.donaton.donaciones.controller;


import com.donaton.donaciones.producer.DonacionProducer;
import org.springframework.web.bind.annotation.*;


@RestController
public class DonacionController {


    private final DonacionProducer producer;


    public DonacionController(DonacionProducer producer){
        this.producer = producer;
    }


    @GetMapping("/enviar")
    public String enviar(){

        producer.enviarMensaje(
          "Nueva donacion creada"
        );

        return "Mensaje enviado RabbitMQ";
    }

}