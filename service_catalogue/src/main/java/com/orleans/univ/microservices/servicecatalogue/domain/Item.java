package com.orleans.univ.microservices.servicecatalogue.domain;



import javax.persistence.*;


@Entity
@Table(name = "article")
public class Item {

    public Item() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String itemName ;
    private String itemType;
    private double price;
    private double quantity;
    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] blob;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public byte[] getBlob() {
        return blob;
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }






}
