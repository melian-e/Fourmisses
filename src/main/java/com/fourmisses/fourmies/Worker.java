package com.fourmisses.fourmies;

public class Worker extends Ant{
	
	int stock;
	
	/////CONSTRUCTOR/////
	public Worker(double x, double y, int speedX, int speedY, Boolean onTrack, int id, int health, int food) {
		super(x, y, speedX, speedY, onTrack, id, health, food);
		this.stock = stock;
	}

	
	Boolean gather(Food Food) {
		this.stock += Food.decrease();
		
		this.returnToTrack();
		
		return true;
	}
	
	int dropFood(Colony Colony) {
		int tmp = this.stock;
		this.stock = 0;
		
		return tmp;
	}
}
