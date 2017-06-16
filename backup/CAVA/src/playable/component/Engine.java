package playable.component;

import objects.*;
import playable.*;

public abstract class Engine extends Item{
	protected int count;
	protected int boostCount;
	protected int boostDelay;
	protected int speed;
	protected boolean moving;
	protected boolean booster = false;
		
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
	
	//getter setter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public boolean isBooster() {
		return booster;
	}

	public void setBooster(boolean booster) {
		this.booster = booster;
	}
	
	
	public void boostCountDown(){
		if(boostCount - 1 >= 0)
			boostCount--;
	}
	public void boostDelayDown(Status status){
		if(boostDelay - 1 >=0){
			boostDelay--;
			status.getDelayPB().setValue(boostDelay);
		}
	}
	
	abstract public void hasBooster(Status status);
}
