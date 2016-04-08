package com.oreilly.supers;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroDetailFragment extends Fragment {
    private long heroId;

    public HeroDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            heroId = savedInstanceState.getLong("heroId");
        }
        return inflater.inflate(R.layout.fragment_hero_detail, container, false);
    }

    public void setHeroId(long heroId) {
        this.heroId = heroId;
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null) {
            TextView heroView = (TextView) view.findViewById(R.id.hero_name);
            TextView secretIdentity = (TextView) view.findViewById(R.id.secret_identity);
            ImageView picture = (ImageView) view.findViewById(R.id.hero_image);

            Hero hero = Hero.HEROES[(int) heroId];
            heroView.setText(hero.getName());
            secretIdentity.setText(String.format("%s %s", hero.getFirst(), hero.getLast()));
            picture.setImageResource(hero.getImage());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("heroId", heroId);
    }
}
