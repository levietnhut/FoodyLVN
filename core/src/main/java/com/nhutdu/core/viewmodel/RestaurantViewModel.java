package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 16/08/2016.
 */
public class RestaurantViewModel extends BaseViewModel{

    //region Properties

    private static final String TAG = RestaurantViewModel.class.getSimpleName();

    RestaurantCloudService mRestaurantCloudService;

    List<Restaurant> mAllRestaurants;

    //endregion

    //region Getter and Setter

    public RestaurantCloudService getRestaurantCloudService() {
        return mRestaurantCloudService;
    }

    public void setRestaurantCloudService(RestaurantCloudService restaurantCloudService) {
        mRestaurantCloudService = restaurantCloudService;
    }

    @Bindable
    public List<Restaurant> getAllRestaurants() {
        return mAllRestaurants;
    }

    public void setAllRestaurants(List<Restaurant> allRestaurants) {
        mAllRestaurants = allRestaurants;
        notifyPropertyChanged(BR.allRestaurants);
    }

    //endregion

    //region Constructor

    public RestaurantViewModel(INavigator navigator, RestaurantCloudService restaurantCloudService) {
        super(navigator);
        mRestaurantCloudService = restaurantCloudService;
    }

    //endregion

    //region Private methods

    private void loadAllRestaurants(){
        mRestaurantCloudService.getAllRestaurants(new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {
                setAllRestaurants(result);
                getNavigator().hideBusyIndicator();
            }

            @Override
            public void onFailure(Throwable t) {
                getNavigator().hideBusyIndicator();
            }
        });
    }

    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
//        getNavigator().showBusyIndicator("Loading....");
        loadAllRestaurants();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAllRestaurants = null;
    }
}
