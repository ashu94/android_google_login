package com.example.juggernaut.file_operation;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Intent intent = null,chooser = null;
    public void process (View view){
        if (view.getId() == R.id.button){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.254,72.368"));
            chooser = Intent.createChooser(intent,"select app");
            startActivity(chooser);
        }
        if (view.getId() == R.id.launch_market){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser = Intent.createChooser(intent,"select market");
            startActivity(chooser);
        }

        if (view.getId() == R.id.email) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String to[] = {"me@ashutoshksingh.com", "test@test.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intent.putExtra(Intent.EXTRA_TEXT, "anoteh");
            intent.setType("message/rfc822");
            chooser = intent.createChooser(intent,"send email");
            startActivity(chooser);
        }

        if (view.getId() == R.id.send_image){
            Uri image = Uri.parse("android.resource://com.example.juggernaut.file_operation/drawable/"+R.mipmap.ic_launcher);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, image);
            intent.putExtra(Intent.EXTRA_TEXT, "hello attachment");
            chooser = Intent.createChooser(intent,"send image");
            startActivity(chooser);
        }

        if (view.getId() == R.id.send_images){
            File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String [] listofpicture = pictures.list();
            Uri uri = null;
            ArrayList<Uri> arrayList = new ArrayList<Uri>();
            for (String picture : listofpicture){
                uri = Uri.parse("file://"+pictures.toString()+"/"+picture);
                arrayList.add(uri);
            }
            intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,arrayList);
            chooser = Intent.createChooser(intent,"send multiple images");
            startActivity(chooser);
        }
    }
}
