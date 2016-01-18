package com.example.juggernaut.service_example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by juggernaut on 18/1/16.
 */
public class Hello_service extends Service {

    //indicate how to behave if the service is killed
    int mStartMode;

    // interface for clients that bind
    IBinder mBinder;

    // indicates whether onRebind should be used
    boolean mAllowRebind;

    // Called when the service is being created
    @Override
    public void onCreate(){

    }

    //the service is starting, due to a call to startService()
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    // A client is binding to the service with bindService()
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // called when all clients have unbound with unbindService()
     @Override
    public void onRebind(Intent intent){

     }

     // Called when the service is no longer used and is being desnroyed
    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
