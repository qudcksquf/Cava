package playable.component;

public class BasicEngine extends Engine{
	public BasicEngine() {
		boostDuration = 300;
		boostMaxDelay = 1000;
		boostSpeed = 9;
		speed = normalSpeed = 13;
		useOil = 3;
		setBooster(false);
	}
}
