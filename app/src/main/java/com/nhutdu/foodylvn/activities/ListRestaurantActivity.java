package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.viewmodel.ListRestaurantViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.adapters.ListRestaurantAdapter;
import com.nhutdu.foodylvn.databinding.ActivityListRestaurantBinding;

/**
 * Created by NhutDu on 09/08/2016.
 */
public class ListRestaurantActivity extends BaseActivity<ActivityListRestaurantBinding,ListRestaurantViewModel> {

    //region Properties

    ListRestaurantAdapter mListRestaurantAdapter;

    //endregion

    //region Constructor

    public ListRestaurantActivity() {
    }

    //endregion


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        App.sharedComponent().inject(this);

        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_list_restaurant, BR.viewModel);

        setToolbar(R.id.toolbar);
        setTitle("List Restaurant");

       getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list_restaurant);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        mListRestaurantAdapter = new ListRestaurantAdapter();

        mListRestaurantAdapter.setViewModel(mViewModel);

        recyclerView.setAdapter(mListRestaurantAdapter);

    }
}
