package com.appspot.faycalinajjarane.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appspot.faycalinajjarane.guessnumber.db.DbHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


public class MainActivity extends OrmLiteBaseActivity<DbHelper> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartGame = (Button) findViewById(R.id.button1);


        final Intent intent = new Intent(this, GameArea.class);
        btnStartGame.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intent);

			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


}
