package com.orleans.univ.microservices.servicecatalogue.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "article")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String itemName ;
    private String itemType;
    private double price;
    private double quantity;
    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] blob;




}
