package com.marcioos.garagesale.dao;

import com.marcioos.garagesale.model.Item;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Collection;

@RegisterMapper(Item.ItemMapper.class)
public interface ItemDAO {
    @SqlQuery("select * from item")
    Collection<Item> list();
}
