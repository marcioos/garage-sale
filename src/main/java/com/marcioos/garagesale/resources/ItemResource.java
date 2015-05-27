package com.marcioos.garagesale.resources;

import com.codahale.metrics.annotation.Timed;
import com.marcioos.garagesale.core.helper.ItemsByCategoryHelper;
import com.marcioos.garagesale.core.model.Item;
import com.marcioos.garagesale.core.model.ItemsByCategory;
import com.marcioos.garagesale.dao.ItemDAO;
import com.marcioos.garagesale.views.ItemsByCategoryView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;

@Path("/")
@Produces("text/html; charset=utf-8")
public class ItemResource {

    private final ItemDAO itemDAO;
    private final ItemsByCategoryHelper itemsByCategoryHelper;

    public ItemResource(ItemDAO itemDAO, ItemsByCategoryHelper itemsByCategoryHelper) {
        this.itemDAO = itemDAO;
        this.itemsByCategoryHelper = itemsByCategoryHelper;
    }

    @GET
    @Timed
    public ItemsByCategoryView listItemsByCategory() {
        Collection<Item> items = itemDAO.list();
        Collection<ItemsByCategory> itemsByCategory = itemsByCategoryHelper.groupItemsByCategory(items);
        return new ItemsByCategoryView(itemsByCategory);
    }
}
