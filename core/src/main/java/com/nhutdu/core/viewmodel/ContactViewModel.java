package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.widget.Toast;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Contact;
import com.nhutdu.core.model.services.IFoodyApiService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.INavigator;

/**
 * Created by NhutDu on 02/08/2016.
 */
public class ContactViewModel extends BaseViewModel {

    //region Properties
    private Contact mContact;

    private IFoodyApiService mFoodyApiService;

    //endregion

    //region Getter and Setter
    @Bindable
    public Contact getContact() {
        return mContact;
    }

    public void setContact(Contact mContactr) {
        this.mContact = mContactr;
        notifyPropertyChanged(BR.contact);
    }


    //endregion

    // region Constructor

    public ContactViewModel(INavigator navigator) {
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

    public void sendContact(){

        getNavigator().navigateTo(Constants.MAIN_PAGE);
    }

    //endregion
}
