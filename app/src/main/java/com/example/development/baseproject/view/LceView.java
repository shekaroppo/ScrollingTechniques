package com.example.development.baseproject.view;

/**
 * Created by Sekhar on 4/6/15.
 */
public interface LceView<M> {
    public void showProgress();

    public void hideProgress();

    public void showContent(M data);

    public void showError();

}
