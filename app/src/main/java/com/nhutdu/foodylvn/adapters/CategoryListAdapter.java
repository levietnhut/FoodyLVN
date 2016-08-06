package com.nhutdu.foodylvn.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nhutdu.core.BR;
import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.view.BaseRecyclerViewAdapter;
import com.nhutdu.core.view.ViewHolder;
import com.nhutdu.core.viewmodel.CategoryViewModel;
import com.nhutdu.foodylvn.R;

import java.util.List;

/**
 * Created by NhutDu on 06/08/2016.
 */
public class CategoryListAdapter extends BaseRecyclerViewAdapter<CategoryViewModel,List<Category>>{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_category,parent,false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = ((ViewHolder)holder).getViewDataBinding();
        viewDataBinding.setVariable(com.nhutdu.foodylvn.BR.viewModel,mViewModel);
        viewDataBinding.setVariable(com.nhutdu.foodylvn.BR.category,mData.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return ( mData == null ? 0 : mData.size());
    }
}
