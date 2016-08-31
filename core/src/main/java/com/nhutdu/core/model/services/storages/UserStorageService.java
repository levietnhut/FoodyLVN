package com.nhutdu.core.model.services.storages;

import android.util.Log;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.entities.User;
import com.nhutdu.core.model.services.IUserService;
import com.nhutdu.core.view.ICallback;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

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
    public void logIn(User user, final ICallback<User> callback) {

        final User checkedUser = mRealm.where(User.class).equalTo("mEmail", user.getEmail()).equalTo("mPassword", user.getPassword()).findFirstAsync();

        checkedUser.addChangeListener(new RealmChangeListener<User>() {
            @Override
            public void onChange(User element) {
                callback.onResult(element);
                checkedUser.removeChangeListener(this);
            }
        });

    }

    public void getAllUser(){
        RealmResults<User> users = mRealm.where(User.class).findAll();
        for(User user:users){
            Log.d("user",user.toString());
        }
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

    @Override
    public void addFavoriteRestaurants(User user, Restaurant restaurant, final ICallback<Boolean> callback) {
        final String email = user.getEmail();

        final int id = restaurant.getId();

        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                User checkUser = realm.where(User.class).equalTo("mEmail",email).findFirst();

                Restaurant res = realm.where(Restaurant.class).equalTo("mId",id).findFirst();

                checkUser.getFavoriteRestaurant().add(res);

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

    @Override
    public void removeFavoriteRestaurants(User user, Restaurant restaurant, final ICallback<Boolean> callback) {
        final String email = user.getEmail();

        final int id = restaurant.getId();

        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                User checkUser = realm.where(User.class).equalTo("mEmail",email).findFirst();

                Restaurant res = realm.where(Restaurant.class).equalTo("mId",id).findFirst();

                checkUser.getFavoriteRestaurant().remove(res);

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

    @Override
    public void getFavoriteRestaurants(User user, final ICallback<List<Restaurant>> callback) {
        User checkUser = mRealm.where(User.class).equalTo("mEmail",user.getEmail()).findFirstAsync();

        checkUser.addChangeListener(new RealmChangeListener<User>() {
            @Override
            public void onChange(User element) {
                callback.onResult(element.getFavoriteRestaurant());

                element.addChangeListener(this);
            }
        });
    }
}
