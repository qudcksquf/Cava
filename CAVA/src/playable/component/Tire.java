package playable.component;

public class Tire {
	private int dx;
	private int dy;
	private int trapCount;
	private boolean trapped;

	public Tire() {
		dx = 1;
		dy = 0;
		trapCount = 0;
		trapped = false;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public void setTrapCount(int trapCount) {
		if(trapCount >= 0) {
			this.trapCount = trapCount;
			if(trapCount == 0) trapped = false;
		}
	}
	
	public void setTrapped(boolean trapped) {
		this.trapped = trapped;
	}
	
	public boolean isTrapped() {
		return trapped;
	}
	
	public void trapDown() {
		if(trapCount > 0)
			trapCount--;
		else
			trapped = false;
	}
	
	public void hasTrap() {
		trapped = true;
		trapCount = 300;
	}
}
