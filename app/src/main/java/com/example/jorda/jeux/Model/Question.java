package com.example.jorda.jeux.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class Question {

    private int image;
    private String reponse;

    public Question(int image, String reponse) {
        this.image = image;
        this.reponse = reponse;
    }

    public int getImage() {
        return image;
    }

    public String getReponse() {
        return reponse;
    }
}
