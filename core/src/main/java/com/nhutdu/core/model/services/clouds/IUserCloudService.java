package com.nhutdu.core.model.services.clouds;

import com.nhutdu.core.model.entities.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by NhutDu on 10/08/2016.
 */
public interface IUserCloudService {

    @GET("/logIn")
    Call<User> logIn(@Query("tag")String tag,@Query("username") String username, @Query("password") String password);

}
