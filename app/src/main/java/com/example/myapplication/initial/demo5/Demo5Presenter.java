package com.example.myapplication.initial.demo5;

import com.example.myapplication.initial.Myinterface;
import com.example.myapplication.initial.demo5.base.BasePresenter5;

/**
 * p层
 * 特点1：
 * 需要持有M层引用
 * 需要持有V层引用
 * 将M层和V层关联
 */
public class Demo5Presenter extends BasePresenter5<Demo5View> {


    private Demo5Model demo5Model;

    public Demo5Presenter() {
        this.demo5Model = new Demo5Model();
    }


    public void getData(String url) {
        demo5Model.getData(url, new Myinterface() {
            @Override
            public void getData(String s) {
                //在这里进行数据解析
                if (getView() != null) {
                    getView().getData(s);
                }
            }
        });
    }

}
