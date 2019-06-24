package com.yige.translate.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.yige.translate.mvp.presenter.BasePresenter;
import com.yige.translate.mvp.view.IBaseView;

import javax.inject.Inject;

/**
 * Created by mxdl on 2017/11/27.
 */

public class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    @Inject
    protected P mPresenter;
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String value) {

    }
}
