package com.example.jorda.jeux.controller;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jorda.jeux.model.Categories;
import com.example.jorda.jeux.model.EtatJeu;
import com.example.jorda.jeux.model.Question;
import com.example.jorda.jeux.model.QuestionBank;
import com.example.jorda.jeux.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {


    private ImageView affiche;
    private Question questionActuelle;
    private Button validation;
    private Button passer;
    private EditText reponse;
    private int categorieActuelle;
    private int numQuestionActuelle;
    private QuestionBank questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        categorieActuelle = getIntent().getIntExtra("categorie", 0);
        numQuestionActuelle = getIntent().getIntExtra("numQuestion",0);

        if(categorieActuelle == R.id.cat1) {
            questions = QuestionBank.getinstance(null, Categories.CATEGORIE1, null);
        } else if (categorieActuelle == R.id.cat2) {
            questions = QuestionBank.getinstance(null, Categories.CATEGORIE2, null);
        }
        /* A compléter avec les autres catégories*/

        questionActuelle = questions.getQuestions().get(numQuestionActuelle-1);
        Drawable d = getResources().getDrawable(questionActuelle.getImage());

        affiche = findViewById(R.id.affiche);
        affiche.setImageDrawable(d);

        validation = findViewById(R.id.validation);
        passer = findViewById(R.id.passer);
        reponse = findViewById(R.id.reponse);

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reponse.getText().toString().substring(0,1).toUpperCase().equals(questionActuelle.getReponse().substring(0,1).toUpperCase())){
                    //PDS pourquoi il y a un substring ? 
                    /*Intent menu = new Intent(QuestionActivity.this, QuestionActivity.class);
                    menu.putExtra("categorie", categorieActuelle);
                    startActivity(menu);
                    finish();*/
                    questions.ajoutPoint(questionActuelle);

                    finish();
                }else{
                    Toast.makeText(QuestionActivity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                }
            }
        });

        passer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }
        );

    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("QuestionActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("QuestionActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("QuestionActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("QuestionActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("QuestionActivity::onDestroy()");
    }
}
