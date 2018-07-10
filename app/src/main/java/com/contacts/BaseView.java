package com.contacts;

/**
 * Created by koti on 3/21/18.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showLoadingIndicator(boolean isActive);

    void showError(String error);
}
