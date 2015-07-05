package com.example.development.baseproject.module;
import com.example.development.baseproject.adapter.ExampleAdapter;
import com.example.development.baseproject.model.ExampleModel;
import com.example.development.baseproject.presenter.ExamplePresenter;
import com.example.development.baseproject.presenter.ExamplePresenterImpl;
import com.example.development.baseproject.scope.ActivityScope;
import com.example.development.baseproject.view.LceView;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

/**
 * Created by Sekhar on 4/8/15.
 */
@Module
public class ExampleModule {

    private LceView<List<ExampleModel>> view;

    public ExampleModule(LceView<List<ExampleModel>> view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public LceView<List<ExampleModel>> provideLceView() {
        return view;
    }

    @Provides
    @ActivityScope
    public ExampleAdapter provideCategoryAdapter() {
        return new ExampleAdapter();
    }

    @Provides
    @ActivityScope
    public ExamplePresenter provideCategoryPresenter(LceView<List<ExampleModel>> view, Observable<List<ExampleModel>> categoryObservable) {
        return new ExamplePresenterImpl(view, categoryObservable);
    }
}
