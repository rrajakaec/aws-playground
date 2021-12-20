package com.playground.dagger;

import com.playground.Command;
import com.playground.HelloWorldCommand;
import dagger.Binds;
import dagger.Module;

@Module
public interface HelloWorldModule {

    @Binds
    Command helloWorld(HelloWorldCommand helloWorldCommand);
}
