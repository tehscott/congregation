package com.stromberg.scott.congregation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.stromberg.scott.congregation.R;

import com.stromberg.scott.congregation.model.Game;
import com.stromberg.scott.congregation.model.Person;

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
                int peopleToGenerate = 10;

                for(int i = 0; i < peopleToGenerate; i++) {
                    Person person = new Person();

                    game.getPopulation().addPerson(person);

                    //Log.i("PERSON", person.toString());
                }

                Toast.makeText(MainActivity.this, peopleToGenerate + " people generated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
