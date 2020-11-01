package com.example.myapplication.initial.demo5;

import com.example.myapplication.initial.demo5.base.BaseView5;

/**
 * 例子1的View层，将数据回调给V,在P层的引用
 */
public interface Demo5View extends BaseView5 {
    void getData(String data);
}
