package com.yige.translate.injection.component;

import com.yige.translate.injection.ActivityScope;
import com.yige.translate.injection.module.MainModule;
import com.yige.translate.mvp.model.BaiduModel;
import com.yige.translate.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by gxl on 2017/11/28.
 */
@ActivityScope
@Component(modules = {MainModule.class} ,dependencies = {AppComponent.class})
public interface MainComponent {
    void inject(MainActivity activity);
    //BaiduModel getBaiduModel();
}
