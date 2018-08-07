package com.reisal78.application.router;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.reisal78.application.event.NavigateCommand;
import com.reisal78.application.view.base.IContainer;
import com.reisal78.application.view.base.IView;
import javafx.scene.Parent;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Singleton
public class Router {

    private Map<Class<? extends IView>, Object> objectMap = new HashMap<>();
    private final EventBus eventBus;
    private final IContainer container;

    @Inject
    public Router(Set<IView> views, EventBus eventBus, IContainer container) {
        this.eventBus = eventBus;
        this.container = container;
        eventBus.register(this);
        views.forEach(view -> objectMap.put(view.getClass(), view));
    }


    @Subscribe
    @SuppressWarnings("unused")
    public void handleNavigateCommand(NavigateCommand command) {
        if (!objectMap.containsKey(command.getView())) {
            throw new RuntimeException("Unknown view " + command.getView());
        }
        IView view = (IView) objectMap.get(command.getView());
        view.beforeShow();
        container.setView(view.getRoot());
        view.afterShow();
    }


}
