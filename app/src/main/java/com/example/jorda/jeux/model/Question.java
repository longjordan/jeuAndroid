package com.example.jorda.jeux.model;

import android.content.IntentFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Question {

    private int image;
    private String reponse;
    private ArrayList<String> reponsesOk = new ArrayList<>();

    public Question(int image, ArrayList<String> reponsesOk){
        this.image=image;
        this.reponsesOk =reponsesOk;
    }
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
