package com.example.juggernaut.fragment_intercommunication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by juggernaut on 3/2/16.
 */
public class FragmentB extends Fragment {
    TextView textView;
    String data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        if (savedInstanceState == null){

        }else {
            data = savedInstanceState.getString("text");
            TextView myText = (TextView) view.findViewById(R.id.textView);
            myText.setText(data);
        }
    return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView)getActivity().findViewById(R.id.textView);
    }

    public void changeText(String data){
        this.data = data;
        textView.setText(data);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);
    }
}
