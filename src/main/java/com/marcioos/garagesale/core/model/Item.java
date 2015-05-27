package com.marcioos.garagesale.core.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

    private final long id;
    private final String name;
    private final String price;
    private final String description;
    private final String picture;
    private final String category;

    public Item(long id, String name, String price, String description, String picture, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj instanceof Item) {
            Item that = (Item) obj;
            return Objects.equal(this.id, that.id)
                    && Objects.equal(this.name, that.name)
                    && Objects.equal(this.price, that.price)
                    && Objects.equal(this.description, that.description)
                    && Objects.equal(this.picture, that.picture)
                    && Objects.equal(this.category, that.category);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, price, description, picture, category);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("price", price)
                .add("description", description)
                .add("picture", picture)
                .add("category", category).toString();
    }

    public static class ItemMapper implements ResultSetMapper<Item> {

        @Override
        public Item map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
            return new Item(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("price"),
                    resultSet.getString("description"),
                    resultSet.getString("picture"),
                    resultSet.getString("category"));
        }
    }
}
