package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemFilterRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueConsumer {

    private final ItemService itemService;

    @Autowired
    private QueueProducer queueSender;

    @Autowired
    public QueueConsumer(ItemService itemService) {
        this.itemService = itemService;
    }

    @RabbitListener( queues = {"${queue.listener.name}"} )
    public void receive(List<Long> listIds){
        ItemFilterRequest itemFilterRequest = new ItemFilterRequest(listIds);
        var itemListDto = itemService.filter(itemFilterRequest);
        queueSender.send(itemListDto);
    }
}
