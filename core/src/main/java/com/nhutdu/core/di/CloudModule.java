package com.nhutdu.core.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nhutdu.core.di.AppModule;
import com.nhutdu.core.model.services.Configuration;
import com.nhutdu.core.model.services.clouds.CategoryCloudService;
import com.nhutdu.core.model.services.clouds.ICategoryCloudService;
import com.nhutdu.core.model.services.clouds.IRestaurantCloudService;
import com.nhutdu.core.model.services.clouds.IUserCloudService;
import com.nhutdu.core.model.services.clouds.RestaurantCloudService;
import com.nhutdu.core.model.services.clouds.UserCloudService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 7/26/2016.
 */

@Module(includes = { AppModule.class })
public class CloudModule {

    //region Provide methods

    @Provides
    @Singleton
    public IRestaurantCloudService providesRestaurantService() {
        Gson gson = createGson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Configuration.FOODY_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IRestaurantCloudService.class);
    }


    @Provides
    @Singleton
    public IUserCloudService providesUserService() {
        Gson gson = createGson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Configuration.FOODY_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IUserCloudService.class);
    }

    @Provides
    @Singleton
    public ICategoryCloudService providesCategoryService(){
        Gson gson = createGson();

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(Configuration.FOODY_API_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .build();

        return retrofit.create(ICategoryCloudService.class);
    }

    @Provides
    @Singleton
    public CategoryCloudService providesCategoryCloudService(ICategoryCloudService iCategoryCloudService){
        return new CategoryCloudService(iCategoryCloudService);
    }

    @Provides
    @Singleton
    public RestaurantCloudService providesRestaurantCloudService(IRestaurantCloudService iRestaurantCloudService) {
        return new RestaurantCloudService(iRestaurantCloudService);
    }

    @Provides
    @Singleton
    public UserCloudService providesUserCloudService(IUserCloudService iUserCloudService) {
        return new UserCloudService(iUserCloudService);
    }

    //endregion

    //region Private methods

    private Gson createGson() {
        return new GsonBuilder().setLenient()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    //endregion
}
