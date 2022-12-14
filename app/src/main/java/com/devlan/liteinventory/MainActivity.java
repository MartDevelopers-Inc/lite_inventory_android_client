package com.devlan.liteinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private static int splashTimeOut = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_main);
        logo = (ImageView) findViewById(R.id.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, WebViewLoader.class);
                startActivity(i);
                finish();
            }
        }, splashTimeOut);

        Animation my_anim = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        logo.startAnimation(my_anim);
    }
}