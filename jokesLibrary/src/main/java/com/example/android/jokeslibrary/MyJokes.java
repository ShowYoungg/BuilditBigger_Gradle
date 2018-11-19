package com.example.android.jokeslibrary;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MyJokes {

    List<String> jokes =  asList("No man is stingy, some are just temporarily unable to dispense cash",
            "Laughter of women can only be bought with money",
            "What play has a fox with ducks",
            "In Nigeria, court marriage is for a foolish man",
            "Another joke, another day");

    public  String getJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
