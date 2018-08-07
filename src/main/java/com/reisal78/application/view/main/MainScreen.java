package com.reisal78.application.view.main;

import com.reisal78.application.view.base.BaseView;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainScreen extends BaseView implements IMainView {
    public final static String LAYOUT_ID_PROPERTY = "mainScreen";

    private final IMainPresenter presenter;

    @Inject
    public MainScreen(IMainPresenter presenter) {
        super(presenter);
        this.presenter = presenter;
    }
}
