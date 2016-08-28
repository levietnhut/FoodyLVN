package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NhutDu on 04/08/2016.
 */
public class LatestRestaurantsViewModel extends BaseViewModel{

    //region Properties

    private List<Restaurant> mRestaurants;

    private static final String TAG = LatestRestaurantsViewModel.class.getSimpleName();

    RestaurantCloudService mRestaurantCloudService;

    RestaurantStorageService mRestaurantStorageService;

    //endregion

    //region Getter and Setter

    @Bindable
    public List<Restaurant> getRestaurants() {
        return mRestaurants;
    }

    public void setRestaurants(List<Restaurant> mRestaurants) {
        this.mRestaurants = mRestaurants;
        notifyPropertyChanged(BR.restaurants);
    }

    //endregion

    //region Constructor

    public LatestRestaurantsViewModel(INavigator navigator,RestaurantCloudService restaurantCloudService,RestaurantStorageService restaurantStorageService) {

        super(navigator);
        this.mRestaurantCloudService = restaurantCloudService;
        this.mRestaurantStorageService = restaurantStorageService;

    }

    //endregion

    //region Private methods

    private void loadRestaurants(){
        //storage service

        mRestaurantStorageService.getAllRestaurants(new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {

                Log.d(TAG,"size "+result.size());
                setRestaurants(result);

                getNavigator().hideBusyIndicator();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG,"",t);
            }
        });
        /*
        mRestaurantCloudService.getAllRestaurants(new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {
                setRestaurants(result);
                getNavigator().hideBusyIndicator();
            }

            @Override
            public void onFailure(Throwable t) {
                getNavigator().hideBusyIndicator();
            }
        });

        */
    }

    //endregion

    @Override
    public void onCreate() {
        super.onCreate();
        getNavigator().showBusyIndicator("Loading...");
        loadRestaurants();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRestaurants =null;
    }
}
