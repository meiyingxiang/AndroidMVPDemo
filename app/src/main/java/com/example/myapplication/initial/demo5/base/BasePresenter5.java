package com.example.myapplication.initial.demo5.base;


public abstract class BasePresenter5<V extends BaseView5> {

    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

}
