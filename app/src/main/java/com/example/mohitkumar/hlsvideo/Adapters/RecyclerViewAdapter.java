package com.example.mohitkumar.hlsvideo.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.hlsvideo.MainActivity;
import com.example.mohitkumar.hlsvideo.Models.DataProviders;
import com.example.mohitkumar.hlsvideo.R;

import java.util.ArrayList;

/**
 * Created by mohitkumar on 01/06/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    Context context;
    ArrayList<String> arraylist = new ArrayList<String>();

    public RecyclerViewAdapter(Context context,ArrayList<String> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyler_view,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,context,arraylist);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final String s = arraylist.get(position);
        final MediaPlayer[] mediaPlayer = {new MediaPlayer()};
        holder.surfaceholder = holder.surfaceView.getHolder();
        holder.surfaceholder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder sholder) {
                mediaPlayer[0] = new MediaPlayer();
                mediaPlayer[0].setDisplay(holder.surfaceholder);
                try {
                    mediaPlayer[0].setDataSource(s);
                    mediaPlayer[0].prepare();
                    mediaPlayer[0].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mediaPlayer[0].setAudioStreamType(AudioManager.STREAM_MUSIC);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<String> arraylist;
        SurfaceView surfaceView;
        SurfaceHolder surfaceholder;
        //MediaPlayer mediaPlayer;
       //String VIDEO_PATH =  "http://playertest.longtailvideo.com/adaptive/bbbfull/bbbfull.m3u8";

        public RecyclerViewHolder(View itemView,Context context,ArrayList<String> arraylist) {
            super(itemView);
            this.context = context;
            this.arraylist = arraylist;
            surfaceView = (SurfaceView) itemView.findViewById(R.id.surface_view);
//            surfaceholder = surfaceView.getHolder();
//            surfaceholder.addCallback((SurfaceHolder.Callback) context);
        }


//        @Override
//        public void onPrepared(MediaPlayer mp) {
//            mediaPlayer.start();
//        }
//
//        @Override
//        public void surfaceCreated(SurfaceHolder holder) {
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setDisplay(surfaceholder);
//            try {
//                mediaPlayer.setDataSource(VIDEO_PATH);
//                mediaPlayer.prepare();
//                mediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener) context);
//                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//        }
//
//        @Override
//        public void surfaceDestroyed(SurfaceHolder holder) {
//
//        }
    }
}
