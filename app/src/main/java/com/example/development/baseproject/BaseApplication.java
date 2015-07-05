package com.example.development.baseproject;

import android.app.Application;
import android.content.Context;

import com.example.development.baseproject.component.BaseComponent;
import com.example.development.baseproject.component.DaggerBaseComponent;
import com.example.development.baseproject.component.ExampleComponent;
import com.example.development.baseproject.module.BaseModule;

public class BaseApplication extends Application {

    private BaseComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerBaseComponent.builder().baseModule(new BaseModule(this)).build();
    }

//    public ExampleComponent createExampleComponent(User user) {
//        userComponent = appComponent.plus(new UserModule(user));
//        return userComponent;
//    }

    public static BaseComponent getComponent(Context context) {
        return ((BaseApplication) context.getApplicationContext()).component;
    }
}

