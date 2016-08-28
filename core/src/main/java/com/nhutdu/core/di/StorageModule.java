package com.nhutdu.core.di;

import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.CategoryStorageService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.model.services.storages.UserStorageService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by NhutDu on 24/08/2016.
 */
@Module(includes = { AppModule.class })
public class StorageModule {

    //region public methods

    @Provides
    @Singleton
    public Realm providesRealm(){
        return  Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    public RestaurantStorageService providesRestaurantStorage(Realm realm){
        return new  RestaurantStorageService(realm);
    }

    @Provides
    @Singleton
    public CategoryStorageService providesCategoryStorage(Realm realm){
        return new  CategoryStorageService(realm);
    }

    @Provides
    @Singleton
    public UserStorageService providesUserStorage(Realm realm){
        return new  UserStorageService(realm);
    }

}
