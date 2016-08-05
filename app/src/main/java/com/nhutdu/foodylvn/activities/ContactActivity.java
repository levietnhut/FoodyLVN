package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.viewmodel.ContactViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.databinding.ActivityContactBinding;

/**
 * Created by NhutDu on 05/08/2016.
 */
public class ContactActivity extends BaseActivity<ActivityContactBinding,ContactViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_contact, BR.viewModel);

        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Contact");
    }
}
