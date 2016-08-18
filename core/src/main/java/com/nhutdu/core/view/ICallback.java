package com.nhutdu.core.view;

/**
 * Created by TVG on 7/19/16.
 */
public interface ICallback<T> {

    void onResult(T result);

    void onFailure(Throwable t);

}
