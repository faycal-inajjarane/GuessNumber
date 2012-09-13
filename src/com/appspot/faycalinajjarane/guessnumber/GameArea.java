package com.appspot.faycalinajjarane.guessnumber;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.faycalinajjarane.guessnumber.db.ApplicationDBMock;
import com.appspot.faycalinajjarane.guessnumber.rules.GameEngine;

public class GameArea extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_area);

        // Get UI components
        final TextView txtNumberToGuess = (TextView) findViewById(R.id.textView1);
        Button btnIGeuss = (Button) findViewById(R.id.button1);
        final TextView txtUserAnswer = (TextView) findViewById(R.id.editText1);
        final Context activityContext = this;
        final GameEngine gameEngine = new GameEngine(ApplicationDBMock.GAME_LEVEL);
        
        txtNumberToGuess.setText( gameEngine.getMinIntInterval() + " < ? < " + gameEngine.getMaxIntInterval());
        
        btnIGeuss.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(gameEngine.checkAnswer(Integer.parseInt(txtUserAnswer.getText().toString()))){	
					final Toast msg = Toast.makeText(activityContext, "Bravo", Toast.LENGTH_LONG);
					msg.show();
				}
				else
				{
					final Toast msg = Toast.makeText(activityContext, "encore une fois!\nEssaie numero " + GameEngine.TRIES, Toast.LENGTH_LONG);
					msg.show();
					txtNumberToGuess.setText( gameEngine.getMinIntInterval() + " < ? < " + gameEngine.getMaxIntInterval());
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_area, menu);
        return true;
    }


}
