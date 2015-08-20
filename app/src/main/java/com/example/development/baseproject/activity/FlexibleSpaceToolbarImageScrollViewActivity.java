package com.example.development.baseproject.activity;

import android.os.Bundle;

import com.example.development.baseproject.BaseApplication;
import com.example.development.baseproject.R;
import com.example.development.baseproject.model.ExampleModel;
import com.example.development.baseproject.module.ExampleModule;
import com.example.development.baseproject.view.LceView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Shekar on 8/5/15.
 */
public class FlexibleSpaceToolbarImageScrollViewActivity extends BaseActivity implements LceView<List<ExampleModel>> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexiable_img_with_toolbar);
        ButterKnife.bind(this);
        BaseApplication.getComponent(this).plus(new ExampleModule(this)).inject(this);
//        setUI();
//        loadData();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showContent(List<ExampleModel> data) {

    }

    @Override
    public void showError() {

    }
}
