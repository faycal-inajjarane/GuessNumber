package com.appspot.faycalinajjarane.guessnumber;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.appspot.faycalinajjarane.guessnumber.rules.GameEngine;
import com.appspot.faycalinajjarane.guessnumber.statics.ApplicationConstantes;

public class GameArea extends Activity {


	private EditText txtUserAnswer;
	private GameEngine gameEngine;
	private TextView txtNumberToGuess;

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

    	SubMenu menuLang = menu.addSubMenu(0, 0, 0, getResources().getString(R.string.menu_lang));
    	SubMenu menuLevel = menu.addSubMenu(0, 0, 1, getResources().getString(R.string.menu_level));


    	menuLang.add(0, 1001, 0, getResources().getString(R.string.menu_lang_english));
    	menuLang.add(0, 1002, 0, getResources().getString(R.string.menu_lang_french));

    	menuLevel.add(0, 2001, 0, getResources().getString(R.string.menu_level_easy));
    	menuLevel.add(0, 2002, 0, getResources().getString(R.string.menu_level_medium));
    	menuLevel.add(0, 2003, 0, getResources().getString(R.string.menu_level_hard));

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()) {

		case 1001:
			setLocale(Locale.ENGLISH);
			break;

		case 1002:
			setLocale(Locale.FRANCE);
			break;


		case 2001:
			setLevel(1);
			break;

		case 2002:
			setLevel(2);
			break;

		case 2003:
			setLevel(3);
			break;
		}

    	return true;
    }

    private void setLevel(int level) {

		try {
			Context context = this.createPackageContext(this.getPackageName(), Context.CONTEXT_INCLUDE_CODE);
			Intent intent = new Intent(context, GameArea.class);
			intent.putExtra(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL, level);
			startActivity(intent);
			this.finish();

		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		}
	}

	private void setLocale(Locale locale){

    	Resources res = getResources();
    	Configuration conf = res.getConfiguration();
    	conf.locale = locale;
    	res.updateConfiguration(conf, res.getDisplayMetrics());

		try {
			Context context = this.createPackageContext(this.getPackageName(), Context.CONTEXT_INCLUDE_CODE);
			Intent intent = new Intent(context, GameArea.class);
			intent.putExtra(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL, gameEngine.getLevel());
			startActivity(intent);
			this.finish();

		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		}

    }


	private void initializeUIComponents(){
    	txtNumberToGuess = (TextView) findViewById(R.id.textView1);
        txtUserAnswer = (EditText) findViewById(R.id.editText1);
        gameEngine = new GameEngine(getIntent().getExtras().getInt(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL));
        txtNumberToGuess.setText( gameEngine.getMinIntInterval() + " < ? < " + gameEngine.getMaxIntInterval());
        txtUserAnswer.setEnabled(false);
    }

    // Event fired when Clear button is clicked
    public void fireClearUserAnswer(View btn){
    	txtUserAnswer.setText("");
    }

    // Event fired when one of numeric keys button is clicked
    public void firePutNumber(View btnNumberTxt){
    	if(btnNumberTxt instanceof ImageButton){
    		txtUserAnswer.setText(txtUserAnswer.getText() + ((ImageButton)btnNumberTxt).getTag().toString());
    	}
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
