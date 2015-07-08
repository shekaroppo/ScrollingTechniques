package com.example.development.baseproject.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.development.baseproject.BaseApplication;
import com.example.development.baseproject.R;
import com.example.development.baseproject.adapter.ExampleAdapter;
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

    @Bind(R.id.tabs)
    View mTabs;
    @Bind(R.id.topView)
    RecyclerView mTopView;
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
    private float mTabbarOffset=0;
    private float mTopViewTopPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_main);
        ButterKnife.bind(this);
        BaseApplication.getComponent(this).plus(new ExampleModule(this)).inject(this);
        setUI();
        loadData();
    }

    private void loadData() {
        mPresenter.loadData();
    }

    private void setUI() {

        mTopView.setHasFixedSize(true);
        mTopView.setLayoutManager(new LinearLayoutManager(this));
        mTopView.setAdapter(mAdapter);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(mTopViewTopPadding==0) {
                    mTopViewTopPadding = mTabs.getY();
                }
                mTabbarOffset+=dy;
                mTopView.setTranslationY(mTopView.getTranslationY()-dy);
                mTabs.setTranslationY(-clamp(mTabbarOffset,0,mTopViewTopPadding));
            }
        });
    }
    public static float clamp(float value, float min,float max) {
        return Math.min(Math.max(value, min), max);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribeFromDataStore();
    }

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
