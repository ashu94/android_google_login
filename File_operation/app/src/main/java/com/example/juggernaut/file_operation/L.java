package com.example.juggernaut.file_operation;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by juggernaut on 25/2/16.
 */
public class L {
    public static void  m(String msg){
        Log.d("juggernaut", msg);
    }
    public static void s(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
