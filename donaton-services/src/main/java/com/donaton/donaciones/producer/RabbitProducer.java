package com.donaton.donaciones.producer;

import com.donaton.donaciones.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMensaje(String mensaje) {

        rabbitTemplate.convertAndSend(
                RabbitConfig.COLA_DONACIONES,
                mensaje
        );

        System.out.println("Mensaje enviado: " + mensaje);
    }
}