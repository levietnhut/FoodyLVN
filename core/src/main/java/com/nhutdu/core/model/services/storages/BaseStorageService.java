package com.nhutdu.core.model.services.storages;


import io.realm.Realm;

/**
 * Created by NhutDu on 23/08/2016.
 */
public abstract class BaseStorageService {

    //region Properties

    Realm mRealm;

    //endregion

    //region Constructor

    public BaseStorageService(Realm realm) {
        mRealm = realm;
    }

    //endregion
}
