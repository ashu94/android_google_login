package com.example.juggernaut.broadcast_example;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //broadcast a custom event
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.ashu.CustomIntent");
        sendBroadcast(intent);
    }
}
