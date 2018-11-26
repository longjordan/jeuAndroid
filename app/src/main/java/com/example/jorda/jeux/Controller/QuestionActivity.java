package com.example.jorda.jeux.Controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jorda.jeux.Model.Categories;
import com.example.jorda.jeux.Model.Question;
import com.example.jorda.jeux.Model.QuestionBank;
import com.example.jorda.jeux.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.jorda.jeux.Model.Categories.CATEGORIE1;

public class QuestionActivity extends AppCompatActivity {

    private QuestionBank questions;
    private ImageView affiche;
    private Question questionActuelle;
    private Button validation;
    private EditText reponse;

    private String categorieActuelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        generateQuestions();
        questionActuelle = questions.getQuestion();
        affiche = findViewById(R.id.affiche);
        Drawable d = getResources().getDrawable(questionActuelle.getImage());
        affiche.setImageDrawable(d);

        validation = (Button) findViewById(R.id.validation);
        reponse = (EditText) findViewById(R.id.reponse);

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reponse.getText().toString().substring(0,1).toUpperCase().equals(questionActuelle.getReponse().substring(0,1).toUpperCase())){
                    /*Intent menu = new Intent(QuestionActivity.this, QuestionActivity.class);
                    menu.putExtra("categorie", categorieActuelle);
                    startActivity(menu);
                    finish();*/
                    questionActuelle = questions.getQuestion();
                    if(questionActuelle == null) {
                        // Activation activité succès
                        finish();
                    } else {
                        affiche = findViewById(R.id.affiche);
                        Drawable d = getResources().getDrawable(questionActuelle.getImage());
                        affiche.setImageDrawable(d);
                        reponse.setText("");
                    }
                }else{
                    Toast.makeText(QuestionActivity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void generateQuestions() {
        categorieActuelle = getIntent().getStringExtra("categorie").toLowerCase();

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

        if(categorieActuelle.equals("categorie1")) {
            questions = new QuestionBank(questCat1, Categories.CATEGORIE1);
        } else if (categorieActuelle.equals("categorie2")) {
            questions = new QuestionBank(questCat2, Categories.CATEGORIE2);
        }/* else if (categorie.equals("categorie3")) {
            questions = new QuestionBank(questCat3, Categories.CATEGORIE3);
        } else if (categorie.equals("categorie4"))) {
            questions = new QuestionBank(questCat4, Categories.CATEGORIE4);
        }*/
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
