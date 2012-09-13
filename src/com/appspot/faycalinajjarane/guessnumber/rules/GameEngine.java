package com.appspot.faycalinajjarane.guessnumber.rules;

public class GameEngine {

	public static int TRIES = 0; 
	private int numberToGuess;
	private int level;
	private int maxIntInterval;
	private int minIntInterval;
	
	public GameEngine(int level){
		this.setLevel(level);
		this.setNumberToGuess((int) Math.round(Math.random()*Math.pow(10,getLevel())));
		this.setIntervals(GameEngine.TRIES++);
	}

	public boolean checkAnswer(int response){

		if(response != this.getNumberToGuess())
			this.setIntervals(GameEngine.TRIES++);

		return response == this.getNumberToGuess();
	}

	private void setIntervals(int tries){
		// x-ipsilon-1 < x < x+gama+1
		int randomMin = (int) Math.round(Math.random()*Math.pow(10,getLevel())/(tries+1));
		int randomMax = (int) Math.round(Math.random()*Math.pow(10,getLevel())/(tries+1));

		this.setMinIntInterval(this.getNumberToGuess()- Math.min(this.getNumberToGuess(), randomMin)-1);
		this.setMaxIntInterval(this.getNumberToGuess()+Math.min(this.getNumberToGuess(), randomMax)+1);
		
	}
	
	// [start] getters/setters 
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxIntInterval() {
		return maxIntInterval;
	}
	public void setMaxIntInterval(int maxIntInterval) {
		this.maxIntInterval = maxIntInterval;
	}
	public int getMinIntInterval() {
		return minIntInterval;
	}
	public void setMinIntInterval(int minIntInterval) {
		this.minIntInterval = minIntInterval;
	}
	public int getNumberToGuess(){
		return this.numberToGuess;
	}
	private void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}
	
	// [end]
	
}
