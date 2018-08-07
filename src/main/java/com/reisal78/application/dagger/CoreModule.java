package com.reisal78.application.dagger;

import com.google.common.eventbus.EventBus;
import com.reisal78.application.view.base.IContainer;
import com.reisal78.application.view.base.IView;
import com.reisal78.application.view.main.IMainPresenter;
import com.reisal78.application.view.main.IMainView;
import com.reisal78.application.view.main.MainPresenter;
import com.reisal78.application.view.main.MainScreen;
import com.reisal78.application.view.root.IRootPresenter;
import com.reisal78.application.view.root.IRootView;
import com.reisal78.application.view.root.RootPresenter;
import com.reisal78.application.view.root.RootScreen;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;

@Module
@SuppressWarnings("unused")
abstract class CoreModule {

    @Singleton
    @Provides
    @Named(RootScreen.LAYOUT_ID_PROPERTY)
    static String bindRootScreenResource() {
        return "/fxml/root_screen.fxml";
    }

    @Singleton
    @Provides
    @Named(MainScreen.LAYOUT_ID_PROPERTY)
    static String bindMainScreenResource() {
        return "/fxml/main_screen.fxml";
    }

    @Binds
    @Singleton
    abstract IRootView bindRootView(RootScreen rootScreen);

    @Singleton
    @Binds
    abstract IMainView bindIMainView(MainScreen mainScreen);

    @Binds
    @Singleton
    abstract IRootPresenter bindRootPresenter(RootPresenter rootPresenter);

    @Binds
    @Singleton
    abstract IMainPresenter bindMainPresenter(MainPresenter mainPresenter);

    @Binds
    @Singleton
    abstract IContainer bindContainer(RootScreen rootScreen);

    @Provides
    @Singleton
    @IntoSet
    static IView provideRootScreen(@Named(RootScreen.LAYOUT_ID_PROPERTY) String url, IRootView rootView) {
        Parent loadScreen = (Parent) getLoadScreen(url, rootView);
        rootView.setRoot(loadScreen);
        return rootView;
    }

    @Provides
    @Singleton
    @IntoSet
    static IView provideMainScreen(@Named(MainScreen.LAYOUT_ID_PROPERTY)String url, IMainView mainView) {
        Object loadScreen = getLoadScreen(url, mainView);
        mainView.setRoot(loadScreen);
        return mainView;
    }

    @Provides
    @Singleton
    static EventBus bindEventBus() {
        return new EventBus();
    }

    private static <T> Object getLoadScreen(String url, T controller) {
        try {
            FXMLLoader loader = new FXMLLoader(CoreModule.class.getResource(url));
            loader.setController(controller);
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
