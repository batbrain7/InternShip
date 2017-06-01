package com.example.mohitkumar.hlsvideo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.mohitkumar.hlsvideo.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    MediaPlayer mediaPlayer;
    String VIDEO_PATH = "http://playertest.longtailvideo.com/adaptive/bbbfull/bbbfull.m3u8";


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> arraylist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(MainActivity.this);

        for(int i=0;i<4;i++) {
            arraylist.add(VIDEO_PATH);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(getApplicationContext(),arraylist);
        recyclerView.setAdapter(adapter);



    }

//    @Override
//    public void onPrepared(MediaPlayer mp) {
//        mediaPlayer.start();
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setDisplay(surfaceHolder);
//        try {
//            mediaPlayer.setDataSource(VIDEO_PATH);
//            mediaPlayer.prepare();
//            mediaPlayer.setOnPreparedListener(MainActivity.this);
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//    private void releaseMediaPlayer() {
//        if(mediaPlayer!=null) {
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//    }
}
