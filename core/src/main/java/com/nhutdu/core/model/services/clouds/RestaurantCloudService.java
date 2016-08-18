package com.nhutdu.core.model.services.clouds;

import android.util.Log;

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
        getICloudService().getAllRestaurants().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d(TAG,response.body().toString());
                ApiResponse apiResponse = response.body();
                if(apiResponse.isSuccess()){
                    Log.d(TAG,apiResponse.getData().get(0).toString());
                    callback.onResult(apiResponse.getData());
                }else{
                    Log.d(TAG,"cant load restaurant");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(TAG,"",t);
            }
        });
    }

}
