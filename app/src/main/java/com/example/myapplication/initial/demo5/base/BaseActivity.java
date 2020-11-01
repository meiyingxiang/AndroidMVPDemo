package com.example.myapplication.initial.demo5.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 抽象出解绑和绑定
 * 为了能够兼容多个模块，兼容多个Activity，所以采用范型设计
 */
public abstract class BaseActivity<V extends BaseView5, P extends BasePresenter5<V>> extends AppCompatActivity {

    private P presenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (view == null) {
            this.view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }

    public abstract P createPresenter();

    public abstract V createView();
}
