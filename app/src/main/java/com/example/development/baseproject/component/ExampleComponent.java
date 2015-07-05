package com.example.development.baseproject.component;

import com.example.development.baseproject.activity.ExampleActivity;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Shekar on 7/1/15.
 */

@ActivityScope
@Subcomponent(
        modules = {
        ExampleModule.class
})
public interface ExampleComponent {
        public void inject(ExampleActivity exampleActivity);
}
