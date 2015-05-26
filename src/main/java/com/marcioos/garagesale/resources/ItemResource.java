package com.marcioos.garagesale.resources;

import com.codahale.metrics.annotation.Timed;
import com.marcioos.garagesale.dao.ItemDAO;
import com.marcioos.garagesale.views.ItemsView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("text/html; charset=utf-8")
public class ItemResource {

    private final ItemDAO itemDAO;

    public ItemResource(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GET
    @Timed
    public ItemsView listItems() {
        return new ItemsView(itemDAO.list());
    }
}
