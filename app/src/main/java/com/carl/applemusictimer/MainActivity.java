package com.carl.applemusictimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.jiahuanyu.circletimerview.CircleTimerView;

public class MainActivity extends AppCompatActivity implements CircleTimerView.CircleTimerListener {
    private CircleTimerView circleTimerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        circleTimerView = findViewById(R.id.ctv);
        circleTimerView.setCircleTimerListener(this);
        circleTimerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public void onTimerStop() {

    }

    @Override
    public void onTimerStart(int time) {

    }

    @Override
    public void onTimerPause(int time) {

    }

    @Override
    public void onTimerTimingValueChanged(int time) {

    }

    @Override
    public void onTimerSetValueChanged(int time) {

    }

    @Override
    public void onTimerSetValueChange(int time) {

    }
}
