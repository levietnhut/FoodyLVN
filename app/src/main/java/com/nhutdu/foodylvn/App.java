package com.nhutdu.foodylvn;

import com.nhutdu.core.di.AppModule;
import com.nhutdu.core.di.ViewModelModule;
import com.nhutdu.core.view.BaseApplication;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.INavigator;
import com.nhutdu.foodylvn.activities.AboutActivity;
import com.nhutdu.foodylvn.activities.ContactActivity;
import com.nhutdu.foodylvn.activities.CreateRestaurantActivity;
import com.nhutdu.foodylvn.activities.LoginActivity;
import com.nhutdu.foodylvn.activities.MainActivity;
import com.nhutdu.foodylvn.activities.RegisterActivity;

/**
 * Created by TVG on 7/19/16.
 */
public class App extends BaseApplication {

    //region Properties

    private static AppComponent sAppComponent;

    //endregion

    //region Getter and Setter

    public synchronized static AppComponent sharedComponent() {
        return sAppComponent;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);
        INavigator navigator = appModule.getNavigator();
        navigator.configure(Constants.MAIN_PAGE, MainActivity.class);
        navigator.configure(Constants.LOGIN_PAGE, LoginActivity.class);
        navigator.configure(Constants.REGISTER_PAGE, RegisterActivity.class);
        navigator.configure(Constants.CONTACT_PAGE, ContactActivity.class);
        navigator.configure(Constants.ABOUT_PAGE, AboutActivity.class);
        navigator.configure(Constants.CREATE_RESTAURANT_PAGE, CreateRestaurantActivity.class);

        sAppComponent = DaggerAppComponent.builder()
                                          .appModule(appModule)
                                          .viewModelModule(new ViewModelModule())
                                          .build();
    }

    //endregion

}
