package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by NhutDu on 09/08/2016.
 */
public class RestaurantsByCategoryViewModel extends BaseViewModel {

    //region Properties

    private Category mCategory;

    private List<Restaurant> mRestaurants;

    private RestaurantCloudService mRestaurantCloudService;

    private RestaurantStorageService mRestaurantStorageService;

    //endregion

    //region Getter and Setter

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    @Override
    protected EventBus getEventBus() {
        return super.getEventBus();
    }

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

    public RestaurantsByCategoryViewModel(INavigator navigator,RestaurantCloudService restaurantCloudService, RestaurantStorageService restaurantStorageService) {
        super(navigator);
        this.mRestaurantCloudService = restaurantCloudService;
        this.mRestaurantStorageService = restaurantStorageService;
    }

    //endregion

    // region method

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(Category category){
        setCategory(category);

        getNavigator().getApplication().getCurrentActivity().setTitle(category.getName());

        mRestaurantStorageService.getRestaurantsByCategory(category, new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {
                Log.d("size res bt category",""+result.size());
                setRestaurants(result);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        mRestaurantCloudService.getRestaurantsByCategory(category, new ICallback<List<Restaurant>>() {
            @Override
            public void onResult(List<Restaurant> result) {
                setRestaurants(result);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
//        getNavigator().showBusyIndicator("Loading....");
    }

    @Override
    public void onStart() {
        super.onStart();
        getEventBus().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getEventBus().unregister(this);
        mRestaurants = null;
    }
}
