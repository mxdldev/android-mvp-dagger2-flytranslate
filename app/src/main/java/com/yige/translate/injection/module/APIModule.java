package com.yige.translate.injection.module;

import com.yige.translate.injection.ActivityScope;
import com.yige.translate.mvp.model.BaiduAPI;
import com.yige.translate.mvp.model.YoudaoAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mxdl on 2017/11/28.
 */
@Module
public class APIModule {
  @Singleton
  @Provides
  BaiduAPI providerBaiduAPI() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.fanyi.baidu.com/api/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build();
    return retrofit.create(BaiduAPI.class);
  }

  @Singleton
  @Provides
  YoudaoAPI providerYoudaoAPI() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://openapi.youdao.com/api/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build();
    return retrofit.create(YoudaoAPI.class);
  }
}
