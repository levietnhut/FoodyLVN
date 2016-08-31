package com.nhutdu.core.viewmodel;

import android.content.Intent;
import android.databinding.Bindable;
import android.net.Uri;
import android.util.Log;


import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.view.INavigator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by NhutDu on 16/08/2016.
 */
public class RestaurantDetailViewModel extends BaseViewModel{

    //region Properties

    private static final String TAG = RestaurantDetailViewModel.class.getSimpleName();

    RestaurantCloudService mRestaurantCloudService;

    RestaurantStorageService mRestaurantStorageService;

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

    public RestaurantDetailViewModel(INavigator navigator, RestaurantCloudService restaurantCloudService, RestaurantStorageService restaurantStorageService) {

        super(navigator);
        this.mRestaurantCloudService = restaurantCloudService;
        this.mRestaurantStorageService = restaurantStorageService;

    }

    //endregion


    //region public methods

    public void callPhone(String phoneNumber){

        String uri = "tel:"+phoneNumber;

        Intent mIntent = new Intent(Intent.ACTION_DIAL);

        mIntent.setData(Uri.parse(uri));

        getNavigator().getApplication().getCurrentActivity().startActivity(mIntent);
    }


    //endregion

    @Override
    public void onCreate() {
        super.onCreate();
        getEventBus().register(this);
//        getNavigator().showBusyIndicator("Loading....");
    }

    @Override
    public void onStart() {
        super.onStart();
        getEventBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRestaurant = null;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void event(Restaurant restaurant) {

        Log.d("ccc","cccc");
        setRestaurant(restaurant);

        getNavigator().getApplication().getCurrentActivity().setTitle(restaurant.getName());

        getEventBus().unregister(this);
    }
}
