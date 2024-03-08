package com.devduos.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class heightselect extends AppCompatActivity {
    String selected1,gender;
    Integer selectedAge,selectedWeight,pounds,kg,cm,inch,feet;
    List<Integer> inchlist,feetList,weightList;
    TextView selectedinch;
    TextView selectedfeet;
    TextView selectedcm;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heightselect);

        selectedinch=findViewById(R.id.selectedinch);
        selectedfeet=findViewById(R.id.selectedfeet);
        selectedcm=findViewById(R.id.selectedcm);

        Intent intent=getIntent();
        selected1=intent.getStringExtra("selected1");
        selectedAge=Integer.parseInt(intent.getStringExtra("selectedAge"));
        selectedWeight=Integer.parseInt(intent.getStringExtra("selectedWeight"));
        gender=intent.getStringExtra("gender");

        ImageView avatar=findViewById(R.id.avatar);
        if(gender.equals("male")){
            avatar.setImageResource(R.drawable.standingmale);
        }
        else{
            avatar.setImageResource(R.drawable.standingfemale);
        }

        LinearLayout llcm=findViewById(R.id.llcm);
        LinearLayout llft=findViewById(R.id.llft);

        if(selected1.equals("KG")){
            llcm.setVisibility(View.VISIBLE);
            llft.setVisibility(View.GONE);
            kg=selectedWeight;
        }
        else{
            llcm.setVisibility(View.GONE);
            llft.setVisibility(View.VISIBLE);
            pounds=selectedWeight;
        }
        RecyclerView rcheight=findViewById(R.id.rcheight);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        rcheight.setLayoutManager(layoutManager);


        weightList=new ArrayList<>();

        for(int i=1;i<=300;i++){
            weightList.add(i);
        }

        ageRCadapter ageRCadapter=new ageRCadapter(weightList);
        rcheight.setAdapter(ageRCadapter);


        int centerPosition=weightList.size()/2;

        rcheight.scrollToPosition(centerPosition);

        rcheight.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int centerposition=layoutManager.findFirstVisibleItemPosition()+layoutManager.getChildCount()/2;
                ageRCadapter.setSelectedItem(centerposition);
                updateCenteredPositioncm(rcheight,ageRCadapter);
            }
        });


        RecyclerView rpfeet=findViewById(R.id.rpfeet);

        LinearLayoutManager layoutManager1=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        rpfeet.setLayoutManager(layoutManager1);


        feetList=new ArrayList<>();

        for(int i=1;i<=11;i++){
            feetList.add(i);
        }

        ageRCadapter feetadapter=new ageRCadapter(feetList);
        rpfeet.setAdapter(feetadapter);

        centerPosition=feetList.size()/2;

        rpfeet.scrollToPosition(centerPosition);

        rpfeet.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int centerposition=layoutManager1.findFirstVisibleItemPosition()+layoutManager1.getChildCount()/2;
                feetadapter.setSelectedItem(centerposition);
                updateCenteredPositionfeet(rpfeet,feetadapter);
            }
        });


        RecyclerView rpinch=findViewById(R.id.rpinch);

        LinearLayoutManager layoutManager2=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        rpinch.setLayoutManager(layoutManager2);


        inchlist=new ArrayList<>();

        for(int i=1;i<=13;i++){
            inchlist.add(i);
        }

        ageRCadapter inchadapter=new ageRCadapter(inchlist);
        rpinch.setAdapter(inchadapter);

        centerPosition=inchlist.size()/2;

        rpinch.scrollToPosition(centerPosition);

        rpinch.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int centerposition=layoutManager2.findFirstVisibleItemPosition()+layoutManager2.getChildCount()/2;
                inchadapter.setSelectedItem(centerposition);
                updateCenteredPositioninch(rpinch,inchadapter);
            }
        });


        Button back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        TextView selectheighttxt=findViewById(R.id.selectheighttxt);

        Animation toptobottom= AnimationUtils.loadAnimation(this,R.anim.slidefromtoptobottom);
        toptobottom.setDuration(2000);
        selectheighttxt.startAnimation(toptobottom);

        Animation lefttoright= AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        lefttoright.setDuration(2000);
        avatar.startAnimation(lefttoright);

        Animation righttoleft= AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        righttoleft.setDuration(2000);
        llcm.startAnimation(righttoleft);
        llft.startAnimation(righttoleft);

        LinearLayout llbuttons=findViewById(R.id.llbuttons);
        Animation bottomtoup=AnimationUtils.loadAnimation(this,R.anim.slidefrombottomtotop);
        bottomtoup.setDuration(2000);
        llbuttons.setAnimation(bottomtoup);


        Button nextbtn=findViewById(R.id.nextbtn);

        System.out.println("kg"+kg);
        System.out.println(pounds);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), bmiinformation.class);
                intent1.putExtra("selected1", selected1);
                intent1.putExtra("selectedAge", selectedAge.toString());
                if(kg!=null) {
                    intent1.putExtra("kg", kg.toString());
                }
                else {
                    intent1.putExtra("pounds", pounds.toString());
                }
                intent1.putExtra("gender",gender);
                if(cm!=null){
                    intent1.putExtra("cm",cm.toString());
                }
                else {
                    intent1.putExtra("inch", inch.toString());
                    intent1.putExtra("feet", feet.toString());
                }
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                f=1;
                finish();
            }
        });


    }

    private void updateCenteredPositioncm(RecyclerView recyclerView, ageRCadapter adapter) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

        int centerPosition = (firstVisiblePosition + lastVisiblePosition) / 2;

        if (centerPosition >= 0 && centerPosition < adapter.getItemCount()) {
            cm = weightList.get(centerPosition);
            selectedcm.setText(cm.toString());
        }
    }

    private void updateCenteredPositionfeet(RecyclerView recyclerView, ageRCadapter adapter) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

        int centerPosition = (firstVisiblePosition + lastVisiblePosition) / 2;

        if (centerPosition >= 0 && centerPosition < adapter.getItemCount()) {
            feet = feetList.get(centerPosition);
            selectedfeet.setText(feet.toString());
        }
    }

    private void updateCenteredPositioninch(RecyclerView recyclerView, ageRCadapter adapter) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

        int centerPosition = (firstVisiblePosition + lastVisiblePosition) / 2;

        if (centerPosition >= 0 && centerPosition < adapter.getItemCount()) {
            inch = inchlist.get(centerPosition);
            selectedinch.setText(inch.toString());
        }
    }

    @Override
    public void finish() {
        super.finish();

        if(f==0) {
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        }
    }

}