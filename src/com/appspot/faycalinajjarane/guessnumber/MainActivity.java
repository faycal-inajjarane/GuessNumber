package com.appspot.faycalinajjarane.guessnumber;

import com.appspot.faycalinajjarane.guessnumber.db.DbHelper;
import com.appspot.faycalinajjarane.guessnumber.db.History;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MainActivity extends OrmLiteBaseActivity<DbHelper> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Dao<History, Integer> daoHistory = getHelper().getHistoryDao() ;
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
