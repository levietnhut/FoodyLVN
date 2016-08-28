package com.nhutdu.core.di;

import com.nhutdu.core.model.services.clouds.CategoryCloudService;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.model.services.storages.CategoryStorageService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.model.services.storages.UserStorageService;
import com.nhutdu.core.view.INavigator;
import com.nhutdu.core.viewmodel.AddRestaurantViewModel;
import com.nhutdu.core.viewmodel.CategoryViewModel;
import com.nhutdu.core.viewmodel.ContactViewModel;
import com.nhutdu.core.viewmodel.LatestRestaurantsViewModel;
import com.nhutdu.core.viewmodel.RegisterViewModel;
import com.nhutdu.core.viewmodel.RestaurantsByCategoryViewModel;
import com.nhutdu.core.viewmodel.LoginViewModel;
import com.nhutdu.core.viewmodel.RestaurantViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NhutDu on 7/27/16.
 */

@Module(includes = { CloudModule.class, StorageModule.class })
public class ViewModelModule {

    //region Provide methods

    @Provides
    @Singleton
    public LoginViewModel providesLoginViewModel(INavigator navigator, UserCloudService mUserCloudService, UserStorageService userStorageService) {
        return new LoginViewModel(navigator,mUserCloudService, userStorageService);
    }

    @Provides
    @Singleton
    public ContactViewModel providesContactViewModel(INavigator navigator) {
        return new ContactViewModel(navigator);
    }

    @Provides
    @Singleton
    public CategoryViewModel providesCategoryViewModel(INavigator navigator, CategoryCloudService categoryCloudService, CategoryStorageService categoryStorageService) {
        return new CategoryViewModel(navigator,categoryCloudService,categoryStorageService);
    }

    @Provides
    @Singleton
    public RestaurantsByCategoryViewModel providesListRestaurantViewModel(INavigator navigator,RestaurantCloudService restaurantCloudService, RestaurantStorageService restaurantStorageService) {
        return new RestaurantsByCategoryViewModel(navigator,restaurantCloudService,restaurantStorageService);
    }

    @Provides
    @Singleton
    public RestaurantViewModel providesRestaurantViewModel(INavigator iNavigator, RestaurantCloudService restaurantCloudService, RestaurantStorageService restaurantStorageService){
        return new RestaurantViewModel(iNavigator,restaurantCloudService,restaurantStorageService);
    }

    @Provides
    @Singleton
    public RegisterViewModel providesRegisterViewModel(INavigator iNavigator,UserCloudService userCloudService,UserStorageService userStorageService){
        return new RegisterViewModel(iNavigator,userCloudService,userStorageService);
    }

    @Provides
    @Singleton
    public AddRestaurantViewModel providesAddRestaurantViewModel(INavigator iNavigator, RestaurantCloudService restaurantCloudService,RestaurantStorageService restaurantStorageService){
        return new AddRestaurantViewModel(iNavigator,restaurantCloudService,restaurantStorageService);
    }

    @Provides
    @Singleton
    public LatestRestaurantsViewModel providesLatestRestaurantsViewModel(INavigator iNavigator, RestaurantCloudService restaurantCloudService, RestaurantStorageService restaurantStorageService){
        return new LatestRestaurantsViewModel(iNavigator,restaurantCloudService,restaurantStorageService);
    }

    //endregion

}
