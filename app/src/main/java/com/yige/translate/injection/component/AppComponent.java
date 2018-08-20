package com.yige.translate.injection.component;

import com.yige.translate.MyApplication;
import com.yige.translate.injection.module.APIModule;
import com.yige.translate.injection.module.AppModule;
import com.yige.translate.mvp.model.BaiduAPI;
import com.yige.translate.mvp.model.YoudaoAPI;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gxl on 2017/11/28.
 */
@Singleton
@Component(modules = {AppModule.class, APIModule.class})
public interface AppComponent {
  MyApplication getMyApplication();
  BaiduAPI getBaiduAPI();
  YoudaoAPI getYouDaoAPI();
}
