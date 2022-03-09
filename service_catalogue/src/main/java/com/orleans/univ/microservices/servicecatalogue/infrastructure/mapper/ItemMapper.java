package com.orleans.univ.microservices.servicecatalogue.infrastructure.mapper;


import com.orleans.univ.microservices.servicecatalogue.domain.Item;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "id", source = "id")
    ItemDto map(Item item);

    @Mapping(target = "id", source = "id")
    Item map(ItemDto itemDto);
}
