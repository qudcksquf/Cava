package playable.component;

import playable.Status;

public class AdvancedEngine extends Engine{
	public AdvancedEngine() {
		speed = 5;
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
			speed = 5;
			booster = false;
		}
	}
	
	@Override
	public void hasBooster(Status status) {
		if(boostCount == 0 && boostDelay == 0){
			speed = 3;
			boostCount = 500;
			boostDelay = 800;
			status.getDelayPB().setValue(800);
			booster = true;
		}
	}
}
