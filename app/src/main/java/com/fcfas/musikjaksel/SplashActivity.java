package com.fcfas.musikjaksel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent splash = new Intent(this, MainActivity.class);
        startActivity(splash);
        finish();
    }
}
