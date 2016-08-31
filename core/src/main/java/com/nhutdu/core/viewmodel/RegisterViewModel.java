package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.model.services.storages.UserStorageService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

/**
 * Created by NhutDu on 25/08/2016.
 */
public class RegisterViewModel extends BaseViewModel{

    //region Properties

    private static final String TAG = RegisterViewModel.class.getSimpleName();

    private User mUser;

    private UserCloudService mUserCloudService;

    private UserStorageService mUserStorageService;

    private String mError;

    //endregion

    //region Getter and Setter
    @Bindable
    public String getError() {
        return mError;
    }

    public void setError(String error) {

        mError = error;
        notifyPropertyChanged(BR.error);

    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;

    }

    //endregion

    //region Constructor

    public RegisterViewModel(INavigator navigator,UserCloudService userCloudService,UserStorageService userStorageService) {

        super(navigator);

        this.mUserStorageService = userStorageService;
        this.mUserCloudService = userCloudService;
    }

    //endregion

    //region validate

    private boolean isValidateUser(User user){

        if (user.getUserName().isEmpty()){
            setError("Vui lòng nhập username");
            return false;
        }

        if (user.getEmail().isEmpty()){
            setError("Vui lòng nhập email");
            return false;
        }
        if (user.getPassword().isEmpty()){
            setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if (user.getRetypePassword().isEmpty()){
            setError("Vui lòng nhập xác nhận mật khẩu");
            return false;
        }

        return  true;
    }

    //endregion

    //region Private methods

    public void registerUser(User user){
        Log.d(TAG,"register user");
        if(isValidateUser(user)){
            mUserStorageService.register(user, new ICallback<Boolean>() {
                @Override
                public void onResult(Boolean result) {
                    if(result){
                        Log.d(TAG,"register success");
                        getNavigator().goBack();
                    }else{
                        setError("Email đã được dùng");
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }
    }

    //endregion

    //region public methods

    public void backLoginActivity(){
        getNavigator().navigateTo(Constants.LOGIN_PAGE);
    }

    //endregion


    @Override
    public void onDestroy() {
        super.onDestroy();
        mUser =null;
        mError = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mUser= new User();
        mUser.setUserName("");
        mUser.setEmail("");
        mUser.setPassword("");
        mUser.setRetypePassword("");
    }
}
