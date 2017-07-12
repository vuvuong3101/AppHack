package com.example.rufflez.Cookbook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.rufflez.Cookbook.adapter.FAVGridAdapter;
import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.utils.UtilsFav;
import com.example.rufflez.myapplication.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class FavoritesFragment extends Fragment {
    GridView grid;
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);
        grid = (GridView) rootView.findViewById(R.id.grid_fav);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        FAVGridAdapter gridAdapter =  new FAVGridAdapter(getContext(), UtilsFav.loclist(DatabaseHandle.getHandle(getContext()).getListFood(), true));
        grid.setAdapter(gridAdapter);
    }
}
