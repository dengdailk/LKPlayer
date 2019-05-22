package com.study.lkplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.study.lkplayerjava.listener.VideoListener;
import com.study.lkplayerjava.player.VideoPlayer;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public class MainActivity extends AppCompatActivity implements VideoListener {
    private VideoPlayer videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayer = findViewById(R.id.video);

        videoPlayer.setVideoListener(this);//http://ipfs.ztgame.com.cn/QmRRGU4aUZEqJsHxKzBb1ns97GHw45eCRRZFe6Eu8GCmZ4.m3u8
        videoPlayer.setPath("rtmp://live.hkstv.hk.lxdns.com/live/hks1");
        try {
            videoPlayer.load();
        } catch (IOException e) {
            Toast.makeText(this,"播放失败",Toast.LENGTH_SHORT);
            e.printStackTrace();
        }
    }

    @Override
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {

        videoPlayer.start();
    }

    @Override
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

    }
}
