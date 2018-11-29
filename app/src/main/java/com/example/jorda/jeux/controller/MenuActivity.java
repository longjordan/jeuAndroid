package com.example.jorda.jeux.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jorda.jeux.model.EtatJeu;
import com.example.jorda.jeux.R;
import com.example.jorda.jeux.model.QuestionBank;

import java.util.Observable;
import java.util.Observer;

public class MenuActivity extends AppCompatActivity implements Observer {

    private Button cat1;
    private Button cat2;
    private Button cat3;
    private Button cat4;
    private Button cat5;
    private int scoreTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EtatJeu etat = EtatJeu.getInstance();
        setContentView(R.layout.activity_menu);

        QuestionBank.setObservers(this);

        cat1 = findViewById(R.id.cat1);
        cat2 = findViewById(R.id.cat2);
        cat3 = findViewById(R.id.cat3);
        cat4 = findViewById(R.id.cat4);
        cat5 = findViewById(R.id.cat5);

        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                menu.putExtra("categorie", cat1.getId());
                startActivity(menu);
            }
        });

        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreTotal >= 4) {
                    Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                    menu.putExtra("categorie", cat2.getId());
                    startActivity(menu);
                }else{
                    int reste = 4-scoreTotal;
                    Toast.makeText(MenuActivity.this, "Il reste "+reste+" affiche(s) à trouver.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreTotal >= 0) {
                    Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                    menu.putExtra("categorie", cat3.getId());
                    startActivity(menu);
                }else{
                    int reste = 4-scoreTotal;
                    Toast.makeText(MenuActivity.this, "Il reste "+reste+" affiche(s) à trouver.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreTotal >= 0) {
                    Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                    menu.putExtra("categorie", cat4.getId());
                    startActivity(menu);
                }else{
                    int reste = 4-scoreTotal;
                    Toast.makeText(MenuActivity.this, "Il reste "+reste+" affiche(s) à trouver.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreTotal >= 0) {
                    Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                    menu.putExtra("categorie", cat5.getId());
                    startActivity(menu);
                }else{
                    int reste = 4-scoreTotal;
                    Toast.makeText(MenuActivity.this, "Il reste "+reste+" affiche(s) à trouver.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Pas encore utilisé
        /*cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                menu.putExtra("categorie", cat3.getId());
                startActivity(menu);
            }
        });

        cat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, MenuQuestionActivity.class);
                menu.putExtra("categorie", cat4.getId());
                startActivity(menu);
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("MenuActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("MenuActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("MenuActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("MenuActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("MenuActivity::onDestroy()");
    }

    @Override
    public void update(Observable o, Object arg) {
        scoreTotal = QuestionBank.getTotalScore();
    }
}
