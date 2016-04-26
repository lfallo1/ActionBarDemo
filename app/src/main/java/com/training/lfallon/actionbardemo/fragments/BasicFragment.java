package com.training.lfallon.actionbardemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.lfallon.actionbardemo.R;

public class BasicFragment extends Fragment implements View.OnClickListener {

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;

    private BasicFragmentListener mListener;
    private View button1;
    private View button2;

    public BasicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        // Initialize buttons
        button1 = view.findViewById(R.id.fragment_button1);
        button2 = view.findViewById(R.id.fragment_button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BasicFragmentListener) {
            mListener = (BasicFragmentListener) context;
        }
        else {
            throw new RuntimeException(context.toString() + " must implement BasicFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if(v == button1){
            mListener.onFragmentInteraction("Button 1");
        }
        else if (v == button2){
            mListener.onFragmentInteraction("Button 2");
        }
    }

    public interface BasicFragmentListener {
        void onFragmentInteraction(String s);
    }

}
