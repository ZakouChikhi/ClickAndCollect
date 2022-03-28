package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.config.RabbitMQConfig;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemFilterRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueConsumer {

    private final RabbitTemplate rabbitTemplate;

    private final ItemService itemService;

    @Autowired
    private QueueProducer queueSender;

    @Autowired
    public QueueConsumer(RabbitTemplate rabbitTemplate, ItemService itemService) {
        this.rabbitTemplate = rabbitTemplate;
        this.itemService = itemService;
    }

    @RabbitListener( queues = RabbitMQConfig.PANIER_CATALOGUE_QUEUE)
    public void receive(List<Long> listIds){
        ItemFilterRequest itemFilterRequest = new ItemFilterRequest(listIds);
        var itemListDto = itemService.filter(itemFilterRequest);
        queueSender.send(itemListDto);
    }
}
