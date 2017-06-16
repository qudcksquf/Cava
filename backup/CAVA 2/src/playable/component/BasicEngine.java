package playable.component;

import playable.Status;

public class BasicEngine extends Engine{
	public BasicEngine() {
		speed = 13;
		useOil = 3;
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
			speed = 13;
			booster = false;
		}
	}
	
	@Override
	public void hasBooster(Status status) {
		if(boostCount == 0 && boostDelay == 0){
			speed = 9;
			boostCount = 300;
			boostDelay = 1000;
			status.getDelayPB().setValue(1000);
			booster = true;
		}
	}
}
