package com.nhutdu.core.model.services;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.view.ICallback;

import java.util.List;

/**
 * Created by NhutDu on 10/08/2016.
 */
public interface IUserService {

    void logIn(User user, ICallback<User> callback);
    void register(User user, ICallback<Boolean> callback);

    void addFavoriteRestaurants(User user, Restaurant restaurant, ICallback<Boolean> callback);
    void removeFavoriteRestaurants(User user, Restaurant restaurant, ICallback<Boolean> callback);
    void getFavoriteRestaurants(User user,ICallback<List<Restaurant>> callback);
}
