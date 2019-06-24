package com.yige.translate.mvp.presenter;

import com.yige.translate.mvp.view.IBaseView;
/**
 * Created by mxdl on 2017/11/26.
 */

public class BaiduContract {
    public interface View extends IBaseView {
        void setTranslateResult(String result);
    }
    public interface Presenter extends IBasePresenter{
        void translate(String query, String from, String to);
        void translate1(String query, String from, String to);
    }
}
