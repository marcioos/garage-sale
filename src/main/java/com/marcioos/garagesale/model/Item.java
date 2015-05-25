package com.marcioos.garagesale.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private long id;
    private String name;
    private String price;
    private String description;
    private String picture;

    public Item() {
    }

    public Item(long id, String name, String price, String description, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getPrice() {
        return price;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getPicture() {
        return picture;
    }
}
