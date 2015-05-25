package com.marcioos.garagesale.dao;

import com.marcioos.garagesale.model.Item;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

import java.util.Collection;

public interface ItemDAO {
    @SqlQuery("select * from item")
    Collection<Item> list();
}
