package com.marcioos.garagesale.core.model;

import java.util.Collection;

public class ItemsByCategory {

    private String category;
    private Collection<Item> items;

    public ItemsByCategory(String category, Collection<Item> items) {
        this.category = category;
        this.items = items;
    }

    public String getCategory() {
        return category;
    }

    public Collection<Item> getItems() {
        return items;
    }
}
