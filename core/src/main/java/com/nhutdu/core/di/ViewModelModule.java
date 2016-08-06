package com.nhutdu.core.di;

import com.nhutdu.core.view.INavigator;
import com.nhutdu.core.viewmodel.CategoryViewModel;
import com.nhutdu.core.viewmodel.ContactViewModel;
import com.nhutdu.core.viewmodel.LatestNewsViewModel;
import com.nhutdu.core.viewmodel.LoginViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TVG on 7/27/16.
 */

@Module(includes = { AppModule.class })
public class ViewModelModule {

    //region Provide methods

    @Provides
    @Singleton
    public LoginViewModel providesLoginViewModel(INavigator navigator) {
        return new LoginViewModel(navigator);
    }

    @Provides
    @Singleton
    public LatestNewsViewModel providesLatestNewsViewModel(INavigator navigator) {
        return new LatestNewsViewModel(navigator);
    }

    @Provides
    @Singleton
    public ContactViewModel providesContactViewModel(INavigator navigator) {
        return new ContactViewModel(navigator);
    }

    @Provides
    @Singleton
    public CategoryViewModel providesCategoryViewModel(INavigator navigator) {
        return new CategoryViewModel(navigator);
    }

    //endregion

}
