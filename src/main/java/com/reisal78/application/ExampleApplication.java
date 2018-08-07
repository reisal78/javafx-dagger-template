package com.reisal78.application;

import com.reisal78.application.dagger.AppComponent;
import com.reisal78.application.dagger.DaggerAppComponent;
import com.reisal78.application.router.Router;
import com.reisal78.application.view.base.IView;
import com.reisal78.application.view.root.RootScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.util.Set;

public class ExampleApplication extends Application {


    @Inject
    public RootScreen rootScreen;
    @Inject
    public Set<IView> views;

    @Inject
    public Router router;

    public void start(Stage primaryStage) throws Exception {
        AppComponent component = DaggerAppComponent.builder().build();
        component.inject(this);
        views.forEach(IView::afterConstruct);
        Scene scene = new Scene(rootScreen.getRoot());
        rootScreen.beforeShow();
        primaryStage.setScene(scene);
        rootScreen.afterShow();
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
