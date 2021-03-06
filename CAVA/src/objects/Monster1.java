package objects;

import mapinfo.Maps;

public class Monster1 extends Monster{
	private int initSpeed;
	
	public Monster1(int x, int y, int speed, int seed, int damage, Maps map) {
		this.x = x;
		this.y = y;
		this.seed = seed;
		this.speed = speed;
		this.initSpeed = speed;
		this.damage = damage;
		count = 0;
		touched = false;
		dx = dy = 0;
		chase = 0;
		carBoost = false;
		this.map = map;
		boostCount = 0;
		boostDelay = 900;
	}
	
	private int boostCount;
	private int boostDelay;
	private boolean moving;
	public void countUp() {
		count++;
		count %= speed;
	}

	public boolean getMove() {
		if(!moving) {
			count = 0;
			return false;
		}
		countUp();
		if(count == speed - 1) return true;
		else return false;
	}
	
	public void boostCountDown(){
		if(boostCount - 1 >= 0)
			boostCount--;
		else
			speed = initSpeed;
	}
	public void boostDelayDown(){
		if(boostDelay - 1 >=0)
			boostDelay--;
	}
	
	public void hasBooster() {
		if(boostDelay == 0 && boostCount == 0) {
			boostCount = 200;
			boostDelay = 900;
			speed = 12;
		}
	}

}