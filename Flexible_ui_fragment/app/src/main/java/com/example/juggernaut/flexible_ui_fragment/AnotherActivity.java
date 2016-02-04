package com.example.juggernaut.flexible_ui_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by juggernaut on 4/2/16.
 */
public class AnotherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        if (fragmentB!= null){
            fragmentB.changeData(index);
        }
    }
}
