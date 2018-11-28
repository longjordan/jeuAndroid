package com.example.jorda.jeux.model;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class QuestionBank extends Observable {

    private Map<Question, Integer> score;
    private Categories categorie;
    private List<Question> questions;
    private static Map<Categories, QuestionBank> instances;
    private static List<Observer> observers;

    public static QuestionBank getinstance(List<Question> questions, Categories categorie){
        if(instances == null){
            instances = new HashMap<>();
        }
        QuestionBank instance = instances.get(categorie);
        if(instance == null){
            instance = new QuestionBank(questions,categorie);
            instances.put(categorie,instance);
        }
        return instance;
    }

    private QuestionBank(List<Question> questions, Categories categorie) {

        this.score = new HashMap<>();
        for(Question q : questions){
            this.score.put(q,0);
        }
        this.categorie = categorie;
        this.questions = questions;
        for(Observer o : observers){
            addObserver(o);
        }
    }

    public static void setObservers (Observer observer){
        if(observers == null){
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    public void ajoutPoint(Question question){
        this.score.put(question,1);
        setChanged();
        notifyObservers();
    }

    public int getQuestionScore(Question question){ return score.get(question); }

    public Categories getCategorie() {
        return categorie;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        int somme = 0;
        for(int i : score.values()){
            somme+=i;
        }
        return somme;
    }

    public static int getTotalScore(){
        Iterator iterator = instances.entrySet().iterator();
        int somme = 0;
        while(iterator.hasNext()){
            Map.Entry couple = (Map.Entry)iterator.next();
            QuestionBank questionBank = (QuestionBank)couple.getValue();
            somme += questionBank.getScore();
        }
        return somme;

    }

}
