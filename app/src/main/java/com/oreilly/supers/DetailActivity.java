package com.oreilly.supers;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {
    public static final String EXTRA_HERO_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        HeroDetailFragment fragment = (HeroDetailFragment) getFragmentManager()
                .findFragmentById(R.id.detail_fragment);
        long heroId = getIntent().getExtras().getLong(EXTRA_HERO_ID);
        fragment.setHeroId(heroId);
    }
}
