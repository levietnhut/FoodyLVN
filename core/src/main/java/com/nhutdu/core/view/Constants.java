package com.nhutdu.core.view;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by TVG on 7/18/16.
 */
public class Constants {

    //region Constructors

    private Constants() {

    }

    //endregion

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            ROOT, MAIN_PAGE, LOGIN_PAGE,REGISTER_PAGE,CONTACT_PAGE,ABOUT_PAGE,CREATE_RESTAURANT_PAGE,LIST_RESTAURANT_PAGE,RESTAURANT_DETAIL_PAGE,COMMENT_PAGE
    })
    public @interface PageKey {}

    public static final int ROOT = -1;
    public static final int MAIN_PAGE = 0;
    public static final int LOGIN_PAGE = 1;
    public static final int REGISTER_PAGE = 2;
    public static final int CONTACT_PAGE = 3;
    public static final int ABOUT_PAGE = 4;
    public static final int CREATE_RESTAURANT_PAGE = 5;
    public static final int LIST_RESTAURANT_PAGE = 6;
    public static final int RESTAURANT_DETAIL_PAGE = 7;
    public static final int COMMENT_PAGE = 7;

}
