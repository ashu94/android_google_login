package com.example.juggernaut.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView, imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.imageView){
            imageView.setVisibility(View.GONE);
            imageView2.setVisibility(View.INVISIBLE);
        }else {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
        }

    }
}
