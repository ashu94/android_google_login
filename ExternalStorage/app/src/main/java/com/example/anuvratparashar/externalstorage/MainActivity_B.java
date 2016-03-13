package com.example.anuvratparashar.externalstorage;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by anuvratparashar on 3/13/16.
 */
public class MainActivity_B extends Activity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        editText = (EditText) findViewById(R.id.editText2);
    }

    public void loadInternalCache (View view){

        File folder = getCacheDir();
        File file = new File(folder,"myData.txt");
        String data = readData(file);
        if (data != null){
            editText.setText(data);
        }else{
            editText.setText("no data found");
        }

    }

    public void loadExternalCache (View view){

        File folder = getExternalCacheDir();
        File file = new File(folder,"myData1.txt");
        String data = readData(file);
        if (data != null){
            editText.setText(data);
        }else{
            editText.setText("no data found");
        }

    }

    public void loadExternalPrivate (View view){

        File folder = getExternalFilesDir("juggernaut");
        File file = new File(folder,"myData2.txt");
        String data = readData(file);
        if (data != null){
            editText.setText(data);
        }else{
            editText.setText("no data found");
        }

    }

    public void loadExternalPublic (View view){

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"myData3.txt");
        String data = readData(file);
        if (data != null){
            editText.setText(data);
        }else{
            editText.setText("no data found");
        }


    }

    public void previous (View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String readData(File myFile){

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read=fileInputStream.read())!=-1){
                stringBuffer.append((char)read);
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
