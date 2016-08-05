package com.nhutdu.foodylvn.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhutdu.foodylvn.R;

/**
 * Created by NhutDu on 03/08/2016.
 */
public class CategoryFragment extends android.support.v4.app.Fragment {

    //region Constructor

    public CategoryFragment() {
    }

    //endregion

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }
}
