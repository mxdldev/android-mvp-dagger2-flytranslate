package com.yige.translate.mvp.model;


import com.yige.translate.injection.ActivityScope;
import com.yige.translate.mvp.model.baidu.MD5;
import com.yige.translate.mvp.model.bean.TransResult;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gxl on 2017/11/26.
 */

public class BaiduModel implements IBaiduModel {
  public static final String appid = "20171126000099472";
  public static final String securityKey = "adIVJdw755SB83oq0Is0";
  private final BaiduAPI mBaiduService;

  @Inject
  public BaiduModel(BaiduAPI baiduAPI) {
    mBaiduService = baiduAPI;
  }

  @Override
  public Observable<TransResult> translate1(String query, String from, String to) {
    return mBaiduService.translate(buildParams(query, from, to));
  }

  public Map<String, String> buildParams(String query, String from, String to) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("q", query);
    params.put("from", from);
    params.put("to", to);

    params.put("appid", appid);

    // 随机数
    String salt = String.valueOf(System.currentTimeMillis());
    params.put("salt", salt);

    // 签名
    String src = appid + query + salt + securityKey; // 加密前的原文
    params.put("sign", MD5.md5(src));

    return params;
  }
}
