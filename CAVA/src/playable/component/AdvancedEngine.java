package playable.component;

import playable.Status2;

public class AdvancedEngine extends Engine{
	private int skillDelay;
	public AdvancedEngine() {
		boostDuration = 500;
		boostMaxDelay = 800;
		boostSpeed = 3;
		speed = normalSpeed = 5;
		useOil = 1;
		skillDelay = 0;
		setBooster(false);
	}

	public void skillDelayDown(Status2 status) {
		if(skillDelay - 1 >= 0){
			skillDelay--;
			status.getSkillDelay().setValue(skillDelay);
		}
	}
	
	public void hasSkill(Status2 status, Tire tire) {
		if (skillDelay == 0) {
			int tmp = status.getHp().getValue() + 100;
			if(status.getHp().getMaximum() < tmp) tmp = status.getHp().getMaximum();
			status.getHp().setValue(tmp);
			tire.setTrapped(false);
			tire.setTrapCount(0);
			skillDelay = 2000;
			status.getSkillDelay().setValue(skillDelay);
		}
	}
}
