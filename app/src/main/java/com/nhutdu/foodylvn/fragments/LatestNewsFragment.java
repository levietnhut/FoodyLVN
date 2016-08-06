package com.nhutdu.foodylvn.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhutdu.core.view.BaseFragment;
import com.nhutdu.core.viewmodel.LatestNewsViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.adapters.LatestNewsListAdapter;
import com.nhutdu.foodylvn.databinding.FragmentLatestNewsBinding;

/**
 * Created by NhutDu on 03/08/2016.
 */
public class LatestNewsFragment extends BaseFragment<FragmentLatestNewsBinding,LatestNewsViewModel>{

    //region Properties

    LatestNewsListAdapter mAdapter;

    //endregion

    //region Constructor

    public LatestNewsFragment() {
    }

    //endregion

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setBindingContentView(inflater,container,R.layout.fragment_latest_news, BR.viewModel);

        View view = mViewDataBinding.getRoot();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_latest_news);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new LatestNewsListAdapter();

        mAdapter.setViewModel(mViewModel);

        recyclerView.setAdapter(mAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
