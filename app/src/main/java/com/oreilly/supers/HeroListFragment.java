package com.oreilly.supers;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeroListFragment extends ListFragment {

    static interface HeroListListener {
        void itemClicked(long id);
    }

    private HeroListListener listener;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                names
        );

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // Still need this for API < 23
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v("ListFragment", "onAttach with activity=" + activity);
        listener = (HeroListListener) activity;
    }

    // Doesn't get called on API < 23
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        listener = (HeroListListener) context;
//    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.v("ListFragment", "position=" + position + ", id=" + id);
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
