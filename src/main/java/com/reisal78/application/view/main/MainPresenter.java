package com.reisal78.application.view.main;

import com.reisal78.application.view.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    @Inject
    public MainPresenter() {
        System.out.println("MainPresenter.MainPresenter");
    }

    @Override
    public void onStart() {

    }
}
