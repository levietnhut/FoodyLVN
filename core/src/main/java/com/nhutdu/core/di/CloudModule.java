package com.nhutdu.core.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nhutdu.core.model.services.Configuration;
import com.nhutdu.core.model.services.IFoodyApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TVG on 7/19/16.
 */

@Module(includes = { AppModule.class })
public class CloudModule {

    //region Provide methods

    @Provides
    @Singleton
    public IFoodyApiService provideFoodyApiService() {
        Gson gson = createGson();

        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(Configuration.FOODY_API_URL)
                                        .addConverterFactory(GsonConverterFactory.create(gson))
                                        .build();

        return retrofit.create(IFoodyApiService.class);
    }

    //endregion

    //region Private methods

    private Gson createGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                                .create();
    }

    //endregion

}
