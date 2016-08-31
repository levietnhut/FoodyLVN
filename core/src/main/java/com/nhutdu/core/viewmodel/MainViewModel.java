package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.clouds.UserCloudService;
import com.nhutdu.core.model.services.storages.UserStorageService;
import com.nhutdu.core.view.INavigator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by NhutDu on 30/08/2016.
 */
public class MainViewModel extends BaseViewModel {

    //region Properties

    private UserCloudService mUserCloudService;

    private UserStorageService mUserStorageService;

    private User mUser;

    private static final String TAG = MainViewModel.class.getSimpleName();

    //endregion


    //region Constructor

    public MainViewModel(INavigator navigator, UserCloudService userCloudService,UserStorageService userStorageService) {
        super(navigator);
        this.mUserCloudService = userCloudService;
        this.mUserStorageService = userStorageService;
    }

    //endregion

    //region Getter and Setter
    @Bindable
    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;

        notifyPropertyChanged(BR.user);
    }

    //endregion

    //region event bus

    //endregion
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(User user){
        setUser(user);
    }

    //region override methods

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
        mUser = null;
    }

    //endregion

}
