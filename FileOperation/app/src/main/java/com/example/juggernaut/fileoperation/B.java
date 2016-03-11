package com.example.juggernaut.fileoperation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by juggernaut on 11/3/16.
 */
public class B extends Activity {

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
    }

    public void load (View view){

        try {
            FileInputStream fileInputStream = openFileInput("juggernaut.txt");
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read())!=-1){
                stringBuffer.append((char)read);
            }

            String text = stringBuffer.substring(0, stringBuffer.indexOf(" "));
            String text1 = stringBuffer.substring(stringBuffer.indexOf(" ")+1);

            username.setText(text);
            password.setText(text1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void previous (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
