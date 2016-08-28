package com.nhutdu.core.view;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.nhutdu.core.model.entities.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by TVG on 7/18/16.
 */
public abstract class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks {

    //region Properties

    private Activity mCurrentActivity;

    private User mUserLogin;

    //endregion

    //region Setter and Getter

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public boolean isCurrentActivityAvailable() {
        return mCurrentActivity != null;
    }

    public User getUserLogin() {
        return mUserLogin;
    }

    public void setUserLogin(User userLogin) {
        mUserLogin = userLogin;
    }

    public boolean isUserLogin(){
        return (mUserLogin !=null);
    }

    //endregion

    //region Application lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    //endregion

    //region ActivityLifecycleCallbacks implement

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (mCurrentActivity != activity) {
            mCurrentActivity = activity;
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (mCurrentActivity != activity) {
            mCurrentActivity = activity;
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    //endregion

}
