package com.nhutdu.core.model.services.clouds;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.responses.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 7/31/2016.
 */
public interface IRestaurantCloudService {

    @GET("api/v1/restaurants")
    Call<ApiResponse<List<Restaurant>>> getAllRestaurants();

    @GET("api/v1/restaurants")
    Call<ApiResponse<List<Restaurant>>> getRestaurantsByCategory(@Query("category_id") int category_id);
}
