package com.reisal78.application.dagger;


import com.reisal78.application.ExampleApplication;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {CoreModule.class})
@Singleton
public interface AppComponent {
    void inject(ExampleApplication application);
}
