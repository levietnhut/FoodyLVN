package com.nhutdu.core.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class User extends Entity {

    // region Properties

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("role")
    private int mRole;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("status")
    private int mStatus;

    @SerializedName("remember_token")
    private String mRememberToken;

    //end region

    // region Getter and Setter

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmRole() {
        return mRole;
    }

    public void setmRole(int mRole) {
        this.mRole = mRole;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getmRememberToken() {
        return mRememberToken;
    }

    public void setmRememberToken(String mRememberToken) {
        this.mRememberToken = mRememberToken;
    }

    //endregion

    public static class Builder implements IBuilder<User>{

        @Override
        public User build() {
            return null;
        }
    }
}
