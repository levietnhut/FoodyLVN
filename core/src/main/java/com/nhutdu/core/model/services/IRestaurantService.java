package com.nhutdu.core.model.services;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.view.ICallback;

import java.util.List;

/**
 * Created by NhutDu on 16/08/2016.
 */
public interface IRestaurantService {

    void getAllRestaurants(ICallback<List<Restaurant>> callback);
    void saveRestaurant(Restaurant restaurant, ICallback<Boolean> callback);
    void saveRestaurants(List<Restaurant> restaurants, ICallback<Boolean> callback);
    void getRestaurantsByCategory(Category category,ICallback<List<Restaurant>> callback);
}
