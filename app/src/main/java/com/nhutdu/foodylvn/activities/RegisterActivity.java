package com.nhutdu.foodylvn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nhutdu.foodylvn.R;

/**
 * Created by NhutDu on 04/08/2016.
 */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Register");
    }
}
