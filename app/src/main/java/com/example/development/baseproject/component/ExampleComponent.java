package com.example.development.baseproject.component;

import com.example.development.baseproject.activity.ExampleActivity;
import com.example.development.baseproject.activity.FlexibleSpaceToolbarImageScrollViewActivity;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Shekar on 7/1/15.
 */


/**
 * ExampleComponent is added as subcomponent to BaseComponent using plus method declared in BaseComponent,
 * subcomponent can't be annotated @Singleton
 */
@ActivityScope
@Subcomponent(
        modules = {
        ExampleModule.class
})
public interface ExampleComponent {
    /**
     * inject is used here to make ExampleActivity aware
     * of Injectable elements available in graph, This is called in ExampleActivity in onCreate
     */
    public void inject(ExampleActivity exampleActivity);
    public void inject(FlexibleSpaceToolbarImageScrollViewActivity flexibleSpaceToolbarImageScrollViewActivity);
}
