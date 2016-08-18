package com.nhutdu.core.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 7/26/2016.
 */
public class Restaurant{
    //region Properties

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("open_time")
    private String mOpenTime;

    @SerializedName("category_id")
    private int mCategoryId;

    @SerializedName("close_time")
    private String mCloseTime;

    @SerializedName("phone_number")
    private String mPhoneNumber;

    @SerializedName("image")
    private String mImage;

    @SerializedName("content")
    private String mContent;

    @SerializedName("created_at")
    private Date mCreatedAt;

    @SerializedName("updated_at")
    private Date mUpdatedAt;

    @SerializedName("deleted_at")
    private Date mDeletedAt;

    @SerializedName("comments")
    private List<Comment> mComments;

    @SerializedName("category")
    private Category mCategory;

    //endregion

    //region Constructors

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String openTime, String closeTime, String phoneNumber, String image, String content) {
        mId = id;
        mName = name;
        mAddress = address;
        mOpenTime = openTime;
        mCloseTime = closeTime;
        mPhoneNumber = phoneNumber;
        mImage = image;
        mContent = content;
    }

    public Restaurant(int id, int categoryId, String name, String address, String openTime, String closeTime, String phoneNumber, String image, String content, Date createdAt, Date updatedAt, Date deletedAt) {
        mId = id;
        mCategoryId = categoryId;
        mName = name;
        mAddress = address;
        mOpenTime = openTime;
        mCloseTime = closeTime;
        mPhoneNumber = phoneNumber;
        mImage = image;
        mContent = content;
        mCreatedAt = createdAt;
        mUpdatedAt = updatedAt;
        mDeletedAt = deletedAt;
    }

    //endregion

    //region Setters and Getters


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getOpenTime() {
        return mOpenTime;
    }

    public void setOpenTime(String openTime) {
        mOpenTime = openTime;
    }

    public String getCloseTime() {
        return mCloseTime;
    }

    public void setCloseTime(String closeTime) {
        mCloseTime = closeTime;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return mDeletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        mDeletedAt = deletedAt;
    }

    public List<Comment> getComments() {
        return mComments;
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public int getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(int categoryId) {
        mCategoryId = categoryId;
    }

    //endregion

    //region Public Methods

    public String getOpenPeriod() {
        return getOpenTime() + " - " + getCloseTime();
    }

    //endregion
}
