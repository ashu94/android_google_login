package com.example.juggernaut.fragment_intercommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by juggernaut on 3/2/16.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    int counter = 0;
    Button button;
    Communicator communicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = (Button)getActivity().findViewById(R.id.button);
        communicator = (Communicator)getActivity();
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        communicator.respond("the button was clicked "+counter+" times");
    }
}
