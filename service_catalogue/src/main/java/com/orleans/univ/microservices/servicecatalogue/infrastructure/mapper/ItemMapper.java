package com.orleans.univ.microservices.servicecatalogue.infrastructure.mapper;


import com.orleans.univ.microservices.servicecatalogue.domain.Item;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {


    ItemDto map(Item item);


    Item map(ItemDto itemDto);
}
