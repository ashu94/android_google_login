package com.example.juggernaut.button_click;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomthing (View view){
        if (view.getId() == R.id.button){
            Log.d("juggernaut", "button 1 was clicked");
        }else if (view.getId() == R.id.button2){
            Log.d("juggernaut", "button2 was clicked!");
        }
    }
}
