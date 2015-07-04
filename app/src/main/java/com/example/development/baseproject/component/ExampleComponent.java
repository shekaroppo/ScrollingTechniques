package com.example.development.baseproject.component;

import com.example.development.baseproject.activity.ExampleActivity;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shekar on 7/1/15.
 */

@Singleton
@Component(modules = {
        NetworkModule.class,
        ExampleModule.class
})
public interface ExampleComponent {
        public void inject(ExampleActivity exampleActivity);
}
