package com.example.jorda.jeux.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.jorda.jeux.R;
import com.example.jorda.jeux.model.Categories;
import com.example.jorda.jeux.model.Question;
import com.example.jorda.jeux.model.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MenuQuestionActivity extends AppCompatActivity implements Observer {

    private QuestionBank questions;
    private int categorieActuelle;
    private ImageButton q1;
    private ImageButton q2;
    private ImageButton q3;
    private ImageButton q4;
    private ImageButton q5;
    private ImageButton q6;
    private ImageButton q7;
    private ImageButton q8;
    private List<ImageButton> boutons;

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
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);

        boutons.add(q1);
        boutons.add(q2);
        boutons.add(q3);
        boutons.add(q4);
        boutons.add(q5);
        boutons.add(q6);
        boutons.add(q7);
        boutons.add(q8);

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

        for(int i = 0; i < questions.getQuestions().size(); i++){
            ImageButton b = boutons.get(i);
            Drawable affiche = getResources().getDrawable(questions.getQuestions().get(i).getImage());

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),questions.getQuestions().get(i).getImage());
            bitmap = Bitmap.createBitmap(bitmap,200,300,500,500);
            b.setImageBitmap(bitmap);
            b.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
        Question question4 = new Question(R.drawable.mep, "Insaisissable");
        Question question5 = new Question(R.drawable.mep25, "Harry Potter");
        Question question6 = new Question(R.drawable.mep33, "Alien");
        Question question7 = new Question(R.drawable.mep21, "Le seigneur des anneaux");
        Question question8 = new Question(R.drawable.mep23, "Le fabuleux destin d'Amélie Poulain");

        Question question9 = new Question(R.drawable.mep48, "Dragons");
        Question question10 = new Question(R.drawable.mep2, "Sherlock Holmes");
        Question question11 = new Question(R.drawable.mep15, "Star Wars");
        Question question12 = new Question(R.drawable.mep16, "le cinquième élément");
        Question question13 = new Question(R.drawable.mep17, "Titanic");
        Question question14 = new Question(R.drawable.mep18, "X-men");
        Question question15 = new Question(R.drawable.mep22, "Jurassic Park");
        Question question16 = new Question(R.drawable.mep11, "Princesse Mononoké");

        Question question17 = new Question(R.drawable.mep4, "Avatar");
        Question question18 = new Question(R.drawable.mep13, "Le Hobbit");
        Question question19 = new Question(R.drawable.mep19, "Indiana Jones");
        Question question20 = new Question(R.drawable.mep24, "le silence des agneaux");
        Question question21 = new Question(R.drawable.mep35, "Watchmen");
        Question question22 = new Question(R.drawable.mep37, "Godzilla");
        Question question23 = new Question(R.drawable.mep43, "Rox et rouky");
        Question question24 = new Question(R.drawable.mep38, "Fight Club");

        Question question25 = new Question(R.drawable.mep8, "Zelda");
        Question question26 = new Question(R.drawable.mep6, "Split");
        Question question27 = new Question(R.drawable.mep50, "Wall-E");
        Question question28 = new Question(R.drawable.mep51, "le monde de Ralph");
        Question question29 = new Question(R.drawable.mep32, "le ligne verte");
        Question question30 = new Question(R.drawable.mep56, "Pac-Man");
        Question question31 = new Question(R.drawable.mep57, "Game of Thrones");
        Question question32 = new Question(R.drawable.mep34, "Inception");

        Question question33 = new Question(R.drawable.mep58, "Dr House");
        Question question34 = new Question(R.drawable.mep53, "Le roi lion");
        Question question35 = new Question(R.drawable.mep54, "Spirit");
        Question question36 = new Question(R.drawable.mep39, "Pirate des caraibes");
        Question question37 = new Question(R.drawable.mep20, "Matrix");
        Question question38 = new Question(R.drawable.mep27, "Je suis une légende");
        Question question39 = new Question(R.drawable.mep30, "Scream");
        Question question40 = new Question(R.drawable.mep10, "Pokémon");

        List<Question> questCat1 = new ArrayList<>();
        List<Question> questCat2 = new ArrayList<>();
        List<Question> questCat3 = new ArrayList<>();
        List<Question> questCat4 = new ArrayList<>();
        List<Question> questCat5 = new ArrayList<>();

        Collections.addAll(questCat1, question1, question2, question3, question4, question5, question6, question7, question8);
        Collections.addAll(questCat2, question9, question10, question11, question12, question13, question14, question15, question16);
        Collections.addAll(questCat3, question17, question18, question19, question20, question21, question22, question23, question24);
        Collections.addAll(questCat4, question25, question26, question27, question28, question29, question30, question31, question32);
        Collections.addAll(questCat5, question33, question34, question35, question36, question37, question38, question39, question40);


        if(categorieActuelle == R.id.cat1) {
            questions = QuestionBank.getinstance(questCat1, Categories.CATEGORIE1);
        } else if (categorieActuelle == R.id.cat2) {
            questions = QuestionBank.getinstance(questCat2, Categories.CATEGORIE2);
        } else if (categorieActuelle == R.id.cat3) {
            questions = QuestionBank.getinstance(questCat3, Categories.CATEGORIE3);
        } else if (categorieActuelle == R.id.cat4) {
            questions = QuestionBank.getinstance(questCat4, Categories.CATEGORIE4);
        } else if (categorieActuelle == R.id.cat5) {
            questions = QuestionBank.getinstance(questCat5, Categories.CATEGORIE5);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < questions.getQuestions().size(); i++){
            if(questions.getQuestionScore(questions.getQuestions().get(i)) == 1){
                ImageButton b = boutons.get(i);
                b.getBackground().setColorFilter(Color.rgb(76,175,80), PorterDuff.Mode.MULTIPLY);
            }
        }
    }
}
