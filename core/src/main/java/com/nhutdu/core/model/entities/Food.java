package com.nhutdu.core.model.entities;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class Food extends Entity {

    //region Properties

    private int id;

    private String name;

    private String image;

    private Category category;

    private String context;

    private User author;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //endregion


    public Food(int id, String name, String image, Category category, String context, User author) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.category = category;
        this.context = context;
        this.author = author;
    }
}
