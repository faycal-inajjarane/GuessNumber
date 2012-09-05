package com.appspot.faycalinajjarane.guessnumber.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="constantes")
public class ApplicationConstantes {

	@DatabaseField
	private Integer id;
	
	// Application language (culture: en_US, fr_FR, es_ES...etc.) 
	@DatabaseField
	private String lang;
	
	// Application Levels: 1-> Easy, 2->Intermediate, 3->Hard
	// Enum will be more convenient
	@DatabaseField
	private int level;
	
	
	// [start] GetSet
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	// [end]
}
