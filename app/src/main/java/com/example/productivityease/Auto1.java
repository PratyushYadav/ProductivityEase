package com.example.productivityease;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class Auto1 extends AppCompatActivity {
    static int c;
    BroadcastReceiver mReceiver;
    AudioManager am;
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto1);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mReceiver = new ScreenStateReceiver();
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }

    public void set(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Silent:
                if (checked) {
                    am.setRingerMode(0);
                    c = 0;
                }
                break;
            case R.id.Vibrate:
                if (checked) {
                    am.setRingerMode(1);
                    c = 1;
                }
                break;
            case R.id.Ring:
                if (checked) {
                    am.setRingerMode(2);
                    c = 2;
                }
                break;
        }
    }
}

