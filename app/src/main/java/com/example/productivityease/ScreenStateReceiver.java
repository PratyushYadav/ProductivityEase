package com.example.productivityease;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class ScreenStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (Intent.ACTION_SCREEN_ON.equals(action)) {

                am.setRingerMode(2);
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            if(Auto1.c==0)
                am.setRingerMode(0);
            else if(Auto1.c==1)
                am.setRingerMode(1);
            else if(Auto1.c ==2)
                am.setRingerMode(2);
        }
    }
}