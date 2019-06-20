package com.carl.applemusictimer;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.jiahuanyu.circletimerview.CircleTimerView;

public class MainActivity extends AppCompatActivity implements CircleTimerView.CircleTimerListener {
    private static final String TAG = MainActivity.class.getName();
    private CircleTimerView circleTimerView;
    private  AudioManager audio;
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
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public void onTimerStop() {
        startService(new Intent(MainActivity.this,MusicService.class));
        Toast.makeText(getApplicationContext(),"时间到",Toast.LENGTH_LONG).show();
        stopService(new Intent(MainActivity.this,MusicService.class));
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
        circleTimerView.startTimer();
    }

    @Override
    public void onTimerSetValueChange(int time) {

    }

}
