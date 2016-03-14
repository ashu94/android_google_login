package com.example.juggernaut.database_insertion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    JuggernautDatabaseAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        helper = new JuggernautDatabaseAdapter(this);
    }

    public void addUser (View view){
        String usr = username.getText().toString();
        String pwd = password.getText().toString();
        long id = helper.insertData(usr,pwd);
        if (id <0){
            Message.Message("unsuccessful",this);
        }else {
            Message.Message("successfull",this);
        }
    }
}
