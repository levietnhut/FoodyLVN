package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.viewmodel.LoginViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.databinding.ActivityLoginBinding;

/**
 * Created by NhutDu on 03/08/2016.
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_login, BR.viewModel);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Login");
        setToolbar(R.id.toolbar);
    }
}
