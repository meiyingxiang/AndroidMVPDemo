package com.example.myapplication.initial.demo4;

import com.example.myapplication.initial.demo4.base.BaseView;

/**
 * 例子1的View层，将数据回调给V,在P层的引用
 */
public interface Demo4InterFace extends BaseView {
    void getData(String data);
}
