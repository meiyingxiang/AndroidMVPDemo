package com.example.myapplication.initial.demo6.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.initial.demo5.base.BasePresenter5;
import com.example.myapplication.initial.demo5.base.BaseView5;

/**
 * 抽象出解绑和绑定
 * 为了能够兼容多个模块，兼容多个Activity，所以采用范型设计
 */
public abstract class BaseFragment<V extends BaseView5, P extends BasePresenter5<V>> extends Fragment {

    private P presenter;
    private V view;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }

    public abstract P createPresenter();

    public abstract V createView();
}
