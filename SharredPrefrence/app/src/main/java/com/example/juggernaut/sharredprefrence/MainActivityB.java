package com.example.juggernaut.sharredprefrence;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by juggernaut on 8/3/16.
 */
public class MainActivityB extends Activity {
    EditText username,password;
    public static final String Default = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
    }

    public void load (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("myData",MODE_PRIVATE);
        String name = sharedPreferences.getString("name", Default);
        String password1 = sharedPreferences.getString("password", Default);
        if (name.equals(Default)||password1.equals(Default)){
            Toast.makeText(this,Default,Toast.LENGTH_LONG).show();
        }else{
            username.setText(name);
            password.setText(password1);
        }
    }

    public void previous (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
