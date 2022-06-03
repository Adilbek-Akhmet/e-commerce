package com.example.deliveryservicemvc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.delivery}")
    private String deliveryQueue;

    @Value("${rabbitmq.routing-keys.internal-delivery}")
    private String internalDeliveryRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue deliveryQueue() {
        return new Queue(this.deliveryQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(deliveryQueue())
                .to(internalTopicExchange())
                .with(this.internalDeliveryRoutingKey);
    }
}

