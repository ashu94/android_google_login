package com.example.juggernaut.app2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    String packageName = "com.example.juggernaut.myapplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);
    }

    public void load (View view){

        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            String fullPath =applicationInfo.dataDir + "/files/juggernaut.txt";
            readFile(fullPath);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            tv.setTextColor(Color.RED);
            tv.setText(e + "");
        }

    }

    public void readFile (String filePath){
        FileInputStream fileInputStream = null;
        try {
           fileInputStream = new FileInputStream(new File(filePath));
          int read = -1;
          StringBuffer stringBuffer = new StringBuffer();

            while ((read = fileInputStream.read()) != -1){
                stringBuffer.append((char)read);
            }

            et.setText(stringBuffer);
            tv.setTextColor(Color.GREEN);
            tv.setText(stringBuffer+ " was read successfully from "+filePath);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
