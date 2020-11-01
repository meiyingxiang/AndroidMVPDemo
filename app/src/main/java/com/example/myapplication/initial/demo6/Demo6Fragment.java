package com.example.myapplication.initial.demo6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.initial.demo5.Demo5Presenter;
import com.example.myapplication.initial.demo5.Demo5View;
import com.example.myapplication.initial.demo6.base.BaseFragment;

public class Demo6Fragment extends BaseFragment<Demo5View, Demo5Presenter> implements Demo5View {

    private Button btn_down;

    private String url = "https://api.apiopen.top/getJoke?page=1&count=2&type=video";

    @Override
    public Demo5Presenter createPresenter() {
        return new Demo5Presenter();
    }

    @Override
    public Demo5View createView() {
        return this::getData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo6_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_down = view.findViewById(R.id.btn_down);

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPresenter() != null) {
                    getPresenter().getData(url);
                }
            }
        });
    }

    @Override
    public void getData(String data) {
        Log.e("Frank", "Demo6Fragment getData: " + data);
    }
}
