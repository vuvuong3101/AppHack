package com.example.rufflez.Cookbook.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rufflez.myapplication.R;

/**
 * Created by HoangLong on 7/11/2017.
 */

public class SearchFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_search_item, container, false);
        return rootView;
    }
}
