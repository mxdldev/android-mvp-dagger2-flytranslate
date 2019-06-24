package com.yige.translate.injection.module;

import com.yige.translate.MyApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by mxdl on 2017/11/28.
 */

@Module
public class AppModule {
    private MyApplication mApplication;

    public AppModule(MyApplication application) {
        mApplication = application;
    }
    @Singleton
    @Provides
    MyApplication providerMyApplication(){
        return mApplication;
    }
}
