package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.model.services.storages.UserStorageService;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 31/08/2016.
 */
public class FavoriteRestaurantViewModel extends BaseViewModel {

    //region Properties

    List<Restaurant> mRestaurants;

    UserStorageService mUserStorageService;

    UserCloudService mUserCloudService;

    //endregion

    //region Getter and Setter
    @Bindable
    public List<Restaurant> getRestaurants() {
        return mRestaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        mRestaurants = restaurants;
        notifyPropertyChanged(BR.restaurants);
    }

    //endregion

    //region Constructor

    public FavoriteRestaurantViewModel(INavigator navigator,UserCloudService userCloudService,UserStorageService userStorageService) {
        super(navigator);
        this.mUserCloudService = userCloudService;
        this.mUserStorageService = userStorageService;
    }

    //endregion

    //region public methods

    public void loadFavoriteRestaurants(User user){
        mUserStorageService.getFavoriteRestaurants(user, new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {
                setRestaurants(result);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG","",t);
            }
        });
    }

    //endregion
}
