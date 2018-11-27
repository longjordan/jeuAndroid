package com.example.jorda.jeux.model;

import java.util.HashMap;
import java.util.Map;

public class EtatJeu {

    private Map<Integer, Integer> score;
    private static EtatJeu instance;

    private EtatJeu() {
        score = new HashMap<Integer, Integer>();
    }


    public static EtatJeu getInstance(){
        if(instance == null){
            instance = new EtatJeu();
        }
        return instance;
    }

    public int getScore(int categorieId) {
         if(score.get(categorieId) == null){
             return 0;
         }else{
             return score.get(categorieId);
         }
    }

    public void setScore(int categorie, int scoreCat) {
        if(score.get(categorie) == null || score.get(categorie) < scoreCat){
            score.put(categorie, scoreCat);
        }
    }
}
