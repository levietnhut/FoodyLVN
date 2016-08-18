package com.nhutdu.core.model.services;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.view.ICallback;

import java.util.List;

/**
 * Created by NhutDu on 16/08/2016.
 */
public interface IRestaurantService {

    void getAllRestaurants(ICallback<List<Restaurant>> callback);
}
