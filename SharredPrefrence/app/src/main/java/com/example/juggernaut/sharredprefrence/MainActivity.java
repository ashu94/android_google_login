package com.example.juggernaut.sharredprefrence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
    }

    public void save (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("myData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();
    }

    public void next (View view){
        Intent intent = new Intent(this,MainActivityB.class);
        startActivity(intent);
    }
}
