package com.fourmisses.fourmies;

public abstract class Vector extends Pos{

	double vecX;
	double vecY;
	
	/////CONSTRUCTOR/////
	public Vector(double x, double y, double vecX, double vecY) {
		super(x, y);
		this.vecX = vecX;
		this.vecY = vecY;
	}
	
	/////METHODS/////
	public double getVecX() {
		return vecX;
	}
	public void setVecX(double vecX) {
		this.vecX = vecX;
	}
	public double getVecY() {
		return vecY;
	}
	public void setVecY(double vecY) {
		this.vecY = vecY;
	}
	
	
}
