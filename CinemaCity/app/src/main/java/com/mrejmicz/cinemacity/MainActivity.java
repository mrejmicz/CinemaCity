package com.mrejmicz.cinemacity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        final VideoView video = (VideoView) findViewById(R.id.videoView);
        video.setVideoPath("android.resource://com.mrejmicz.cinemacity/" + R.raw.loading);

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                video.requestFocus();
                video.start();
            }
        });

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                go();

            }

        }, 5000L);

    }

    public void go() {

        Intent i = new Intent(this, CinemasList.class);
        startActivity(i);
        finish();
    }

}
