package com.devduos.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String selected1;
    Integer selectedAge,selectedWeight;
    List<Integer>ageList,weightList;
    String genderselect="";TextView agecounter,weightcounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView agerecyclerview = findViewById(R.id.agerecyclerview);
        RecyclerView weightrecyclerview=findViewById(R.id.weightrecyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        LinearLayoutManager layoutManager1=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        agerecyclerview.setLayoutManager(layoutManager);
        weightrecyclerview.setLayoutManager(layoutManager1);

        ageList=new ArrayList<>();
        weightList=new ArrayList<>();
        weightList.add(null);
        weightList.add(null);
        weightList.add(null);
        ageList.add(null);
        ageList.add(null);
        ageList.add(null);
        for(int i=1;i<150;i++){
            ageList.add(i);
        }

        for(int i=1;i<200;i++){
            weightList.add(i);
        }

        ageRCadapter ageRCadapter=new ageRCadapter(ageList);
        ageRCadapter ageRCadapter1=new ageRCadapter(weightList);

        agerecyclerview.setAdapter(ageRCadapter);
        weightrecyclerview.setAdapter(ageRCadapter1);

        int centerPosition=ageList.size()/2;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                agerecyclerview.smoothScrollToPosition(30);
                weightrecyclerview.smoothScrollToPosition(60);
            }
        },3000);

        agerecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int centerposition=layoutManager.findFirstVisibleItemPosition()+layoutManager.getChildCount()/2;
                ageRCadapter.setSelectedItem(centerposition);
//                selectedAge=ageRCadapter1.getCenteredPosition();

                updateCenteredPosition(agerecyclerview, ageRCadapter);
            }
        });

        weightrecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int centerposition=layoutManager1.findFirstVisibleItemPosition()+layoutManager1.getChildCount()/2;
                ageRCadapter1.setSelectedItem(centerposition);
                updateCenteredPositionw(weightrecyclerview,ageRCadapter1);
            }

        });


        ImageButton male,female;
        ImageView maleselect,femaleselect;

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        maleselect=findViewById(R.id.maleselect);
        femaleselect=findViewById(R.id.femaleselect);
        maleselect.setVisibility(View.INVISIBLE);
        femaleselect.setVisibility(View.INVISIBLE);
        MaterialButton kg=findViewById(R.id.kg);
        MaterialButton pounds=findViewById(R.id.pounds);
        agecounter=findViewById(R.id.agecounter);
        weightcounter=findViewById(R.id.weightcounter);

        Animation slidetoright = AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        slidetoright.setDuration(1500);
        female.startAnimation(slidetoright);
        femaleselect.startAnimation(slidetoright);

        Animation slidetoleft = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        slidetoleft.setDuration(1500);
        male.startAnimation(slidetoleft);
        maleselect.startAnimation(slidetoleft);

        TextView txtage=findViewById(R.id.txtage);
        TextView txtweight=findViewById(R.id.txtweight);
        MaterialButton nextheight = findViewById(R.id.nextheight);

        Animation frombottomtotop=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop.setDuration(2500);
        txtage.startAnimation(frombottomtotop);


        Animation frombottomtotop1=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop1.setDuration(2800);
        agerecyclerview.startAnimation(frombottomtotop1);


        Animation frombottomtotop2=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop2.setDuration(3100);
        txtweight.startAnimation(frombottomtotop2);
        kg.startAnimation(frombottomtotop2);
        pounds.startAnimation(frombottomtotop2);

        Animation frombottomtotop3=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop3.setDuration(3500);
        weightrecyclerview.startAnimation(frombottomtotop3);

        LinearLayout agell=findViewById(R.id.agell);
        Animation frombottomtotop4=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop4.setDuration(3900);
        agell.startAnimation(frombottomtotop4);

        LinearLayout weightll=findViewById(R.id.weightll);
        Animation frombottomtotop5=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop5.setDuration(4200);
        weightll.startAnimation(frombottomtotop5);

        Animation frombottomtotop6=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        frombottomtotop6.setDuration(4500);
        nextheight.startAnimation(frombottomtotop6);



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleselect.setVisibility(View.VISIBLE);
                femaleselect.setVisibility(View.INVISIBLE);
                genderselect="male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femaleselect.setVisibility(View.VISIBLE);
                maleselect.setVisibility(View.INVISIBLE);
                genderselect="female";
            }
        });





        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected1=kg.getText().toString();
                kg.setBackgroundColor(Color.BLACK);
                pounds.setBackgroundColor(Color.parseColor("#3F51B5"));
            }
        });

        pounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected1=pounds.getText().toString();
                pounds.setBackgroundColor(Color.BLACK);
                kg.setBackgroundColor(Color.parseColor("#3F51B5"));
            }
        });


        ageRCadapter.setOnItemClickListener(new ageRCadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedAge=ageList.get(position);
            }
        });


        nextheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected1!=null&&selectedAge!=null&&selectedWeight!=null&&genderselect!="") {
                    Intent intent = new Intent(getApplicationContext(), heightselect.class);
                    intent.putExtra("selected1", selected1);
                    intent.putExtra("selectedAge", selectedAge.toString());
                    intent.putExtra("selectedWeight", selectedWeight.toString());
                    intent.putExtra("gender",genderselect);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); // Corrected
                }
                else{
                    Toast.makeText(getApplicationContext(),"Check All The Fields",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void updateCenteredPosition(RecyclerView recyclerView, ageRCadapter adapter) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

        int centerPosition = (firstVisiblePosition + lastVisiblePosition) / 2;

        if (centerPosition >= 0 && centerPosition < adapter.getItemCount()) {
            selectedAge = ageList.get(centerPosition);
            agecounter.setText(selectedAge.toString());
        }
    }

    private void updateCenteredPositionw(RecyclerView recyclerView, ageRCadapter adapter) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

        int centerPosition = (firstVisiblePosition + lastVisiblePosition) / 2;

        if (centerPosition >= 0 && centerPosition < adapter.getItemCount()) {
            selectedWeight = weightList.get(centerPosition);
            weightcounter.setText(selectedWeight.toString());
        }
    }
}
