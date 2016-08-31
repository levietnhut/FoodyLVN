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

    private String mError;

    //endregion

    //region Getter and Setter

    @Bindable
    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
        notifyPropertyChanged(BR.error);
    }

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

    //region validate restaurant

    public boolean isValid(Restaurant restaurant){

        if(restaurant.getName().isEmpty()){

            setError("Vui lòng nhập Name Restaurant");
            return false;
        }

        if(restaurant.getAddress().isEmpty()){

            setError("Vui lòng nhập Address");
            return false;
        }
        if(restaurant.getOpenTime().isEmpty()){

            setError("Vui lòng nhập Open Time");
            return false;
        }
        if(restaurant.getCloseTime().isEmpty()){

            setError("Vui lòng nhập Close Time");
            return false;
        } if(restaurant.getPhoneNumber().isEmpty()){

            setError("Vui lòng nhập Phone Number");
            return false;
        }
        if(restaurant.getContent().isEmpty()){

            setError("Vui lòng nhập nội dung");
            return false;
        }

        return true;
    }

    //endregion

    //public methods

    public void saveRestaurant(Restaurant restaurant){
        if(restaurant==null){
            return;
        }
        if(isValid(restaurant)){
            mRestaurantStorageService.saveRestaurant(restaurant, new ICallback<Boolean>() {
                @Override
                public void onResult(Boolean result) {
                    if(result){
                        getNavigator().navigateTo(Constants.MAIN_PAGE);
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d(TAG,"",t);
                }
            });
        }

    }

    //endregion


    @Override
    public void onCreate() {
        super.onCreate();

        mRestaurant = new Restaurant("","","","","","");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mRestaurant = null;
        mError = null;
    }
}
