package com.example.myapplication.initial.demo3.base;

import com.example.myapplication.initial.demo3.Demo3InterFace;
import com.example.myapplication.initial.demo3.Demo3Model;

public abstract class BasePresenter3 {
    private Demo3InterFace demo3InterFace;

    public Demo3InterFace getDemo3InterFace() {
        return demo3InterFace;
    }

    public void attachView(Demo3InterFace demo3InterFace) {
        this.demo3InterFace = demo3InterFace;
    }

    public void detachView() {
        this.demo3InterFace = null;
    }

}
