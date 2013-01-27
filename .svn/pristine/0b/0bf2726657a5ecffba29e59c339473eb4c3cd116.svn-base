package com.secretBox.yutnori.logic;

public class Yut {
	enum FRONTBACK
	{
		FRONT,BACK
	};
	
	public boolean bBackDo; 
	public int ID;
	private double frontBackThreshold=0.6;
	
	public Yut(int yutID)
	{
		bBackDo=false;
		ID=yutID;
	}
	public FRONTBACK throwYut()
	{
		if(Math.random()< frontBackThreshold)
			return FRONTBACK.BACK;
		else
			return FRONTBACK.FRONT;
	}
	
}
