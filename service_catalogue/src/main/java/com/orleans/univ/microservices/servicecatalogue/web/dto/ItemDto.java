package com.orleans.univ.microservices.servicecatalogue.web.dto;


import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ItemDto {

    private long id;
    @NotNull
    @NotEmpty
    private String itemName ;
    @NotNull
    @NotEmpty
    private String itemType;
    @NotNull
    @NotEmpty
    private double price;
    @NotNull
    @NotEmpty
    private double quantity;

    @NotNull
    @EqualsAndHashCode.Exclude
    private String blob;

}
