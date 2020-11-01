package com.example.myapplication.mvc.model;

import com.example.myapplication.mvc.controller.MyCommentListener;

public interface MyCommentModel {

    void getData(String url, MyCommentListener commentListener);
}
