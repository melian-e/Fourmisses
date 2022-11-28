package com.fourmisses.fourmies;

public class Explorer extends Ant{

	Boolean isMoving = false;

	public Explorer(double x, double y, double speedX, double speedY, Boolean onTrack, int id, int health, int food) {
		super(x, y, speedX, speedY, onTrack, id, health, food);
		// TODO Auto-generated constructor stub
	}

	Boolean getMoving() {
		return isMoving;
	}
	void goTo(double x, double y) {
		this.isMoving = true;
	}
}
