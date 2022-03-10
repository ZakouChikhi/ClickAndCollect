package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.infrastructure.exception.ResourseNotFoundException;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemFilterRequest;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemListDto;

public interface ItemService {
    ItemDto create(ItemDto itemDto);

    void delete(long id) throws ResourseNotFoundException;

    ItemDto update(long id, ItemDto itemDto) throws ResourseNotFoundException;

    ItemDto getItem(long id) throws ResourseNotFoundException;

    ItemListDto getAllItem();

    ItemListDto filter(ItemFilterRequest itemFilterRequest);
}
