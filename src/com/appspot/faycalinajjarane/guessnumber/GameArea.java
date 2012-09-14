package com.appspot.faycalinajjarane.guessnumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.faycalinajjarane.guessnumber.assets.ApplicationBehaviors;
import com.appspot.faycalinajjarane.guessnumber.assets.ApplicationConstantes;
import com.appspot.faycalinajjarane.guessnumber.rules.GameEngine;

public class GameArea extends Activity {


	private EditText txtUserAnswer;
	private GameEngine gameEngine;
	private TextView txtNumberToGuess;
	private Button btnGuess;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_area);

        // Get and set UI components
        this.initializeUIComponents();

        // Initialize number of tries
        GameEngine.TRIES = 0;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    	
    	ApplicationBehaviors.createLanguageChooserMenu(menu, this);
    	ApplicationBehaviors.createLevelChooserMenu(menu, this);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	ApplicationBehaviors.catchLanguageChooserMenu(item, this, gameEngine.getLevel());
    	ApplicationBehaviors.catchLevelChooserMenu(item, this);

    	return true;
    }

    

	

	// Initialize all UI components for first time display
	private void initializeUIComponents(){
    	int level = getIntent().getExtras().getInt(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL);
		
    	txtNumberToGuess = (TextView) findViewById(R.id.textView1);
        txtUserAnswer = (EditText) findViewById(R.id.editText1);
        btnGuess = (Button) findViewById(R.id.btnIGuess);
        
        
        gameEngine = new GameEngine(level);
        txtNumberToGuess.setText( gameEngine.getMinIntInterval() + " < ? < " + gameEngine.getMaxIntInterval());
        txtUserAnswer.setEnabled(false);
    }

    // Event fired when Clear button is clicked
    public void fireClearUserAnswer(View btn){
    	txtUserAnswer.setText("");
    	btnGuess.setEnabled(false);
    }
    
    // Event fired when Delete button "<" is clicked
    public void fireDeleteLastUserAnswerDigit(View btn){
    	CharSequence userTypedNumber = txtUserAnswer.getText();
    	txtUserAnswer.setText(userTypedNumber.subSequence(0, userTypedNumber.length()-1));
    	btnGuess.setEnabled(txtUserAnswer.getText().length()!=0);
    }

    // Event fired when one of numeric keys button is clicked
    public void firePutNumber(View btnNumberTxt){
    	txtUserAnswer.setText(txtUserAnswer.getText() + ((ImageButton)btnNumberTxt).getTag().toString());
    	btnGuess.setEnabled(txtUserAnswer.getText().length()!=0);
    }
    // Event fired when iGuess button is clicked
    public void fireGuessNumber(View btnGuessNumber){

    	if(gameEngine.checkAnswer(Integer.parseInt(txtUserAnswer.getText().toString()))){
    		final Toast msg = Toast.makeText(this, "Bravo", Toast.LENGTH_LONG);
			msg.show();
		}
		else
		{
			final Toast msg = Toast.makeText(this, "encore une fois!\nEssaie numero " + GameEngine.TRIES, Toast.LENGTH_LONG);
			msg.show();
			txtNumberToGuess.setText( gameEngine.getMinIntInterval() + " < ? < " + gameEngine.getMaxIntInterval());
			fireClearUserAnswer(btnGuessNumber);
		}

    }

}
