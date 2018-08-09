package com.reisal78.application.view.root;

import com.reisal78.application.view.base.BaseView;
import com.reisal78.application.view.base.IContainer;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class RootScreen extends BaseView implements IRootView, IContainer {

    public final static String LAYOUT_ID_PROPERTY = "rootScreen";

    private final IRootPresenter presenter;


    @Inject
    public RootScreen(IRootPresenter presenter) {
        super(presenter);
        this.presenter = presenter;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    @Override
    public void setView(Parent parent) {
        BorderPane pane = getRoot();
        pane.setCenter(parent);
    }
}
