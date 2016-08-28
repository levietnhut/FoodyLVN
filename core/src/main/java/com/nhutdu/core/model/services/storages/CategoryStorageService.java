package com.nhutdu.core.model.services.storages;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.services.ICategoryService;
import com.nhutdu.core.view.ICallback;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by NhutDu on 23/08/2016.
 */
public class CategoryStorageService extends BaseStorageService implements ICategoryService {

    //region Constructor

    public CategoryStorageService(Realm realm) {
        super(realm);
    }

    //endregion

    // methods implements

    @Override
    public void getAllCategories(final ICallback<List<Category>> callback) {
        final RealmResults<Category> categories = mRealm.where(Category.class).findAllAsync();

        categories.addChangeListener(new RealmChangeListener<RealmResults<Category>>() {
            @Override
            public void onChange(RealmResults<Category> element) {
                callback.onResult(element);
                categories.removeChangeListener(this);
            }
        });
    }

    @Override
    public void saveCategory(final Category category, final ICallback<Boolean> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Category realmCategory = realm.copyToRealm(category);
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
    public void saveCategories(final List<Category> categories, final ICallback<Boolean> callback) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(categories);
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

    //endregion
}
