package com.fourmisses.fourmies;

public class Food extends Obstacle{

	int stock;
	int decreaseValue = 20;
	
	public Food(double x, double y, int stock) {
		super(x, y);
		this.stock = stock;
		// TODO Auto-generated constructor stub
	}
	
	public int decrease() {
		stock -= decreaseValue;
		return decreaseValue;
	}

	public int getStock() {
		return stock;
	}
}
