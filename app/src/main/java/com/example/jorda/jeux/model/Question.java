package com.example.jorda.jeux.model;

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
