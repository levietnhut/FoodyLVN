package com.nhutdu.core.model.entities;

/**
 * Created by NhutDu on 09/08/2016.
 */
public class Food extends Entity {

    //region Properties

    private int id;

    private String name;

    private String image;

    private Category category;

    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //endregion

    //region Constructor


    public Food() {
    }

    public Food(int id, String name, String image, Category category, String content, User author) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.category = category;
        this.content = content;
        this.author = author;
    }

    //endregion

    //region Builder

    public static class Builder implements IBuilder<Food>{

        //region Properties

        private int mId;

        private String mName;

        private String mImage;

        private Category mCategory;

        private String mContent;

        private User mUser;

        //endregion

        //region Getter and Setter

        public Builder setUser(User user) {
            mUser = user;
            return this;
        }

        public Builder setName(String name) {
            mName = name;
            return this;
        }

        public Builder setImage(String image) {
            mImage = image;
            return this;
        }

        public Builder setCategory(Category category) {
            mCategory = category;
            return this;
        }

        public Builder setContent(String content) {
            mContent = content;
            return this;
        }

        public Builder setId(int id) {
            mId = id;
            return this;
        }

        //endregion

        //region implements IBuilder

        @Override
        public Food build() {
            Food food = new Food();
            food.setId(mId);
            food.setName(mName);
            food.setCategory(mCategory);
            food.setContent(mContent);
            food.setAuthor(mUser);
            return food;
        }

        //endregion
    }

    //endregion
}
