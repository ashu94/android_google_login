package com.example.juggernaut.database_insertion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, get_Detail;
    JuggernautDatabaseAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        get_Detail = (EditText) findViewById(R.id.et_get_detail);
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

    public void viewAll(View view){
        String data = helper.loadData();
        Message.Message(data,this);
    }

    public void getDetail(View view){

        String search = get_Detail.getText().toString();
        Toast.makeText(this,helper.getData(search),Toast.LENGTH_LONG).show();
    }

}
