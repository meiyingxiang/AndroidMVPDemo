package com.example.myapplication.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.mvc.controller.MyCommentListener;
import com.example.myapplication.mvc.model.MyCommentModelImpl;

public class MainActivity extends AppCompatActivity

//        implements MyCommentListener
{

//    private MyCommentModelImpl commentModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        commentModel = new MyCommentModelImpl();
//        commentModel.getData("https://api.apiopen.top/getJoke?page=1&count=2&type=video", this);
    }

//    @Override
//    public void onSuccess(String s) {
//        Log.e("Frank", "onSuccess: " + s);
//    }
//
//    @Override
//    public void onFail(String s) {
//        Log.e("Frank", "onFail: " + s);
//    }
}