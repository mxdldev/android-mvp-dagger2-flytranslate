/**
 * Copyright 2017 JessYan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.yige.translate.injection.module;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.yige.translate.injection.ActivityScope;
import com.yige.translate.mvp.model.BaiduAPI;
import com.yige.translate.mvp.model.BaiduModel;
import com.yige.translate.mvp.model.IBaiduModel;
import com.yige.translate.mvp.model.ITranslateService;
import com.yige.translate.mvp.model.IYoudaoModel;
import com.yige.translate.mvp.model.TranslateService;
import com.yige.translate.mvp.model.YoudaoAPI;
import com.yige.translate.mvp.model.YoudaoModel;
import com.yige.translate.mvp.presenter.BaiduContract;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class MainModule {
  public static final String TAG = MainModule.class.getSimpleName();
  private BaiduContract.View view;

  public MainModule(BaiduContract.View view) {
    this.view = view;
  }

  @ActivityScope
  @Provides
  BaiduContract.View provideBaiduView() {
    return this.view;
  }

  @ActivityScope
  @Provides
  IBaiduModel provideBaiduModel(BaiduModel model) {
    return model;
  }

  @ActivityScope
  @Provides
  IYoudaoModel provideYoudaoModel(YoudaoModel model) {
    return model;
  }

  @ActivityScope
  @Provides
  ITranslateService providerTranslateService(TranslateService translateService){
    return translateService;
  }

//  @ActivityScope
//  @Provides
//  BaiduAPI providerBaiduAPI() {
//    Log.v(TAG,"providerBaiduAPI start...");
//    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.fanyi.baidu.com/api/")
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .addConverterFactory(GsonConverterFactory.create()).build();
//    return retrofit.create(BaiduAPI.class);
//  }
//  @ActivityScope
//  @Provides
//  YoudaoAPI providerYoudaoAPI() {
//    Log.v(TAG,"providerYoudaoAPI start...");
//    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://openapi.youdao.com/api/")
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create()).build();
//    return retrofit.create(YoudaoAPI.class);
//  }
//  @ActivityScope
//  @Provides
//  BaiduModel providerBaiduModel(){
//    return new BaiduModel(providerBaiduAPI());
//  }
}
