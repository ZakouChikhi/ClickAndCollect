package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;

public interface ItemService {
    ItemDto create(ItemDto itemDto);
}
