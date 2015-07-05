package com.example.development.baseproject.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.development.baseproject.BaseApplication;
import com.example.development.baseproject.R;
import com.example.development.baseproject.adapter.ExampleAdapter;
import com.example.development.baseproject.component.DaggerBaseComponent;
import com.example.development.baseproject.component.DaggerExampleComponent;
import com.example.development.baseproject.component.ExampleComponent;
import com.example.development.baseproject.model.ExampleModel;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.presenter.ExamplePresenter;
import com.example.development.baseproject.view.LceView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Sekhar on 4/6/15.
 */
public class ExampleActivity extends BaseActivity implements LceView<List<ExampleModel>> {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.loadingView)
    ProgressBar mLoadingView;
    @Bind(R.id.errorView)
    TextView mErrorView;
    @Inject
    ExamplePresenter mPresenter;
    @Inject
    ExampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_main);
        ButterKnife.bind(this);
        //  BaseApplication.getComponent(this)
        //ExampleComponent component=DaggerExampleComponent.builder().exampleModule(new ExampleModule(this)).build();
        // component.inject(this);
        setUI();
        loadData();
    }

    private void loadData() {
        mPresenter.loadData();
    }

    private void setUI() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribeFromDataStore();
    }

//    @Override
//    protected List<Object> getModules() {
//        return Arrays.<Object>asList(new ExampleModule(this));
//    }

    @Override
    public void showProgress() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showContent(List<ExampleModel> data) {
        mAdapter.setData(data);
    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
    }
}
