package com.fourmisses.fourmies;

public class Warrior extends Ant{

	Boolean isFighting = false;
	int targetFlagX;
	int targetFlagY;
	
	/////CONSTRUCTOR/////
	public Warrior(double x, double y, int speedX, int speedY, Boolean onTrack, int id, int health, int food) {
		super(x, y, speedX, speedY, onTrack, id, health, food);
		this.isFighting = isFighting;
		this.targetFlagX = targetFlagX;
		this.targetFlagY = targetFlagY;
	}
	
	Boolean orderFight(int targetX, int targetY) {
		isFighting = true;
		this.targetFlagX = targetX;
		this.targetFlagY = targetY;
		
		return true;
	}
	
	//orderDontFight
	Boolean orderDontFight(int targetX, int targetY) {
		isFighting = false;
		this.targetFlagX = targetX;
		this.targetFlagY = targetY;
		
		return true;
	}
	
}