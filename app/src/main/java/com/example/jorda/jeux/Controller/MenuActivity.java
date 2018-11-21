package com.example.jorda.jeux.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jorda.jeux.R;

import static com.example.jorda.jeux.Model.Categories.*;

public class MenuActivity extends AppCompatActivity {

    private Button cat1;
    private Button cat2;
    private Button cat3;
    private Button cat4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cat1 = (Button) findViewById(R.id.cat1);
        cat2 = (Button) findViewById(R.id.cat2);
        cat3 = (Button) findViewById(R.id.cat3);
        cat4 = (Button) findViewById(R.id.cat4);

        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", cat1.getText().toString());
                startActivity(menu);
            }
        });

        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", cat2.getText().toString());
                startActivity(menu);
            }
        });

        cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", cat3.getText().toString());
                startActivity(menu);
            }
        });

        cat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MenuActivity.this, QuestionActivity.class);
                menu.putExtra("categorie", cat4.getText().toString());
                startActivity(menu);
            }
        });
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
}
