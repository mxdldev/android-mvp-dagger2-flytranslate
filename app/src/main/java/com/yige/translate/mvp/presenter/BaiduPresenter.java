package com.yige.translate.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.yige.translate.mvp.model.IBaiduModel;
import com.yige.translate.mvp.model.ITranslateService;
import com.yige.translate.mvp.model.IYoudaoModel;
import com.yige.translate.mvp.model.TranslateService;
import com.yige.translate.mvp.model.bean.TransItem;
import com.yige.translate.mvp.model.bean.TransResult;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by mxdl on 2017/11/26.
 */

public class BaiduPresenter extends BasePresenter<IBaiduModel, BaiduContract.View>
    implements
      BaiduContract.Presenter {
  public static final String TAG = BaiduPresenter.class.getSimpleName();
  private ITranslateService mService;

  @Inject
  public BaiduPresenter(ITranslateService service, BaiduContract.View view) {
    super(null, view);
    this.mService = service;
    // Log.v(TAG,model == null ? "model is null":"model is not null");
    // Log.v(TAG,view == null ? "view is null":"view is not null");
  }

  @Override
  public void translate(final String query, final String from, final String to) {
    if (TextUtils.isEmpty(query)) {
      Toast.makeText(mView.getContext(), "请输入查询的内容", Toast.LENGTH_LONG).show();
      return;
    }
    Observable<TransResult> observable = mService.getBaiduModel().translate1(query, from, to);
    observable.doOnSubscribe(new Consumer<Disposable>() {
      @Override
      public void accept(Disposable disposable) throws Exception {

      }
    }).doFinally(new Action() {
      @Override
      public void run() throws Exception {

      }
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<TransResult>() {
          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(TransResult transResult) {
            Log.v(TAG, "onNext start...");
            Log.v(TAG, "from:" + transResult.getFrom());
            Log.v(TAG, "to:" + transResult.getFrom());
            StringBuilder stringBuilder = new StringBuilder();
            for (TransItem transItem : transResult.getTrans_result()) {
              stringBuilder
                  .append("src:" + transItem.getSrc() + "; dst:" + transItem.getDst() + "\n");
              Log.v(TAG, "src:" + transItem.getSrc() + "; dst:" + transItem.getDst());
            }
            mView.setTranslateResult(stringBuilder.toString());
          }

          @Override
          public void onError(Throwable e) {
            Log.v(TAG, "onError start...");
            Log.v(TAG, e.toString());
          }

          @Override
          public void onComplete() {
            Log.v(TAG, "onComplete start...");
          }
        });

  }

  @Override
  public void translate1(String query, String from, String to) {
    if (TextUtils.isEmpty(query)) {
      Toast.makeText(mView.getContext(), "请输入查询的内容", Toast.LENGTH_LONG).show();
      return;
    }
    Observable<ResponseBody> observable = mService.getYouDaoModel().translate1(query, from, to);
    observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ResponseBody>() {
          @Override
          public void onSubscribe(Disposable d) {}

          @Override
          public void onNext(ResponseBody transResult) {
            Log.v(TAG, "onNext start...");

            mView.setTranslateResult(transResult.source().toString());
          }

          @Override
          public void onError(Throwable e) {
            Log.v(TAG, "onError start...");
            Log.v(TAG, e.toString());
          }

          @Override
          public void onComplete() {
            Log.v(TAG, "onComplete start...");
          }
        });
  }

  @Override
  public void start() {

  }

  @Override
  public void destroy() {

  }

}
