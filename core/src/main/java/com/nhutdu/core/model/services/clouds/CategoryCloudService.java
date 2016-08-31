package com.nhutdu.core.model.services.clouds;

import android.util.Log;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.responses.ApiResponse;
import com.nhutdu.core.model.services.ICategoryService;
import com.nhutdu.core.view.ICallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NhutDu on 17/08/2016.
 */
public class CategoryCloudService extends BaseCloudService<ICategoryCloudService> implements ICategoryService {

    //region Properties

    public static final String TAG = CategoryCloudService.class.getSimpleName();

    //endregion

    //region Constructor

    public CategoryCloudService(ICategoryCloudService iICategoryCloudService) {
        mICloudService = iICategoryCloudService;
    }


    //endregion

    @Override
    public void getAllCategories(final ICallback<List<Category>> callback) {
      getICloudService().getAllCategories().enqueue(new Callback<ApiResponse<List<Category>>>() {
          @Override
          public void onResponse(Call<ApiResponse<List<Category>>> call, Response<ApiResponse<List<Category>>> response) {
              ApiResponse<List<Category>> apiResponse = response.body();
              if(apiResponse.isSuccess()){

                    Log.d("load category","success");
                    callback.onResult(apiResponse.getData());
              }else{
                    Log.d("load category","failed");
              }
          }

          @Override
          public void onFailure(Call<ApiResponse<List<Category>>> call, Throwable t) {
                Log.d("api","",t);
          }
      });
    }

    @Override
    public void saveCategory(Category category, ICallback<Boolean> callback) {

    }

    @Override
    public void saveCategories(List<Category> categories, ICallback<Boolean> callback) {

    }
}
