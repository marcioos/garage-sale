package com.marcioos.garagesale.views;

import com.marcioos.garagesale.model.Item;
import io.dropwizard.views.View;

import java.util.Collection;

public class ItemsView extends View {

    public final Collection<Item> items;

    public ItemsView(Collection<Item> items) {
        super("items.mustache");
        this.items = items;
    }
}
