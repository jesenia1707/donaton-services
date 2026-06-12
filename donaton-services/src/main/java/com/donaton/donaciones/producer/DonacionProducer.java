package com.donaton.donaciones.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DonacionProducer {

    private final RabbitTemplate rabbitTemplate;


    public DonacionProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }


    public void enviarMensaje(String mensaje){

        rabbitTemplate.convertAndSend(
                "donaciones",
                mensaje
        );
    }
}