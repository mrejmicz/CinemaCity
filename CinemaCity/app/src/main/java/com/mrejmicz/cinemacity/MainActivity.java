package com.mrejmicz.cinemacity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.mklimek.frameviedoview.FrameVideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        String uriString = "android.resource://com.mrejmicz.cinemacity/" + R.raw.ring;

        FrameVideoView frameVideoView = (FrameVideoView) findViewById(R.id.frame_video_view);
        frameVideoView.setup(Uri.parse(uriString), Color.WHITE);
        //frameVideoView.onResume();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                go();

            }

        }, 1000L);

    }

    public void go() {

        Intent i = new Intent(this, CinemasList.class);
        startActivity(i);
        finish();
    }

}