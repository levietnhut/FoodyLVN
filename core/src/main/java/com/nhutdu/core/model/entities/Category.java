package com.nhutdu.core.model.entities;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class Category extends Entity {

    //region Properties

    private int id;

    private String name;

    private String image;

    //endregion

    //region Getter and Setter

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //endregion


    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
