package playable.component;

import playable.Status2;

public class VantageEngine extends Engine{
	private int skillDelay;
	public VantageEngine() {
		boostDuration = 400;
		boostMaxDelay = 900;
		boostSpeed = 6;
		speed = normalSpeed = 9;
		useOil = 2;
		skillDelay = 0;
		setBooster(false);
	}
	
	public void skillDelayDown(Status2 status) {
		if(skillDelay - 1 >= 0){
			skillDelay--;
			status.getSkillDelay().setValue(skillDelay);
		}
	}
	
	public void hasSkill(Status2 status) {
		if (skillDelay == 0) {
			int tmp = status.getHp().getValue() + 100;
			if(status.getHp().getMaximum() < tmp) tmp = status.getHp().getMaximum();
			status.getHp().setValue(tmp);
			skillDelay = 3000;
			status.getSkillDelay().setValue(skillDelay);
		}
	}
}
