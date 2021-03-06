package com.nhutdu.foodylvn.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nhutdu.core.model.entities.Restaurant;
import com.nhutdu.core.view.BaseRecyclerViewAdapter;
import com.nhutdu.core.view.ViewHolder;
import com.nhutdu.core.viewmodel.LatestRestaurantsViewModel;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.BR;
import java.util.List;

/**
 * Created by TVG on 7/28/16.
 */
public class LatestRestaurantsListAdapter extends BaseRecyclerViewAdapter<LatestRestaurantsViewModel, List<Restaurant>> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_fragment_restaurants, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = ((ViewHolder) holder).getViewDataBinding();
        viewDataBinding.setVariable(BR.viewModel, mViewModel);
        viewDataBinding.setVariable(BR.restaurant, mData.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

}
