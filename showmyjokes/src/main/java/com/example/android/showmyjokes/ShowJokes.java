package com.example.android.showmyjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        Intent intent = getIntent();

        if (intent != null){
            String s = getIntent().getStringExtra("result");
            TextView display_jokes = findViewById(R.id.display_jokes);
            display_jokes.setText(s);
        }
    }
}
