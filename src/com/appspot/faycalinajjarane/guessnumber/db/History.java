package com.appspot.faycalinajjarane.guessnumber.db;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "hostory")
public class History {

	@DatabaseField
	private Integer id;
	
	// player score 
	@DatabaseField
	private int score;
	
	// player datetime
	@DatabaseField
	private Date scoringDate;

	
	
	// [start] GetSet
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getScoringDate() {
		return scoringDate;
	}

	public void setScoringDate(Date scoringDate) {
		this.scoringDate = scoringDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//[end]
}
