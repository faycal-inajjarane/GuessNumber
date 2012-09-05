package com.appspot.faycalinajjarane.guessnumber.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="configuration")
public class ApplicationConfig {
	
	@DatabaseField
	private Integer id;
	
	@DatabaseField
	private String lang;
	
	@DatabaseField
	private int level;
	
	@DatabaseField(defaultValue="true")
	private boolean firstAppLanch;

	
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isFirstAppLanch() {
		return firstAppLanch;
	}

	public void setFirstAppLanch(boolean firstAppLanch) {
		this.firstAppLanch = firstAppLanch;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
