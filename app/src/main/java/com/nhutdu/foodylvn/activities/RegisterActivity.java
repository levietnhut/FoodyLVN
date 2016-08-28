package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.viewmodel.RegisterViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.databinding.ActivityRegisterBinding;

/**
 * Created by NhutDu on 04/08/2016.
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        App.sharedComponent().inject(this);

        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_register, BR.viewModel);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Register");
    }
}
