package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends AppCompatActivity {

    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseMessaging.getInstance().subscribeToTopic("NPSC18");
        Log.d("TAGGER","Subscribed");
        SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);
        status = prefs.getInt("state",0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(status==0) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
                else if(status==1){
                    startActivity(new Intent(SplashActivity.this, CatalogActivity.class));
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
            }
        },2000);


    }
}
