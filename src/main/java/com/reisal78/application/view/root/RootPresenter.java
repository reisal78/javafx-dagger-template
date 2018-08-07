package com.reisal78.application.view.root;

import com.google.common.eventbus.EventBus;
import com.reisal78.application.event.NavigateCommand;
import com.reisal78.application.view.base.BasePresenter;
import com.reisal78.application.view.main.MainScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootPresenter extends BasePresenter<IRootView> implements IRootPresenter {

    private final EventBus eventBus;

    @Inject
    public RootPresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onStart() {
        eventBus.post(new NavigateCommand(MainScreen.class));
    }
}
