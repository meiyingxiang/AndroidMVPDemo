package com.example.myapplication.initial.demo4.base;

import com.example.myapplication.initial.demo4.Demo4InterFace;

public abstract class BasePresenter4<V extends BaseView> {

    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V demo4InterFace) {
        this.view = demo4InterFace;
    }

    public void detachView() {
        this.view = null;
    }

}
