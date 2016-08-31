package com.nhutdu.foodylvn;

import com.nhutdu.core.di.ViewModelModule;
import com.nhutdu.foodylvn.activities.ContactActivity;
import com.nhutdu.foodylvn.activities.CreateRestaurantActivity;
import com.nhutdu.foodylvn.activities.ListRestaurantActivity;
import com.nhutdu.foodylvn.activities.LoginActivity;
import com.nhutdu.foodylvn.activities.MainActivity;
import com.nhutdu.foodylvn.activities.RegisterActivity;
import com.nhutdu.foodylvn.activities.RestaurantDetailActivity;
import com.nhutdu.foodylvn.fragments.CategoryFragment;
import com.nhutdu.foodylvn.fragments.LatestRestaurantsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TVG on 7/27/16.
 */

@Singleton
@Component(modules = { ViewModelModule.class })
public interface AppComponent {

    void inject(LoginActivity activity);
    void inject(ContactActivity activity);
    void inject(RegisterActivity activity);
    void inject(CreateRestaurantActivity activity);
    void inject(RestaurantDetailActivity activity);
    void inject(MainActivity activity);
    void inject(ListRestaurantActivity activity);
    void inject(LatestRestaurantsFragment fragment);
    void inject(CategoryFragment fragment);

}
