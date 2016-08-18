package com.nhutdu.core.viewmodel;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.view.INavigator;

/**
 * Created by NhutDu on 07/08/2016.
 */
public class DetailRestaurantViewModel extends BaseViewModel {

    //region Properties

    private Restaurant mRestaurant;

    //endregion

    //region Getter and Setter

    public Restaurant getRestaurant() {
        return mRestaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        mRestaurant = restaurant;
    }

    //endregion

    public DetailRestaurantViewModel(INavigator navigator) {
        super(navigator);
    }

    @Override
    public void onCreate() {

        super.onCreate();
        getNavigator().showBusyIndicator("Loading.....");

    }

    @Override
    public void onDestroy() {

        super.onDestroy();

    }

}
