package com.example.juggernaut.fragmenttransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();

    }

    public void addA(View view){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group, fragmentA, "A");
        transaction.commit();
    }

    public void addB(View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group,fragmentB,"B");
        transaction.commit();
    }
     public void removeA (View view){
         FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("A");
         FragmentTransaction transaction = manager.beginTransaction();
         if (fragmentA != null){
             transaction.remove(fragmentA);
             transaction.commit();
         }else {
             Toast.makeText(this, "Fragment A is not added before",Toast.LENGTH_LONG).show();
         }
     }

    public void removeB (View view){
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null){
            transaction.remove(fragmentB);
            transaction.commit();
        }else {
            Toast.makeText(this,"Fragment B is not added",Toast.LENGTH_LONG).show();
        }
    }

    public void replaceAWithB (View view){
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,fragmentB,"B");
        transaction.commit();
    }

    public void replaceBWithA (View view){
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,fragmentA,"A");
        transaction.commit();
    }

    public void attachA (View view){
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        
    }
}
