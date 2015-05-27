package com.marcioos.garagesale.core.helper;

import com.marcioos.garagesale.core.model.Item;
import com.marcioos.garagesale.core.model.ItemsByCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemsByCategoryHelper {

    public Collection<ItemsByCategory> groupItemsByCategory(Collection<Item> items) {
        Map<String, Collection<Item>> categoryMap = createCategoryMap(items);
        Collection<ItemsByCategory> itemsByCategories = new ArrayList<>();
        for (Map.Entry<String, Collection<Item>> categoryEntry : categoryMap.entrySet()) {
            itemsByCategories.add(new ItemsByCategory(categoryEntry.getKey(), categoryEntry.getValue()));
        }
        return itemsByCategories;
    }

    private static Map<String, Collection<Item>> createCategoryMap(Collection<Item> items) {
        Map<String, Collection<Item>> categoryMap = new HashMap<>();
        Collection<Item> outrosCategory = new ArrayList<>();
        for (Item item : items) {
            if (item.getCategory().equals("Outros")) {
                outrosCategory.add(item);
                continue;
            }
            if (categoryMap.containsKey(item.getCategory())) {
                categoryMap.get(item.getCategory()).add(item);
            } else {
                Collection<Item> categoryItems = new ArrayList<>();
                categoryItems.add(item);
                categoryMap.put(item.getCategory(), categoryItems);
            }
        }
        categoryMap.put("Outros", outrosCategory);
        return categoryMap;
    }
}
