package com.nhutdu.core.model.services.storages;

import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IUserService;
import com.nhutdu.core.view.ICallback;

import java.util.Calendar;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;

/**
 * Created by NhutDu on 23/08/2016.
 */
public class UserStorageService extends BaseStorageService implements IUserService {

    //region Constructor

    public UserStorageService(Realm realm) {
        super(realm);
    }

    //endregion

    @Override
    public void logIn(final User user, final ICallback<User> callback) {

        final User userLogin = mRealm.where(User.class).equalTo("mEmail",user.getEmail()).equalTo("mPassword",user.getPassword()).findFirstAsync();

        userLogin.addChangeListener(new RealmChangeListener<User>() {
            @Override
            public void onChange(User element) {
                callback.onResult(element);

                userLogin.removeChangeListener(this);
            }
        });

    }

    @Override
    public void register(final User user, final ICallback<Boolean> callback) {
        final User userCheck = mRealm.where(User.class).equalTo("mEmail",user.getEmail()).findFirst();

        if(userCheck ==null){
            user.setId(UUID.randomUUID().toString());
            user.setCreatedAt(Calendar.getInstance().getTime());

            mRealm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User realmUser = realm.copyToRealm(user);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    callback.onResult(true);
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    callback.onFailure(error);
                }
            });
        }

    }
}
