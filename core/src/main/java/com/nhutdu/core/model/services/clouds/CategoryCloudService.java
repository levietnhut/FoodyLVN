package com.nhutdu.core.model.services.clouds;

import com.nhutdu.core.model.entities.Category;
import com.nhutdu.core.model.services.ICategoryService;
import com.nhutdu.core.view.ICallback;

import java.util.List;

/**
 * Created by NhutDu on 17/08/2016.
 */
public class CategoryCloudService extends BaseCloudService<ICategoryCloudService> implements ICategoryService {

    //region Properties

    ICategoryCloudService iICategoryCloudService;

    //endregion

    //region Constructor

    public CategoryCloudService(ICategoryCloudService iCategoryCloudService){
        this.iICategoryCloudService = iCategoryCloudService;
    }

    //endregion

    @Override
    public void getAllCategories(ICallback<List<Category>> callback) {

    }
}
