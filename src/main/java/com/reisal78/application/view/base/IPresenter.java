package com.reisal78.application.view.base;

public interface IPresenter <T extends IView> {
    void setView(T view);

    void onStart();
}
