package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class startinganimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startinganimation);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        VideoView videoView=findViewById(R.id.video);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.starting);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

        TextView textView=findViewById(R.id.grocery);
        ViewGroup viewGroup=findViewById(R.id.ll);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        textView.setAnimation(animation);

        videoView.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movtop));

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}