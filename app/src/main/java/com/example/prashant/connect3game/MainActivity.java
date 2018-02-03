package com.example.prashant.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int yellowPlayer=0;
    int redPlayer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){
        ImageView counter=(ImageView) view;
      counter.setTranslationY(-1500);
/*        counter.setImageResource(R.drawable.yellow);
        counter.animate().translationYBy(1500).setDuration(300);
        */



        if(yellowPlayer==0){

            counter.setImageResource(R.drawable.yellow);
            counter.animate().translationYBy(1500).rotation(720);
            yellowPlayer=1;
            redPlayer=0;


        }else if(redPlayer==0){
            counter.setImageResource(R.drawable.red);
            counter.animate().rotation(720).translationYBy(1500);

            redPlayer=1;
            yellowPlayer=0;
        }



    }
}
