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
		double hypo;
		double dist;
		
		if(this.x >= obj.x) {
			A = this.x - obj.x;
		}
		else {
			A = obj.x - this.x;
		}
		
		if(this.y >= obj.y) {
			B = this.y - obj.y;
		}
		else {
			B = obj.y - this.y;
		}
		
		hypo = Math.pow(A, 2) + Math.pow(B, 2);
		dist = Math.sqrt(hypo);
		
		return dist;
	}

	
}
