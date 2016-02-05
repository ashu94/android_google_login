package com.example.juggernaut.fragmenttransaction;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by juggernaut on 4/2/16.
 */
public class FragmentA extends Fragment {
    @Override
    public void onAttach(Activity activity) {
        Log.d("juggernaut","Fragment A onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("juggernaut","Fragment A onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("juggernaut","Fragment A onCreateView");
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("juggernaut", "Fragment A onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        Log.d("juggernaut", "Fragment A onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("juggernaut", "Fragment A onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d("juggernaut", "Fragment A onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.d("juggernaut", "Fragment A onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("juggernaut", "Fragment A onDetach");
        super.onDetach();
    }
}
