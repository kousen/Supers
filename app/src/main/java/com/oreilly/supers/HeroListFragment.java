package com.oreilly.supers;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class HeroListFragment extends ListFragment {


    public HeroListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Hero.HEROES.length];
        for (int i = 0; i < Hero.HEROES.length; i++) {
            names[i] = Hero.HEROES[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                names
        );

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
