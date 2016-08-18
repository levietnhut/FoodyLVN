package com.nhutdu.foodylvn;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nhutdu.core.view.BaseRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.List;

/**
 * Created by Administrator on 7/30/2016.
 */
public class AppBindingAdapter {

    //region Binding Adapters

    @BindingAdapter(value = {"items"})
    public static <T> void setAdapter(RecyclerView recyclerView, List<T> items) {
        if (recyclerView.getAdapter() instanceof BaseRecyclerViewAdapter) {
            BaseRecyclerViewAdapter adapter = (BaseRecyclerViewAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.setData(items);
            }
        }
    }

//
//    @BindingAdapter(value = {"itemSpinner"})
//    public static <T> void setAdapter(MaterialBetterSpinner spinner,List<T> items){
//        ArrayAdapter<T> adapter = new ArrayAdapter<T>(items);
//        spinner.setAdapter(adapter);
//    }

    @BindingAdapter(value = {"imageUrl", "placeHolder"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext())
                .load(url)
                .error(error)
                .into(view);
    }

    @BindingAdapter(value = {"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .into(view);
    }

    //endregion
}
