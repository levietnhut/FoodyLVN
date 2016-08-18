package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 09/08/2016.
 */
public class ListRestaurantViewModel extends BaseViewModel {

    //region Properties

    private List<Restaurant> mRestaurants;

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

    public ListRestaurantViewModel(INavigator navigator) {

        super(navigator);
    }

    //endregion

    //region private methods

    private void loadListRestaurant(){
        getNavigator().hideBusyIndicator();

    }

    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
        getNavigator().showBusyIndicator("Loading....");
        loadListRestaurant();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRestaurants = null;
    }
}
