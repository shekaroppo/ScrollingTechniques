package com.example.development.baseproject.presenter;


import android.util.Log;

import com.example.development.baseproject.datamanager.CategoryDataManager;
import com.example.development.baseproject.model.ExampleModel;
import com.example.development.baseproject.view.LceView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Sekhar on 4/6/15.
 */
public class ExamplePresenterImpl implements ExamplePresenter {

    private LceView mLceView;
    private CategoryDataManager mDataManager;
    private CompositeSubscription compositeSubscription;

    public ExamplePresenterImpl(LceView mLceView) {
        this.mLceView = mLceView;
        mDataManager = new CategoryDataManager();
    }


    @Override
    public void loadData() {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        mLceView.showProgress();
        compositeSubscription.add(CategoryDataManager.getCategorys().observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<ExampleModel>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mLceView.hideProgress();
                mLceView.showError();
            }

            @Override
            public void onNext(List<ExampleModel> categoryModels) {
                mLceView.hideProgress();
                mLceView.showContent(categoryModels);
            }
        }));

    }

    @Override
    public void unsubscribeFromDataStore() {
        Log.d("TAG", "unsubscribeFromDataStore ");
        compositeSubscription.clear();
        compositeSubscription = null;
    }
}
