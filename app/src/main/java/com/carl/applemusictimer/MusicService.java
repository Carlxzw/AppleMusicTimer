package com.carl.applemusictimer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * @author 创建人 ：xiezhiwei
 * @version 1.0
 * @package 包名 ：com.carl.applemusictimer
 * @createTime 创建时间 ：2019-06-17
 * @modifyBy 修改人 ：xiezhiwei
 * @modifyTime 修改时间 ：2019-06-17
 * @modifyMemo 修改备注：
 */
public class MusicService extends Service {
    private final String TAG = MusicService.class.getName();
    private AudioManager mAudioManager;
    private boolean isPlaying = false;
    private MyOnAudioFocusChangeListener audioFocusChangeListener;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        // 获取系统音乐服务
        mAudioManager = (AudioManager) getApplicationContext().getSystemService(
                Context.AUDIO_SERVICE);
        // 获取系统音乐服务状态
        isPlaying=mAudioManager.isMusicActive();
        Toast.makeText(getApplicationContext(),"isPlaying:"+mAudioManager.isMusicActive(),Toast.LENGTH_LONG).show();
        audioFocusChangeListener = new MyOnAudioFocusChangeListener();
        if(isPlaying) {//播放状态
            int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                    AudioManager.STREAM_MUSIC,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
            {
                Log.d(TAG, "requestAudioFocus successfully.");
            }
            else
            {
                Log.d(TAG, "requestAudioFocus failed.");
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyOnAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
        @Override
        public void onAudioFocusChange(int focusChange) {
            // TODO Auto-generated method stub
        }
    }
}
