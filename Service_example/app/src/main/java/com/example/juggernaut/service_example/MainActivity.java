package com.example.juggernaut.service_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method to startService
    public void startService(View view){
        startService(new Intent(getBaseContext(), Hello_service.class));
    }

    //method to stopService
    public void stopService(View view){
        stopService(new Intent(getBaseContext(), Hello_service.class));
    }
}
