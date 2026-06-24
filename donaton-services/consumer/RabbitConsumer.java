package com.donaton.donaciones.consumer;

import com.donaton.donaciones.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {

    @RabbitListener(queues = RabbitConfig.COLA_DONACIONES)
    public void recibirMensaje(String mensaje) {

        System.out.println("================================");
        System.out.println("Mensaje recibido desde RabbitMQ");
        System.out.println(mensaje);
        System.out.println("================================");
    }
}