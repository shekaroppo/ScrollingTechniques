package com.example.development.baseproject.module;

import android.app.Application;

import com.example.development.baseproject.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shekar on 7/3/15.
 */

@Module
public class BaseModule {
    BaseApplication application;

    public BaseModule(BaseApplication app) {
        application = app;
    }

    @Provides
    BaseApplication provideBaseApplication() {
        return application;
    }
}
