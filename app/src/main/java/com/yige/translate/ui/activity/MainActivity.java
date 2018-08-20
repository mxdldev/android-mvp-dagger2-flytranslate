package com.yige.translate.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yige.translate.MyApplication;
import com.yige.translate.R;

import com.yige.translate.injection.component.DaggerAppComponent;
import com.yige.translate.injection.component.DaggerMainComponent;
import com.yige.translate.injection.module.MainModule;
import com.yige.translate.mvp.model.BaiduModel;
import com.yige.translate.mvp.presenter.BaiduPresenter;
import com.yige.translate.mvp.presenter.BaiduContract;

public class MainActivity extends BaseActivity<BaiduPresenter> implements BaiduContract.View {
  public static final String TAG = MainActivity.class.getSimpleName();
  private EditText mEditText;
  private Button mBtnTranslateBaidu;
  private Button mBtnTranslateYoudao;
  private TextView mTxtResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mEditText = findViewById(R.id.txt_query);
    mBtnTranslateBaidu = findViewById(R.id.btn_translate_baidu);
    mBtnTranslateYoudao = findViewById(R.id.btn_translate_youdao);
    mTxtResult = findViewById(R.id.txt_result);
    mBtnTranslateBaidu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mPresenter.translate(mEditText.getText().toString(), "en", "zh");
      }
    });
    mBtnTranslateYoudao.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mPresenter.translate1(mEditText.getText().toString(), "en", "zh");
      }
    });
    DaggerMainComponent.builder().appComponent(MyApplication.getAppComponent())
        .mainModule(new MainModule(this)).build().inject(this);
//     BaiduModel baiduModel = DaggerMainComponent.builder().mainModule(new
//     MainModule(this)).build().getBaiduModel();
//     if(baiduModel == null){
//     Log.v(TAG,"baidumodel is null");
//     }else{
//     Log.v(TAG,"baidumodel is not null");
//     }

  }

  @Override
  public void setTranslateResult(String result) {
    mTxtResult.setText(result);
  }
}
