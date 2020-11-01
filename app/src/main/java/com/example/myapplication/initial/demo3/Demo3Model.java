package com.example.myapplication.initial.demo3;

import android.text.TextUtils;
import android.util.Log;

import com.example.myapplication.initial.Myinterface;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * M层需要做网络请求，数据操作
 */
public class Demo3Model {

    public void getData(String url, Myinterface myinterface){
        RequestParams requestParams = new RequestParams(url);

        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    //数据回调
                    myinterface.getData(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("Frank", "onError: " + ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

}
