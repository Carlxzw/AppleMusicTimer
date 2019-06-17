package com.carl.applemusictimer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

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
//    @androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
