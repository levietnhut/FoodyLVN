package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.databinding.tool.util.L;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IUserService;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.model.services.storages.UserStorageService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.List;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class LoginViewModel extends BaseViewModel {

    //region Properties

    private static final String TAG = LoginViewModel.class.getSimpleName();

    private User mUser;

    private UserCloudService mUserCloudService;

    private UserStorageService mUserStorageService;

    private String mError;

    //endregion

    //region Getter and Setter

    public User getUser() {
        return mUser;
    }

    public LoginViewModel setUser(User user) {
        mUser = user;
        return this;
    }
    @Bindable
    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
        notifyPropertyChanged(BR.error);
    }

    //endregion

    // region Constructor

    public LoginViewModel(INavigator navigator, UserCloudService userCloudService, UserStorageService userStorageService) {
        super(navigator);
        this.mUserCloudService = userCloudService;
        this.mUserStorageService = userStorageService;
    }

    //endregion

    //method check validate user

    public boolean validateUser(User user){

        if(user.getEmail().isEmpty()){
            setError("Vui lòng nhập email");
            return false;
        }
        if(user.getPassword().isEmpty()){
            setError("Vui lòng nhập mật khẩu");
            return false;
        }

        return true;
    }

    //endregion


    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        mUser = new User();
        mUser.setEmail("");
        mUser.setPassword("");
        mUserStorageService.getAllUser();
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

        mUser=null;
        mError= null;
    }

    //endregion

    //region Private methods

    public void logIn(User user) {

        if (validateUser(user)) {
            getNavigator().showBusyIndicator("Đăng nhập");


            mUserStorageService.logIn(user, new ICallback<User>() {
                @Override
                public void onResult(User result) {

                    Log.d("result", result.toString());

                    if (result.isLoaded() && result.isValid()) {
                        getNavigator().hideBusyIndicator();

                        getEventBus().post(result);

                        getNavigator().getApplication().setUserLogin(result);

                        getNavigator().goBack();
                    }
                    else {
                        setError("Tài khoản hoặc mật khẩu không đúng");
                        getNavigator().hideBusyIndicator();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    getNavigator().hideBusyIndicator();
                }
            });
        }


//        mUserCloudService.logIn(user, new ICallback<User>() {
//            @Override
//            public void onResult(User result) {
//                getNavigator().hideBusyIndicator();
//                getEventBus().post(user);
//
//                getNavigator().goBack();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                getNavigator().hideBusyIndicator();
//            }
//        });
    }

    public void showRegister(){
        getNavigator().navigateTo(Constants.REGISTER_PAGE);
    }

    //endregion


}
