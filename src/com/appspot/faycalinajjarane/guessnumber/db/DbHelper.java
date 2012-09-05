package com.appspot.faycalinajjarane.guessnumber.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DbHelper extends OrmLiteSqliteOpenHelper {
	
	
	private static String DATABASE_NAME = "GuessNumberAndroid";
	private static int DATABASE_VERSION = 3;
	
	private Dao<History, Integer> historyDao;
	private Dao<ApplicationConfig , Integer> applicationConfigDao;
	private Dao<ApplicationConstantes, Integer> applicationConstantesDao;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, History.class);
			TableUtils.createTable(connectionSource, ApplicationConfig.class);
			TableUtils.createTable(connectionSource, ApplicationConstantes.class);
		} catch (SQLException e) {
			Log.e(DbHelper.class.getName(), "Unable to create datbases", e);
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
		try {
			TableUtils.dropTable(connectionSource, History.class, true);
			TableUtils.dropTable(connectionSource, ApplicationConfig.class, true);
			TableUtils.dropTable(connectionSource, ApplicationConstantes.class, true);
			onCreate(sqliteDatabase, connectionSource);
		} catch (SQLException e) {
			Log.e(DbHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
					+ newVer, e);
		}
		
	}

	public Dao<History, Integer> getHistoryDao() {
		return historyDao;
	}

	public void setHistoryDao(Dao<History, Integer> historyDao) {
		this.historyDao = historyDao;
	}

	public Dao<ApplicationConfig , Integer> getApplicationConfigDao() {
		return applicationConfigDao;
	}

	public void setApplicationConfigDao(Dao<ApplicationConfig , Integer> applicationConfigDao) {
		this.applicationConfigDao = applicationConfigDao;
	}

	public Dao<ApplicationConstantes, Integer> getApplicationConstantesDao() {
		return applicationConstantesDao;
	}

	public void setApplicationConstantesDao(Dao<ApplicationConstantes, Integer> applicationConstantesDao) {
		this.applicationConstantesDao = applicationConstantesDao;
	}

}
