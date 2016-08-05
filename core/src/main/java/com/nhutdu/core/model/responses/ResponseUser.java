package com.nhutdu.core.model.responses;

import com.nhutdu.core.model.entities.User;

import java.util.List;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class ResponseUser extends Response {

    //region Properties

    List<User> mUsers;

    //endregion

    // region Getter

    public List<User> getmUsers() {
        return mUsers;
    }

    //endregion
}
