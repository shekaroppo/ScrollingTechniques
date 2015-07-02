package com.example.development.baseproject.component;

import com.example.development.baseproject.adapter.ExampleAdapter;
import com.example.development.baseproject.model.ExampleModel;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.presenter.ExamplePresenter;
import com.example.development.baseproject.view.LceView;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shekar on 7/1/15.
 */

@Singleton
@Component(modules = {
        ExampleModule.class
})
public interface ExampleComponent {
        ExampleAdapter provideCategoryAdapter();
        ExamplePresenter provideCategoryPresenter();
}
