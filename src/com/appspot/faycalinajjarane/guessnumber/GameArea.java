package com.appspot.faycalinajjarane.guessnumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class GameArea extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_area);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_area, menu);
        return true;
    }


}
