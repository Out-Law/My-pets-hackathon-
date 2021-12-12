package com.example.mypets;

import android.graphics.drawable.Drawable;

public class settings_cards {
    private String text;
    private Drawable img;

    public settings_cards(String name, Drawable idImg) {
        this.text = name;
    }

    String getText() {
        return text;
    }

    Drawable getImg() {
        return img;
    }
}
