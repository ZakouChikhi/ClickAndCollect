package com.orleans.univ.microservices.servicecatalogue.web;



import com.orleans.univ.microservices.servicecatalogue.infrastructure.service.ItemService;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;



    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;

    }

    @PostMapping(value = "",consumes="application/json")
    public ResponseEntity<Void> createItem(@RequestBody ItemDto itemDto){

         var savedItemDto = this.itemService.create(itemDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
