package com.example.juggernaut.button_click_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Juggernaut());
    }

    class Juggernaut implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.d("juggernaut", "button was click");
        }
    }
}
