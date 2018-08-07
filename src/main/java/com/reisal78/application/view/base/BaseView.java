package com.reisal78.application.view.base;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class BaseView implements IView, Initializable {

    @FXML
    protected Parent rootView;

    private final IPresenter presenter;

    protected BaseView(IPresenter presenter) {
        this.presenter = presenter;
        this.presenter.setView(this);
    }

    public <T extends Parent> T getRoot() {
        return (T) rootView;
    }

    public <T> void setRoot(T root) {
        this.rootView = (Parent) root;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void beforeShow() {
        presenter.onStart();
    }

    @Override
    public void afterShow() {

    }

    @Override
    public void afterConstruct() {

    }
}
