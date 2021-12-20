package com.playground.dagger;

import com.playground.Outputter;
import dagger.Module;
import dagger.Provides;

@Module
public interface OutputterModule {

    @Provides
    static Outputter textOutputter() {
        return System.out::println;
    }
}
