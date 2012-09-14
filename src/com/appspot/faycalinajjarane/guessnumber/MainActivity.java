package com.appspot.faycalinajjarane.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appspot.faycalinajjarane.guessnumber.assets.ApplicationBehaviors;
import com.appspot.faycalinajjarane.guessnumber.assets.ApplicationConstantes;
import com.appspot.faycalinajjarane.guessnumber.db.DbHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


public class MainActivity extends OrmLiteBaseActivity<DbHelper> {

	private int defaultLevel = ApplicationConstantes.FLAG_GAME_LEVEL_EASY;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartGame = (Button) findViewById(R.id.button1);




        final Intent intent = new Intent(this, GameArea.class);
        intent.putExtra(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL, defaultLevel);


        btnStartGame.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intent);

			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	ApplicationBehaviors.createLanguageChooserMenu(menu, this);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	ApplicationBehaviors.catchLanguageChooserMenu(item, this, defaultLevel);
    	return true;
    }


}
