package com.yige.translate.mvp.presenter;

import com.yige.translate.mvp.view.IBaseView;
import com.yige.translate.mvp.model.IBaseModel;

/**
 * Created by mxdl on 2017/11/27.
 */

public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> implements IBasePresenter {
    public M mModel;
    public V mView;
    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }
}
