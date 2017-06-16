package playable.component;

import playable.Status;

public class VantageEngine extends Engine{
	public VantageEngine() {
		speed = 9;
		useOil = 2;
		setBooster(false);
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public void boostCountDown(){
		if(boostCount - 1 >= 0)
			boostCount--;
		else {
			speed = 9;
			booster = false;
		}
	}
	
	@Override
	public void hasBooster(Status status) {
		if(boostCount == 0 && boostDelay == 0){
			speed = 6;
			boostCount = 400;
			boostDelay = 900;
			status.getDelayPB().setValue(900);
			booster = true;
		}
	}
}
