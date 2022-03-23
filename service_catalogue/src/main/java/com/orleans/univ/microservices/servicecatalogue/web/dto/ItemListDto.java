package com.orleans.univ.microservices.servicecatalogue.web.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ItemListDto implements Serializable {

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
