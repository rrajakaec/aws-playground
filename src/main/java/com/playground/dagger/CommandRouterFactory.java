package com.playground.dagger;

import com.playground.CommandRouter;
import com.playground.HelloWorldCommand;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {HelloWorldModule.class, OutputterModule.class})
@Singleton
public interface CommandRouterFactory {
    CommandRouter router();
}
