package com.devduos.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class bmiresult extends AppCompatActivity {

    int cm,feet,inch,kg,pounds,weightbetween;
    float bmicount,neededweightfrom,neededweightto;
    TextView bmi,needweight,bmiinfo;
    MaterialCardView bmicard,neededweightcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        bmi=findViewById(R.id.bmi);
        needweight=findViewById(R.id.neededweight);
        bmiinfo=findViewById(R.id.bmiinfo);
        bmicard=findViewById(R.id.bmicard);
        neededweightcard=findViewById(R.id.neededweightcard);

        Intent intent=getIntent();

        if(intent.getStringExtra("cm")!=null){
            cm= Integer.parseInt(intent.getStringExtra("cm"));
        }
        if(intent.getStringExtra("feet")!=null){
            feet= Integer.parseInt(intent.getStringExtra("feet"));
        }
        if(intent.getStringExtra("inch")!=null){
            inch= Integer.parseInt(intent.getStringExtra("inch"));
        }
        if(intent.getStringExtra("kg")!=null){
            kg= Integer.parseInt(intent.getStringExtra("kg"));
        }
        if(intent.getStringExtra("pounds")!=null){
            pounds= Integer.parseInt(intent.getStringExtra("pounds"));
        }
        if(intent.getStringExtra("weightbetween")!=null){
            weightbetween= Integer.parseInt(intent.getStringExtra("weightbetween"));
        }


        System.out.println(cm);
        System.out.println(feet);
        System.out.println(inch);
        System.out.println(kg);
        System.out.println(pounds);
        System.out.println(weightbetween);
        System.out.println();

        if(cm==0){


            double feettoInches = (feet * 12) + inch;
            float inchtocm= (float) (feettoInches* 2.54);
            bmicount= (float) (pounds / Math.pow((inchtocm / 100.0), 2));
            bmi.setText(bmicount+"");
        }
        else{
            bmicount= (float) (kg/ Math.pow((cm/100.0), 2));
            bmi.setText(bmicount+"");
        }

        if(bmicount<18.5){
            bmiinfo.setText("UnderWeight");
            bmiinfo.setTextColor(Color.rgb(255,193,7));
            bmi.setTextColor(Color.rgb(255,193,7));
            bmicard.setStrokeColor(Color.rgb(255,193,7));
            neededweightcard.setStrokeColor(Color.rgb(255,193,7));
        }
        else if(bmicount>25.0){
            bmiinfo.setText("OverWeight");
            bmiinfo.setTextColor(Color.rgb(255,0,0));
            bmi.setTextColor(Color.rgb(255,0,0));
            bmicard.setStrokeColor(Color.rgb(255,0,0));
            neededweightcard.setStrokeColor(Color.rgb(255,0,0));
        }
        else{
            bmiinfo.setText("Normal");
            bmiinfo.setTextColor(Color.rgb(76,175,80));
            bmi.setTextColor(Color.rgb(76,175,80));
            bmicard.setStrokeColor(Color.rgb(76,175,80));
            neededweightcard.setStrokeColor(Color.rgb(76,175,80));

        }
        if(cm==0){
            double feettoInches = (feet * 12) + inch;
            float inchtocm= (float) (feettoInches* 2.54);
            neededweightfrom= (float) (18.1 * Math.pow((inchtocm / 100.0), 2));
            neededweightto= (float) (25.0 * Math.pow((inchtocm / 100.0), 2));
            needweight.setText((int)neededweightfrom+"~"+(int)neededweightto);
        }
        else{
            neededweightfrom= (float) (18.1 * Math.pow((cm/100.0), 2));
            neededweightto= (float) (25.0 * Math.pow((cm/100.0), 2));
            needweight.setText((int)neededweightfrom+"~"+(int)neededweightto);
        }

    }

    @Override
    public void finish() {
        super.finish();
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}