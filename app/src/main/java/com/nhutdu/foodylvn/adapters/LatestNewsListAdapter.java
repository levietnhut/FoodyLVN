package com.nhutdu.foodylvn.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nhutdu.core.model.entities.Food;
import com.nhutdu.core.view.BaseRecyclerViewAdapter;
import com.nhutdu.core.view.ViewHolder;
import com.nhutdu.core.viewmodel.LatestNewsViewModel;
import com.nhutdu.foodylvn.BR;
import com.nhutdu.foodylvn.R;

import java.util.List;

/**
 * Created by TVG on 7/28/16.
 */
public class LatestNewsListAdapter extends BaseRecyclerViewAdapter<LatestNewsViewModel, List<Food>> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_item_news, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = ((ViewHolder) holder).getViewDataBinding();
        viewDataBinding.setVariable(BR.viewModel, mViewModel);
        viewDataBinding.setVariable(BR.food, mData.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

}
