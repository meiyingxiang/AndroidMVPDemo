package com.example.myapplication.initial.demo1;

import com.example.myapplication.initial.Myinterface;

/**
 * p层
 * 特点1：
 * 需要持有M层引用
 * 需要持有V层引用
 * 将M层和V层关联
 */
public class Demo1Presenter {
    private Demo1Model demo1Model;
    private Demo1InterFace demo1InterFace;

    public Demo1Presenter(Demo1InterFace demo1InterFace){
        this.demo1Model = new Demo1Model();
        this.demo1InterFace = demo1InterFace;
    }

    public void getData(String url){
        demo1Model.getData(url, new Myinterface() {
            @Override
            public void getData(String s) {
                demo1InterFace.getData(s);
            }
        });
    }

}
