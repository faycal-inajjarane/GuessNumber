package com.appspot.faycalinajjarane.guessnumber;

import java.sql.SQLException;
import java.util.Date;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appspot.faycalinajjarane.guessnumber.db.DbHelper;
import com.appspot.faycalinajjarane.guessnumber.db.History;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;


public class MainActivity extends OrmLiteBaseActivity<DbHelper> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Dao<History, Integer> daoHistory = getHelper().getHistoryDao() ;
        Button saveData = (Button) findViewById(R.id.button1);
        
        saveData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				History history = new History();
				history.setScore(100);
				history.setScoringDate(new Date());
				try {
					daoHistory.create(history);
				} catch (SQLException e) {
					Log.e(STORAGE_SERVICE, "Can't store score  " + history.toString());
				}
			}
		});
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
