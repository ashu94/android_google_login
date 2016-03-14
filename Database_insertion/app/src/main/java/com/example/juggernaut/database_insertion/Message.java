package com.example.juggernaut.database_insertion;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by juggernaut on 14/3/16.
 */
public class Message {
    public static void Message (String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
