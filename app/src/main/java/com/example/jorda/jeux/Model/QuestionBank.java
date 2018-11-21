package com.example.jorda.jeux.Model;

import java.util.Collections;
import java.util.List;

public class QuestionBank{

    private List<Question> questions;
    private Categories categorie;

    public QuestionBank(List<Question> questions, Categories categorie) {
        this.questions = questions;
        this.categorie = categorie;

        Collections.shuffle(questions);
    }

    public Categories getCategorie() {
        return categorie;
    }

    public Question getQuestion(){
        if(questions.size() <= 0) {
            return null;
        }
        return questions.remove(0);
    }
}
