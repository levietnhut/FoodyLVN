package com.nhutdu.core.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NhutDu on 05/08/2016.
 */
public class Contact {

    //region Properties

    @SerializedName("email")
    private String mEmail;

    @SerializedName("subject")
    private String mSubject;

    @SerializedName("content")
    private String mContent;

    //endregion

    //region Getter and Setter

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String mSubject) {
        this.mSubject = mSubject;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    //endregion

    //region Constructor

    public Contact() {
    }

    //endregion


}
