package com.example.myapplication.mvc.model;

import android.text.TextUtils;

import com.example.myapplication.mvc.controller.MyCommentListener;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MyCommentModelImpl implements MyCommentModel{


    @Override
    public void getData(String url, MyCommentListener commentListener) {

        RequestParams requestParams = new RequestParams(url);

        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)){
                    commentListener.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                commentListener.onFail(ex.toString());
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
