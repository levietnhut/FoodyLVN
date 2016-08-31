package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.viewmodel.RestaurantDetailViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.databinding.ActivityRestaurantDetailBinding;
import com.nhutdu.foodylvn.databinding.FragmentCategoryBinding;

/**
 * Created by NhutDu on 28/08/2016.
 */
public class RestaurantDetailActivity extends BaseActivity<ActivityRestaurantDetailBinding,RestaurantDetailViewModel>{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_restaurant_detail, BR.viewModel);

        setToolbar(R.id.toolbar);

        setTitle("Restaurant Detail");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
