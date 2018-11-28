package com.example.jorda.jeux.controller;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jorda.jeux.R;
import com.example.jorda.jeux.model.Categories;
import com.example.jorda.jeux.model.Question;
import com.example.jorda.jeux.model.QuestionBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MenuQuestionActivity extends AppCompatActivity implements Observer {

    private QuestionBank questions;
    private int categorieActuelle;
    private Button q1;
    private Button q2;
    private Button q3;
    private Button q4;
    private List<Button> boutons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_question);

        QuestionBank.setObservers(this);
        generateQuestions();

        boutons = new ArrayList<>();

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);

        boutons.add(q1);
        boutons.add(q2);
        /*boutons.add(q3);
        boutons.add(q4);*/

        // A quoi sert cette méthode ?
        update(null,null);

        //PDS on boucle sur tout les boutons de la liste et on les set avec la bonne question.

        for (int i=0; i<boutons.size();i++){
            //j est une variable recrée à chaque tour de boucle car il nous faut une variable final
            final int j=i;
            boutons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent menu = new Intent(MenuQuestionActivity.this, QuestionActivity.class);
                    menu.putExtra("categorie", categorieActuelle);
                    menu.putExtra("numQuestion", j+1);
                    startActivity(menu);
                }
            });
        }

        /*q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuQuestionActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", categorieActuelle);
                menu.putExtra("numQuestion", 1);
                startActivity(menu);
            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuQuestionActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", categorieActuelle);
                menu.putExtra("numQuestion", 2);
                startActivity(menu);
            }
        });*/

        /*q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuQuestionActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", categorieActuelle);
                menu.putExtra("numQuestion", 3);
                startActivity(menu);
            }
        });

        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuQuestionActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", categorieActuelle);
                menu.putExtra("numQuestion", 4);
                startActivity(menu);
            }
        });*/
    }

    //Methode qui génére suivant la catégorie les questions pour les images choisi.
    private void generateQuestions() {
        categorieActuelle = getIntent().getIntExtra("categorie",0);

        //PDS voir si on peut pas faire une méthode avec une liste et pour chaque tour de boucle on met l'élément suivant
        //PDS faire que la réponse soit une liste de proposition et qu'on regarde si elle est dedans.

        Question question1 = new Question(R.drawable.mep3, "Death note");
        Question question2 = new Question(R.drawable.mep14, "Olive et Tom");

        Question question3 = new Question(R.drawable.mep5, "Interstellar");
        Question question4 = new Question(R.drawable.mep48, "Dragons");

        List<Question> questCat1 = new ArrayList<>();
        List<Question> questCat2 = new ArrayList<>();
        questCat1.add(question1);
        questCat1.add(question2);
        questCat2.add(question3);
        questCat2.add(question4);

        if(categorieActuelle == R.id.cat1) {
            questions = QuestionBank.getinstance(questCat1, Categories.CATEGORIE1);
        } else if (categorieActuelle == R.id.cat2) {
            questions = QuestionBank.getinstance(questCat2, Categories.CATEGORIE2);
        }
        //Pas encore utilisé
        /* else if (categorie.equals("cat3")) {
            questions = new QuestionBank(questCat3, Categories.CATEGORIE3);
        } else if (categorie.equals("categorie4"))) {
            questions = new QuestionBank(questCat4, Categories.CATEGORIE4);
        }*/
    }

    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < questions.getQuestions().size(); i++){
            if(questions.getQuestionScore(questions.getQuestions().get(i)) == 1){
                Button b = boutons.get(i);
                b.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
            }
        }
    }
}
