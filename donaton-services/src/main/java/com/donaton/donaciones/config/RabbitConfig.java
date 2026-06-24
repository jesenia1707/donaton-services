package com.donaton.donaciones.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String COLA_DONACIONES = "donaciones";

    @Bean
    public Queue colaDonaciones() {
        return new Queue(COLA_DONACIONES, true);
    }
}