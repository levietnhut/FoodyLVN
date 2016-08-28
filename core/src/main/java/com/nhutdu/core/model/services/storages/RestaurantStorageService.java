package com.nhutdu.core.model.services.storages;

import android.util.Log;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.model.services.IRestaurantService;
import com.nhutdu.core.view.ICallback;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;


/**
 * Created by NhutDu on 24/08/2016.
 */
public class RestaurantStorageService extends BaseStorageService implements IRestaurantService {

    //region Properties

    private static final String TAG = RestaurantStorageService.class.getSimpleName();

    //endregion

    //region Constructor
    public RestaurantStorageService(Realm realm) {

        super(realm);
    }

    //endregion

    //methods implements

    @Override
    public void getAllRestaurants(final ICallback<List<Restaurant>> callback) {

        final RealmResults<Restaurant> restaurants = mRealm.where(Restaurant.class).findAllAsync();

        restaurants.addChangeListener(new RealmChangeListener<RealmResults<Restaurant>>() {
            @Override
            public void onChange(RealmResults<Restaurant> element) {
                callback.onResult(element);

                restaurants.removeChangeListener(this);
            }
        });
    }

    @Override
    public void saveRestaurant(final Restaurant restaurant, final ICallback<Boolean> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Restaurant res = realm.copyFromRealm(restaurant);
                Log.d(TAG,"save restaurant success");
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
    public void saveRestaurants(final List<Restaurant> restaurants, final ICallback<Boolean> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(restaurants);
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
    public void getRestaurantsByCategory(Category category, final ICallback<List<Restaurant>> callback) {
        final RealmResults<Restaurant> restaurants = mRealm.where(Restaurant.class).equalTo("mCategoryId",category.getId()).findAllAsync();

        restaurants.addChangeListener(new RealmChangeListener<RealmResults<Restaurant>>() {
            @Override
            public void onChange(RealmResults<Restaurant> element) {
                callback.onResult(element);
                restaurants.removeChangeListener(this);
            }
        });
    }

    //endregion
}
