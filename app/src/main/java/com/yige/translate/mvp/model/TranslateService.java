package com.yige.translate.mvp.model;

import javax.inject.Inject;

/**
 * Created by gxl on 2017/11/28.
 */

public class TranslateService implements ITranslateService {
    private BaiduModel mBaiduModel;
    private YoudaoModel mYoudaoModel;

    @Inject
    public TranslateService(BaiduModel baiduModel, YoudaoModel youdaoModel) {
        mBaiduModel = baiduModel;
        mYoudaoModel = youdaoModel;
    }

    @Override
    public IBaiduModel getBaiduModel() {
        return mBaiduModel;
    }

    @Override
    public IYoudaoModel getYouDaoModel() {
        return mYoudaoModel;
    }
}
