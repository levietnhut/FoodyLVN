package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

/**
 * Created by NhutDu on 24/08/2016.
 */
public class AddRestaurantViewModel extends BaseViewModel {

    //region Properties

    RestaurantStorageService mRestaurantStorageService;

    RestaurantCloudService mRestaurantCloudService;

    private static  final String TAG = AddRestaurantViewModel.class.getSimpleName();

    Restaurant mRestaurant;

    //endregion

    //region Getter and Setter

    @Bindable
    public Restaurant getRestaurant() {
        return mRestaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        mRestaurant = restaurant;
        notifyPropertyChanged(BR.restaurant);
    }


    //endregion


    //region Constructor

    public AddRestaurantViewModel(INavigator navigator,RestaurantCloudService restaurantCloudService,RestaurantStorageService restaurantStorageService) {
        super(navigator);
        this.mRestaurantCloudService = restaurantCloudService;
        this.mRestaurantStorageService = restaurantStorageService;
        mRestaurant = new Restaurant();
    }

    //endregion

    //public methods

    public void saveRestaurant(Restaurant restaurant){
        if(restaurant==null){
            return;
        }

        mRestaurantStorageService.saveRestaurant(restaurant, new ICallback<Boolean>() {
            @Override
            public void onResult(Boolean result) {
                if(result.booleanValue()){
                    getNavigator().navigateTo(Constants.MAIN_PAGE);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG,"",t);
            }
        });

        getNavigator().navigateTo(Constants.CONTACT_PAGE);
    }

    //endregion

}
