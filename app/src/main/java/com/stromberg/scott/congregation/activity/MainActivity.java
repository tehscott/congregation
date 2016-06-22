package com.stromberg.scott.congregation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.stromberg.scott.congregation.R;

import model.Game;
import personattribute.Name;
import model.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        final Game game = new Game(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 1000; i++) {
                    Person person = new Person();

                    game.getPopulation().addPerson(person);

                    //Log.i("PERSON", person.toString());
                }
            }
        });
    }
}
