package com.orleans.univ.microservices.servicecatalogue.domain;

import lombok.Getter;

public enum ItemType {

    STARTER("Entrée"),
    MAIN_DISH("Plat"),
    DESSERT("Dessert"),
    DRINK("Boisson");


    @Getter
    private final String label;

    ItemType(String label){
        this.label=label;
    }

}
