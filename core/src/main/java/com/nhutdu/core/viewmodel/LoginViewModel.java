package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IUserService;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class LoginViewModel extends BaseViewModel {

    //region Properties
    private User mUser;

    private UserCloudService mUserCloudService;

    //endregion

    //region Getter and Setter

    public User getUser() {
        return mUser;
    }

    public LoginViewModel setUser(User user) {
        mUser = user;
        return this;
    }

    //endregion

    // region Constructor

    public LoginViewModel(INavigator navigator, UserCloudService mUserCloudService) {
        super(navigator);
        this.mUserCloudService = mUserCloudService;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //endregion

    //region Private methods

//    private void getUsers() {
//        mFoodyApiService.getUsers().enqueue(new Callback<ResponseUser>() {
//            @Override
//            public void onResponse(Call<ResponseUser> call, ApiResponse<ResponseUser> response) {
//                boolean check = false;
//                ResponseUser responseUser = response.body();
//                if (responseUser != null) {
//                    for (User user : responseUser.getmUsers()) {
//                        if (user.getmName() == "vietnhut") {
//                            Log.d("user", "ok");
//                            check = true;
//                        }
//                    }
//                    if (!check) {
//                        Log.d("user", "don't exist");
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseUser> call, Throwable t) {
//
//            }
//        });
//    }

    public void logIn(final User user){
        Log.e("cccccc","cccccc");
        getNavigator().showBusyIndicator("Loading....");
        mUserCloudService.logIn(user, new ICallback<User>() {
            @Override
            public void onResult(User result) {
                getNavigator().hideBusyIndicator();
                getEventBus().post(user);

                getNavigator().goBack();
            }

            @Override
            public void onFailure(Throwable t) {
                getNavigator().hideBusyIndicator();
            }
        });
    }

    public void showRegister(){
        getNavigator().navigateTo(Constants.REGISTER_PAGE);
    }

    //endregion


}
