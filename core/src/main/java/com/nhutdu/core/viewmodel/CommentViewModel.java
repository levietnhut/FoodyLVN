package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Comment;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.storages.RestaurantStorageService;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 31/08/2016.
 */
public class CommentViewModel extends BaseViewModel {

    //region Properties

    RestaurantCloudService mRestaurantCloudService;

    RestaurantStorageService mRestaurantStorageService;

    Restaurant mRestaurant;

    Comment mComment;

    //endregion

    //region Getter and Setter

    public Comment getComment() {
        return mComment;
    }

    public void setComment(Comment comment) {
        mComment = comment;
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

    public CommentViewModel(INavigator navigator,RestaurantCloudService restaurantCloudService,RestaurantStorageService restaurantStorageService) {
        super(navigator);
        this.mRestaurantCloudService = restaurantCloudService;
        this.mRestaurantStorageService = restaurantStorageService;
    }

    //endregion
}
