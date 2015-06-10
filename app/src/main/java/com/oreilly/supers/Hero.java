package com.oreilly.supers;

public class Hero {
    private String name;
    private String first;
    private String last;
    private int image;

    public static final Hero[] HEROES = {
            new Hero("Mr. Incredible", "Robert", "Parr", R.drawable.mr_incredible),
            new Hero("ElastiGirl", "Helen", "Parr", R.drawable.elastigirl),
            new Hero("Frozone", "Lucius", "Best", R.drawable.frozone),
            new Hero("Gazerbeam", "Simon", "Paladino", R.drawable.gazerbeam)
    };

    public Hero(String name, String first, String last, int image) {
        this.name = name;
        this.first = first;
        this.last = last;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public int getImage() {
        return image;
    }
}
