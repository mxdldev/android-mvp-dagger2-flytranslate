package com.yige.translate.mvp.model;

import com.yige.translate.mvp.model.bean.TransResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by gxl on 2017/11/28.
 */

public interface YoudaoAPI {
    @GET("?")
    Observable<ResponseBody> translate(@QueryMap Map<String, String> map);
}
