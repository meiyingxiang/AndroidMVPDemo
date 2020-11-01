package com.example.myapplication.initial;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.initial.demo1.Demo1InterFace;
import com.example.myapplication.initial.demo1.Demo1Presenter;
import com.example.myapplication.initial.demo2.Demo2InterFace;
import com.example.myapplication.initial.demo2.Demo2Presenter;
import com.example.myapplication.initial.demo3.Demo3InterFace;
import com.example.myapplication.initial.demo3.Demo3Presenter;
import com.example.myapplication.initial.demo4.Demo4InterFace;
import com.example.myapplication.initial.demo4.Demo4Presenter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 初始的开发方式
 */
public class InitialActivity extends AppCompatActivity {
    private String url = "https://api.apiopen.top/getJoke?page=1&count=2&type=video";
    private Button textView;
    private Demo2Presenter demo2Presenter;
    private Demo3Presenter demo3Presenter;
    private Demo4Presenter demo4Presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getUrlDataInitial();

//                getDataDemo1();
//                getDataDemo2();
//                getDataDemo3();
                getDataDemo4();
            }
        });
    }

    private void getDataDemo4() {
        demo4Presenter = new Demo4Presenter();
        demo4Presenter.attachView(new Demo4InterFace() {
            @Override
            public void getData(String data) {
                Log.e("Frank", "getDataDemo4 getData: " + data);
            }
        });
        demo4Presenter.getData(url);
    }

    private void getDataDemo3() {
        demo3Presenter = new Demo3Presenter();
        demo3Presenter.attachView(new Demo3InterFace() {
            @Override
            public void getData(String data) {
                Log.e("Frank", "getDataDemo3 getData: " + data);
            }
        });
        demo3Presenter.getData(url);
    }


    private void getDataDemo2() {
        demo2Presenter = new Demo2Presenter();
        demo2Presenter.attachView(new Demo2InterFace() {
            @Override
            public void getData(String data) {
                Log.e("Frank", "getDataDemo2 getData: " + data);
            }
        });
        demo2Presenter.getData(url);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (demo2Presenter != null) {
            demo2Presenter.detachView();
        }
        if (demo3Presenter != null) {
            demo3Presenter.detachView();
        }
        if (demo4Presenter != null) {
            demo4Presenter.detachView();
        }
    }

    private void getDataDemo1() {
        Demo1Presenter demo1Presenter = new Demo1Presenter(new Demo1InterFace() {
            @Override
            public void getData(String data) {
                Log.e("Frank", "getDataDemo1 getData: " + data);
            }
        });
        demo1Presenter.getData(url);

    }

    /**
     * 原始的开发方式
     */
    private void getUrlDataInitial() {
        RequestParams requestParams = new RequestParams(url);

        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    textView.setText(result);
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
