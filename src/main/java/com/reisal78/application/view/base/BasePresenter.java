package com.reisal78.application.view.base;

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }
}
