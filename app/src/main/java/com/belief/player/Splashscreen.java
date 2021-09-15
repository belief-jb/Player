package com.belief.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity
{

    ProgressBar progressBar;
    ImageView img;
    int count=0;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


       progressBar=findViewById(R.id.splash_screen_progress_bar);
        img=findViewById(R.id.splashimg);


          timer=new Timer();
        TimerTask timerTask=new TimerTask()
        {
            @Override
            public void run()
            {
                count++;
                progressBar.setProgress(count);
                if (count==100){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,100);


                new Handler().postDelayed(new Runnable()
                {
            @Override
            public void run()
            {
                Intent i=new Intent(Splashscreen.this,Welcomescreen.class);
                startActivity(i);
            }
        },3000);
    }
}