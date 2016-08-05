package com.nhutdu.foodylvn;

import com.nhutdu.core.di.ViewModelModule;
import com.nhutdu.foodylvn.activities.ContactActivity;
import com.nhutdu.foodylvn.activities.LoginActivity;
import com.nhutdu.foodylvn.fragments.LatestNewsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TVG on 7/27/16.
 */

@Singleton
@Component(modules = { ViewModelModule.class })
public interface AppComponent {

    void inject(LoginActivity activity);
    void inject(ContactActivity activity);
    void inject(LatestNewsFragment fragment);


}
