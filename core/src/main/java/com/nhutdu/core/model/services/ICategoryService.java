package com.nhutdu.core.model.services;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.view.ICallback;

import java.util.List;

/**
 * Created by NhutDu on 17/08/2016.
 */
public interface ICategoryService {

    void getAllCategories(ICallback<List<Category>> callback);

    void saveCategory(Category category,ICallback<Boolean> callback);

    void saveCategories(List<Category> categories,ICallback<Boolean> callback);
}
