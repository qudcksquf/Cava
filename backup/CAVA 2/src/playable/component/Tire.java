package playable.component;

import objects.*;

public class Tire{
	private int dx;
	private int dy;
	public Tire() {
		dx = 1;
		dy = 0;
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
}
