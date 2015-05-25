package com.marcioos.garagesale.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

    private long id;
    private String name;
    private String price;
    private String description;
    private String picture;

    public Item() {
    }

    public Item(long id, String name, String price, String description, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getPrice() {
        return price;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getPicture() {
        return picture;
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
                    && Objects.equal(this.picture, that.picture);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, price, description, picture);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("price", price)
                .add("description", description)
                .add("picture", picture).toString();
    }

    public static class ItemMapper implements ResultSetMapper<Item> {

        @Override
        public Item map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
            return new Item(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("price"),
                    resultSet.getString("description"), resultSet.getString("picture"));
        }
    }
}
