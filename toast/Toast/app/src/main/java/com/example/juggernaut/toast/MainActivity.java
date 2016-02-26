package com.example.juggernaut.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        Toast toast = Toast.makeText(this, "button is pressed", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT,0,0);
        toast.show();
    }
}
