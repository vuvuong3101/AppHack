package com.example.rufflez.Cookbook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rufflez.myapplication.R;


/**
 * Created by rufflez on 6/21/15.
 */
public class InfoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);
        return rootView;
    }

}
