package com.nhutdu.core.model.services;

import com.nhutdu.core.model.responses.ResponseUser;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NhutDu on 02/08/2016.
 */
public interface IFoodyApiService {
    @GET("")
    Call<ResponseUser> getUsers();
}
