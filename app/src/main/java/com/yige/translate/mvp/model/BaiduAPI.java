package com.yige.translate.mvp.model;

import com.yige.translate.mvp.model.bean.TransResult;

import java.util.Map;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by mxdl on 2017/11/26.
 */

public interface BaiduAPI {
  @GET("trans/vip/translate?")
  Observable<ResponseBody> translate(@Query("q") String q, @Query("from") String from,
                                     @Query("to") String to, @Query("appid") String appid, @Query("salt") String salt,
                                     @Query("sign") String sign);

  @GET("trans/vip/translate?")
  Observable<TransResult> translate(@QueryMap Map<String, String> map);
}
