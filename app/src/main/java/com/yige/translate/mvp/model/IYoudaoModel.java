package com.yige.translate.mvp.model;

import com.yige.translate.mvp.model.bean.TransResult;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by mxdl on 2017/11/26.
 */

public interface IYoudaoModel extends IBaseModel{
    /**
     *
     * @param query,
     * @param from
     * @param to
     * @return
     */
    Observable<ResponseBody> translate1(String query, String from, String to);
}
