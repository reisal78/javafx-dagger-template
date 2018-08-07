package com.reisal78.application.view.base;

import javafx.scene.Parent;

public interface IView {
    <T extends Parent> T getRoot();

    <T> void setRoot(T root);

    void afterConstruct();

    void beforeShow();

    void afterShow();
}
