package com.example.myapplication.initial.demo2;

import com.example.myapplication.initial.Myinterface;

/**
 * p层
 * 特点1：
 * 需要持有M层引用
 * 需要持有V层引用
 * 将M层和V层关联
 */
public class Demo2Presenter {
    private Demo2Model demo2Model;
    private Demo2InterFace demo2InterFace;

    public Demo2Presenter() {
        this.demo2Model = new Demo2Model();
    }

    public void attachView(Demo2InterFace demo2InterFace) {
        this.demo2InterFace = demo2InterFace;
    }

    public void detachView(){
        this.demo2InterFace = null;
    }

    public void getData(String url) {
        demo2Model.getData(url, new Myinterface() {
            @Override
            public void getData(String s) {
                demo2InterFace.getData(s);
            }
        });
    }

}
