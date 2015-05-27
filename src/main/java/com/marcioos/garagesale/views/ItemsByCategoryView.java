package com.marcioos.garagesale.views;

import com.marcioos.garagesale.core.model.ItemsByCategory;
import io.dropwizard.views.View;

import java.util.Collection;

public class ItemsByCategoryView extends View {

    public final Collection<ItemsByCategory> categories;

    public ItemsByCategoryView(Collection<ItemsByCategory> categories) {
        super("items_by_category.mustache");
        this.categories = categories;
    }
}
