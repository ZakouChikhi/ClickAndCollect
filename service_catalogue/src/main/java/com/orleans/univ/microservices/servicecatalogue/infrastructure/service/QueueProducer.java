package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemListDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {


    private final RabbitTemplate rabbitTemplate;



    public QueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void send(ItemListDto itemListDto) {
        rabbitTemplate.convertAndSend(itemListDto);
    }
}
