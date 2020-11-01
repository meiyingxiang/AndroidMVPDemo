package com.example.myapplication.initial.demo3;

import com.example.myapplication.initial.Myinterface;
import com.example.myapplication.initial.demo2.Demo2InterFace;
import com.example.myapplication.initial.demo2.Demo2Model;
import com.example.myapplication.initial.demo3.base.BasePresenter3;

/**
 * p层
 * 特点1：
 * 需要持有M层引用
 * 需要持有V层引用
 * 将M层和V层关联
 */
public class Demo3Presenter extends BasePresenter3 {


    private Demo3Model demo3Model;

    public Demo3Presenter() {
        this.demo3Model = new Demo3Model();
    }


    public void getData(String url) {
        demo3Model.getData(url, new Myinterface() {
            @Override
            public void getData(String s) {
                if (getDemo3InterFace() != null) {
                    getDemo3InterFace().getData(s);
                }
            }
        });
    }

}
