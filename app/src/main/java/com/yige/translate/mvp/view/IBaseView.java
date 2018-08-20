package com.yige.translate.mvp.view;

import android.content.Context;

/**
 * Created by gxl on 2017/11/27.
 */

public interface IBaseView {
    Context getContext();
    void showLoading();
    void hideLoading();
    void showToast(String value);
}
