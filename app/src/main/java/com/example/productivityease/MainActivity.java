package com.example.productivityease;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final Object ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS = true;
    Button b1, b2, b3, b4,b5,b6,b7;
    AudioManager am;
    NotificationManager manager;
    private Object view;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.auto);
        b5 = (Button) findViewById(R.id.studymode);
        b6 = (Button)  findViewById(R.id.focusmode);
    //    b7 = (Button) findViewById(R.id.infobutton);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        boolean[] check = {manager.isNotificationPolicyAccessGranted()};
        if (!manager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(
                    android.provider.Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
            check[0] = manager.isNotificationPolicyAccessGranted();
        }
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check[0]) {
                    am.setRingerMode(0);
                    View textview = findViewById(R.id.error);
                    textview.setVisibility(View.INVISIBLE);
                }
                else
                {
                    View textview = findViewById(R.id.error);
                    textview.setVisibility(View.VISIBLE);
                }

            }
        });
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                am.setRingerMode(1);
                View textview = findViewById(R.id.error);
                textview.setVisibility(View.INVISIBLE);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    am.setRingerMode(2);
                    View textview = findViewById(R.id.error);
                    textview.setVisibility(View.INVISIBLE);
            }
        });
        b4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent a = new Intent(MainActivity.this, Auto1.class);
                startActivity(a);
            }
        });
       b5.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
                   am.setRingerMode(2);
                   manager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_PRIORITY);
               }
           });

        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // make to be able to set alarm
                // fil a bar till that time
                // vibrate once if try to open before time
                Intent an = new Intent(MainActivity.this, focusmode.class);
                startActivity(an);
            }
        });
//        b7.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, info.class);
//                startActivity(i);
//
//            }
//        });

            }
}


