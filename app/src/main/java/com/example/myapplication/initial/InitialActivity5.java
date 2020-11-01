package com.example.myapplication.initial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.initial.demo5.Demo5View;
import com.example.myapplication.initial.demo5.Demo5Presenter;
import com.example.myapplication.initial.demo5.base.BaseActivity;


/**
 * 初始的开发方式
 */
public class InitialActivity5 extends BaseActivity<Demo5View, Demo5Presenter> implements Demo5View {
    private String url = "https://api.apiopen.top/getJoke?page=1&count=2&type=video";
    private Button textView;
//    private Demo5Presenter demo5Presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataDemo5();
            }
        });
    }

    private void getDataDemo5() {
//        demo5Presenter.getData(url);
        getPresenter().getData(url);
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        if (demo5Presenter != null) {
////            demo5Presenter.detachView();
////        }
//      这里也不需要了，已经在BaseActivity里面操作过了
//        if (getPresenter() != null) {
//            getPresenter().detachView();
//        }
//    }

    @Override
    public Demo5Presenter createPresenter() {
//        demo5Presenter = new Demo5Presenter();
//        return demo5Presenter;
        return new Demo5Presenter();
    }

    @Override
    public Demo5View createView() {
        return this;
    }

    @Override
    public void getData(String data) {
        Log.e("Frank", "getData: " + data);
    }
}
