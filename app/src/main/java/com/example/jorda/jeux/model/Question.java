package com.example.jorda.jeux.model;

import android.content.IntentFilter;

import java.io.Serializable;
import java.util.ArrayList;
public class Question implements Serializable {

    private int image;
    private String regex ;

    //PDS en changeant pour regex
    public Question(int image, String regex){
        this.image=image;
        this.regex=regex;
    }

    public int getImage() {
        return image;
    }

    public String getRegex(){ return regex; }

}
