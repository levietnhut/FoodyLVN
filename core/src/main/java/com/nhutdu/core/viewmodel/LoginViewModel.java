package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IFoodyApiService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class LoginViewModel extends BaseViewModel {

    //region Properties
    private User mUser;

    private IFoodyApiService mFoodyApiService;

    private List<User> mUsers;

    //endregion

    //region Getter and Setter
    @Bindable
    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public List<User> getmUsers() {
        return mUsers;
    }

    public void setmUsers(List<User> mUsers, IFoodyApiService service) {

        this.mUsers = mUsers;

        this.mFoodyApiService = service;
    }

    //endregion

    // region Constructor

    public LoginViewModel(INavigator navigator) {
        super(navigator);
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
//            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
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

    public void showRegister(){
        Log.d("log","Sao may meo chay the thang cho");
        getNavigator().navigateTo(Constants.REGISTER_PAGE);
    }

    //endregion
}
