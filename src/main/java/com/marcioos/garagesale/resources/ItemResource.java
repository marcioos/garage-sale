package com.marcioos.garagesale.resources;

import com.codahale.metrics.annotation.Timed;
import com.marcioos.garagesale.dao.ItemDAO;
import com.marcioos.garagesale.model.Item;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    private final ItemDAO itemDAO;

    public ItemResource(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GET
    @Timed
    public Collection<Item> listItems() {
        return itemDAO.list();
    }
}
