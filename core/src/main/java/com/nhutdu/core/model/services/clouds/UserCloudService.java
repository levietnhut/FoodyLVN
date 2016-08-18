package com.nhutdu.core.model.services.clouds;

import android.util.Log;
import android.widget.Toast;

import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IUserService;
import com.nhutdu.core.view.ICallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NhutDu on 10/08/2016.
 */
public class UserCloudService extends BaseCloudService<IUserCloudService> implements IUserService{

    //region Constructor

    public UserCloudService(IUserCloudService iUserCloudService) {
        mICloudService = iUserCloudService;
    }

    //endregion

    // region Public methods

    @Override
    public void logIn(User user, final ICallback<User> callback) {
        getICloudService().logIn("login",user.getUserName(), user.getPassword()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.d("user",user.getUserName());
                if(user!=null){
                    callback.onResult(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserCloudService",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void register(User user, ICallback<User> callback) {
    }

    //endregion
}
