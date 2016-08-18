package com.nhutdu.core.model.responses;

import com.google.gson.annotations.SerializedName;
import com.nhutdu.core.model.entities.Restaurant;

import java.util.List;

/**
 * Created by Administrator on 7/30/2016.
 */
public class ApiResponse {

    //region Properties

    @SerializedName("success")
    private boolean mSuccess;

    @SerializedName("data")
    private List<Restaurant> mData;

    @SerializedName("message")
    private String mMessage;

    //endregion

    public ApiResponse() {
        super();
    }


    //region Getter and Setter

    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean success) {
        mSuccess = success;
    }

    public List<Restaurant> getData() {
        return mData;
    }

    public void setData(List<Restaurant> data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }


    //endregion

}
