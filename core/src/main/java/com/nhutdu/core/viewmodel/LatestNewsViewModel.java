package com.nhutdu.core.viewmodel;

import android.databinding.Bindable;
import android.util.Log;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Food;
import com.nhutdu.core.view.INavigator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NhutDu on 04/08/2016.
 */
public class LatestNewsViewModel extends BaseViewModel {

    //region Properties

    private List<Food> mFoods;

    //endregion

    //region Getter and Setter

    @Bindable
    public List<Food> getFoods() {
        return mFoods;
    }

    public void setFoods(List<Food> mFoods) {
        this.mFoods = mFoods;
        notifyPropertyChanged(BR.foods);
    }

    //endregion

    //region Constructor

    public LatestNewsViewModel(INavigator navigator) {
        super(navigator);
    }

    //endregion

    //region Private methods

    private void loadFoods(){
        List<Food> lFoods = new ArrayList<>();
        Food food = new Food(1,"Nhut Le Viet","hinh1",null,"méo có nội dung đâu nhé...",null);
        Food food1 = new Food(1,"Hong Tran Thu","hinh1",null,"méo có nội dung đâu nhé...",null);
        Food food2 = new Food(1,"Ha Pham Thu","hinh1",null,"méo có nội dung đâu nhé...",null);
        lFoods.add(food);
        lFoods.add(food1);
        lFoods.add(food2);
        setFoods(lFoods);
        getNavigator().hideBusyIndicator();
    }

    //endregion

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("start","ok");
        getNavigator().showBusyIndicator("Loading...");
        loadFoods();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFoods=null;
    }
}
