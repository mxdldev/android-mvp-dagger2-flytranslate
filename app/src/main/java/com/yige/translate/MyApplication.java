package com.yige.translate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.yige.translate.injection.component.AppComponent;
import com.yige.translate.injection.component.DaggerAppComponent;
import com.yige.translate.injection.module.APIModule;
import com.yige.translate.injection.module.AppModule;

/**
 * Created by gxl on 2017/11/28.
 */

public class MyApplication extends Application {
  public static final String TAG = MyApplication.class.getSimpleName();
  private static AppComponent mAppComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
        .aPIModule(new APIModule()).build();
    this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
      @Override
      public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.v(TAG,"onActivityCreated start...");
      }

      @Override
      public void onActivityStarted(Activity activity) {
        Log.v(TAG,"onActivityStarted start...");
      }

      @Override
      public void onActivityResumed(Activity activity) {
        Log.v(TAG,"onActivityResumed start...");
      }

      @Override
      public void onActivityPaused(Activity activity) {
        Log.v(TAG,"onActivityPaused start...");
      }

      @Override
      public void onActivityStopped(Activity activity) {
        Log.v(TAG,"onActivityStopped start...");
      }

      @Override
      public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.v(TAG,"onActivitySaveInstanceState start...");
      }

      @Override
      public void onActivityDestroyed(Activity activity) {
        Log.v(TAG,"onActivityDestroyed start...");
      }
    });
  }

  public static AppComponent getAppComponent() {
    return mAppComponent;
  }
}
