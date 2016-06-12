package com.stromberg.scott.congregation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.stromberg.scott.congregation.R;

import model.Name;
import model.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name.init(getBaseContext());

        for(int i = 0; i < 100; i++) {
            Person person = new Person();
            Log.i("PERSON", person.toString());
        }
    }
}
