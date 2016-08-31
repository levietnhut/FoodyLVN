package com.nhutdu.core.model.services.clouds;

import android.util.Log;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.entities.Comment;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.responses.ApiResponse;
import com.nhutdu.core.model.services.IRestaurantService;
import com.nhutdu.core.view.ICallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 7/31/2016.
 */
public class RestaurantCloudService extends BaseCloudService<IRestaurantCloudService> implements IRestaurantService {

    //region Properties

    private static final String TAG = RestaurantCloudService.class.getSimpleName();

    //endregion

    //region Constructor

    public RestaurantCloudService(IRestaurantCloudService iRestaurantCloudService) {
        mICloudService = iRestaurantCloudService;
    }

    //endregion

    @Override
    public void getAllRestaurants(final ICallback<List<Restaurant>> callback) {
        getICloudService().getAllRestaurants().enqueue(new Callback<ApiResponse<List<Restaurant>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Restaurant>>> call, Response<ApiResponse<List<Restaurant>>> response) {
                    List<Restaurant> restaurants = response.body().getData();

                    if(restaurants!=null){

                        Log.d(TAG,"load restaurants success");
                        callback.onResult(restaurants);

                    }else{
                        Log.d(TAG,"don't have restaurant");
                    }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Restaurant>>> call, Throwable t) {

            }
        });
    }

    @Override
    public void saveRestaurant(Restaurant restaurant, ICallback<Boolean> callback) {

    }

    @Override
    public void saveRestaurants(List<Restaurant> restaurants, ICallback<Boolean> callback) {
    }

    @Override
    public void getRestaurantsByCategory(Category category, final ICallback<List<Restaurant>> callback) {
        mICloudService.getRestaurantsByCategory(category.getId()).enqueue(new Callback<ApiResponse<List<Restaurant>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Restaurant>>> call, Response<ApiResponse<List<Restaurant>>> response) {
                ApiResponse<List<Restaurant>> apiResponse = response.body();
                if(apiResponse.isSuccess()){
                    Log.d(TAG,"load res by cat success");
                    callback.onResult(apiResponse.getData());
                }else{
                    Log.d(TAG,"load res by cat failed");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Restaurant>>> call, Throwable t) {
                Log.d(TAG,"",t);
            }
        });
    }

    @Override
    public void addComment(Comment comment, Restaurant restaurant, ICallback<Boolean> callback) {

    }
}
