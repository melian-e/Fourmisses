package com.fourmisses.fourmies;

public abstract class Pos {

	double x;
	double y;
	
	/////CONSTRUCTOR/////
	public Pos(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	/////METHODS/////
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double dist(Pos obj) {
		
		double A;
		double B;

		A = Math.abs(this.x - obj.x);
		B = Math.abs(this.y - obj.y);

		return Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
	}

	
}
