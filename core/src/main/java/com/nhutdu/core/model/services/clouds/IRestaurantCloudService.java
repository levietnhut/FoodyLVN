package com.nhutdu.core.model.services.clouds;

import com.nhutdu.core.model.responses.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 7/31/2016.
 */
public interface IRestaurantCloudService {

    @GET("api/v1/restaurants")
    Call<ApiResponse> getAllRestaurants();
}
