package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.view.BaseFragment;
import com.nhutdu.core.viewmodel.AddRestaurantViewModel;
import com.nhutdu.core.viewmodel.CategoryViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.databinding.ActivityAddRestaurantBinding;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by NhutDu on 06/08/2016.
 */
public class CreateRestaurantActivity extends BaseActivity<ActivityAddRestaurantBinding,AddRestaurantViewModel>{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_add_restaurant, BR.viewModel);
    }
}
