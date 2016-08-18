package com.nhutdu.core.di;

import com.nhutdu.core.model.services.clouds.CategoryCloudService;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.view.INavigator;
import com.nhutdu.core.viewmodel.CategoryViewModel;
import com.nhutdu.core.viewmodel.ContactViewModel;
import com.nhutdu.core.viewmodel.LatestNewsViewModel;
import com.nhutdu.core.viewmodel.ListRestaurantViewModel;
import com.nhutdu.core.viewmodel.LoginViewModel;
import com.nhutdu.core.viewmodel.RestaurantViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TVG on 7/27/16.
 */

@Module(includes = { CloudModule.class })
public class ViewModelModule {

    //region Provide methods

    @Provides
    @Singleton
    public LoginViewModel providesLoginViewModel(INavigator navigator, UserCloudService mUserCloudService) {
        return new LoginViewModel(navigator,mUserCloudService);
    }

    @Provides
    @Singleton
    public ContactViewModel providesContactViewModel(INavigator navigator) {
        return new ContactViewModel(navigator);
    }

    @Provides
    @Singleton
    public CategoryViewModel providesCategoryViewModel(INavigator navigator, CategoryCloudService categoryCloudService) {
        return new CategoryViewModel(navigator,categoryCloudService);
    }

    @Provides
    @Singleton
    public ListRestaurantViewModel providesListRestaurantViewModel(INavigator navigator) {
        return new ListRestaurantViewModel(navigator);
    }

    @Provides
    @Singleton
    public RestaurantViewModel providesRestaurantViewModel(INavigator iNavigator, RestaurantCloudService restaurantCloudService){
        return new RestaurantViewModel(iNavigator,restaurantCloudService);
    }


    //endregion

}
