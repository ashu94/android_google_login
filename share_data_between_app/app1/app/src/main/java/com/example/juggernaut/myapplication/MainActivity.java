package com.example.juggernaut.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        status = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.et_value);
    }

    public void save(View view){


        File file = null;
        String text1 = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("juggernaut.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            status.setTextColor(Color.GREEN);
            status.setText(text1+" written to "+file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
