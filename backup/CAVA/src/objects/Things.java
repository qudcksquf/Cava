package objects;

abstract public class Things {
	// 위치 정보
	protected int x;
	protected int y;
	protected int seed;
	protected boolean touched;
	
	abstract void Touched();
	
	public void setSeed() {
		this.seed = seed;
	}
	public int getSeed() {
		return seed;
	}
	public void setX() {
		this.x = x;
	}
	public void setY() {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setTouched(boolean touched) {
		this.touched = touched;
	}
	public boolean isTouched() {
		return touched;
	}
}
