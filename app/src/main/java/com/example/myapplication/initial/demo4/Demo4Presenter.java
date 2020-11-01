package com.example.myapplication.initial.demo4;

import com.example.myapplication.initial.Myinterface;
import com.example.myapplication.initial.demo4.base.BasePresenter4;
import com.example.myapplication.initial.demo4.base.BaseView;

/**
 * p层
 * 特点1：
 * 需要持有M层引用
 * 需要持有V层引用
 * 将M层和V层关联
 */
public class Demo4Presenter extends BasePresenter4<Demo4InterFace> {


    private Demo4Model demo4Model;

    public Demo4Presenter() {
        this.demo4Model = new Demo4Model();
    }


    public void getData(String url) {
        demo4Model.getData(url, new Myinterface() {
            @Override
            public void getData(String s) {
                if (getView() != null) {
                    getView().getData(s);
                }
            }
        });
    }

}
