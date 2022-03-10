package com.orleans.univ.microservices.servicecatalogue.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class ItemListDto {

    private List<ItemDto> itemDtoList = new ArrayList<>();

    public ItemListDto() {
    }

    public ItemListDto(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }


    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }
}
