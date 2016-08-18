package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.services.clouds.CategoryCloudService;
import com.nhutdu.core.view.Constants;
import com.nhutdu.core.view.ICallback;
import com.nhutdu.core.view.INavigator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NhutDu on 06/08/2016.
 */
public class CategoryViewModel extends BaseViewModel {

    //region Properties

    private final static String TAG = CategoryViewModel.class.getSimpleName();

    private List<Category> mCategories;

    private CategoryCloudService mCategoryCloudService;

    //endregion

    //region Getter and Setter
    @Bindable
    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {

        mCategories = categories;
        notifyPropertyChanged(com.nhutdu.core.BR.categories);
    }

    //endregion

    //region Constructor

    public CategoryViewModel(INavigator navigator, CategoryCloudService categoryCloudService) {
        super(navigator);
        this.mCategoryCloudService = categoryCloudService;

    }

    //endregion

    //region Private methods

    private void loadCategory(){
        mCategoryCloudService.getAllCategories(new ICallback<List<Category>>() {
            @Override
            public void onResult(List<Category> result) {
                Log.d(TAG,"load category success");
                setCategories(result);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG,"load category failes "+t.getLocalizedMessage());
            }
        });
        getNavigator().hideBusyIndicator();

    }

    //endregion

    //region Public methods

    public void showRestaurant(Category category){
        Log.d("show restaurant","OK");
        getEventBus().postSticky(category);

        getNavigator().navigateTo(Constants.LIST_RESTAURANT_PAGE);

    }

    //endregion


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"OK");
        getNavigator().showBusyIndicator("Loading....");
        loadCategory();

    }

    @Override
    public void onStart() {

        super.onStart();

        Log.d(TAG,"OK");
        getNavigator().showBusyIndicator("Loading....");
        loadCategory();

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mCategories = null;

    }
}
