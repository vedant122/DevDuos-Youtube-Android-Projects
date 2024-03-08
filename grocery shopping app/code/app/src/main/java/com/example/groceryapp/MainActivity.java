package com.example.groceryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RelativeLayout relativeLayout;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        imageView=findViewById(R.id.filter);
        relativeLayout=findViewById(R.id.rr);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View view1 = inflater.inflate(R.layout.filterview, null);
                LinearLayout ll= view1.findViewById(R.id.ll);
                Animation animation;
                if(i==0) {
                    animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movtop);
                    ll.startAnimation(animation);
                    relativeLayout.addView(view1);
                    i=1;
                }
                else if(i==1){
                    animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movbottom);
                    relativeLayout.getChildAt(2).startAnimation(animation);
                    relativeLayout.removeViewAt(2);
                    i=0;
                }

            }
        });

        LinearLayout sv=findViewById(R.id.sv);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("yes");
                if(i==1){
                    Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.movbottom);
                    relativeLayout.getChildAt(2).startAnimation(animation);
                    relativeLayout.removeViewAt(2);
                    i=0;
                }
            }
        });


        EditText editText=findViewById(R.id.edittext);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),search.class);
                startActivity(intent);
            }
        });




    }
}