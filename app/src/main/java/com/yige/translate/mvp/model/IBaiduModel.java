package com.yige.translate.mvp.model;

import com.yige.translate.mvp.model.bean.TransResult;

import io.reactivex.Observable;

/**
 * Created by gxl on 2017/11/26.
 */

public interface IBaiduModel extends IBaseModel{
    /**
     *
     * @param query,
     * @param from
     * @param to
     * @return
     */
    Observable<TransResult> translate1(String query, String from, String to);
}
