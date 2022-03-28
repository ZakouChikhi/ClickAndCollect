package com.orleans.univ.microservices.servicecatalogue.config;

import com.orleans.univ.microservices.servicecatalogue.infrastructure.service.QueueConsumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * sender : catalogue
     * listener : panier
     */
    public final static String CATALOGUE_PANIER_QUEUE ="catalogue_panier";
    /**
     * sender: panier
     * listener: catalogue
     */
    public final static String PANIER_CATALOGUE_QUEUE="panier_catalogue";

    @Bean
    public Queue senderQueue() {
        return new Queue(CATALOGUE_PANIER_QUEUE, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Queue panierCatalogueQueue() {
        return new Queue(PANIER_CATALOGUE_QUEUE, true);
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(PANIER_CATALOGUE_QUEUE);
        return container;
    }


    @Bean
    Binding testeBinding(Queue senderQueue, DirectExchange exchange) {
        return BindingBuilder.bind(senderQueue).to(exchange).with("teste-routing-key");
    }
}
