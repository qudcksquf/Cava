package playable.component;

import main.Music;
import playable.*;

public abstract class Engine{
	protected int count;
	protected int boostCount;
	protected int boostDelay;
	protected int boostMaxDelay;
	protected int boostDuration;
	protected int boostSpeed;
	protected int normalSpeed;
	protected int speed;
	protected int useOil;
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
	public int getUseOil() {
		return useOil;
	}
	public void setUseOil(int useOil) {
		this.useOil = useOil;
	}
	
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
		else {
			speed = normalSpeed;
			booster = false;
		}
	}
	public void boostDelayDown(Status2 status){
		if(boostDelay - 1 >=0){
			boostDelay--;
			status.getDelayPB().setValue(boostDelay);
		}
	}

	public void hasBooster(Status2 status) {
		if(boostCount == 0 && boostDelay == 0){
			speed = boostSpeed;
			boostCount = boostDuration;
			boostDelay = boostMaxDelay;
			Music.boost();
			status.getDelayPB().setValue(boostMaxDelay);
			booster = true;
		}
	}
}
