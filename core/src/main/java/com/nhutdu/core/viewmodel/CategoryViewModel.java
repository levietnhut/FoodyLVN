package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.model.entities.Category;
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

    public CategoryViewModel(INavigator navigator) {
        super(navigator);
    }

    //endregion

    //region Private methods

    private void loadCategory(){

        List<Category> categories = new ArrayList<>();
        Category category = new Category(1,"Cà phê phố","");
        Category category1 = new Category(2,"Lãng mạng sang trọng","");
        Category category2 = new Category(3,"Nhà hàng chay ngon nhất","");
        Category category3 = new Category(4,"Quán ăn vặt ngon nhất","");
        Category category4 = new Category(5,"Hẹn hò 100k","");
        Category category5 = new Category(6,"Trà sữa cóc","");
        Category category6 = new Category(7,"Quán ăn Hàn","");
        Category category7 = new Category(8,"Ăn vặt Sài Thành","");

        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);

        setCategories(categories);

        getNavigator().hideBusyIndicator();

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
