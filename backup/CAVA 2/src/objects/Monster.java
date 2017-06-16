package objects;

import mapinfo.Maps;
import playable.Car;
import playable.component.AdvancedEngine;
import playable.component.BasicEngine;
import playable.component.VantageEngine;

abstract public class Monster {
	// 위치 정보
	protected int x;
	protected int y;
	protected int seed;
	protected boolean touched;
	
	protected int dx;
	protected int dy;
	protected int chase; // chase or run.
	protected int speed;
	protected int count;
	protected int damage;
	protected boolean survived;
	protected boolean carBoost;
	protected Maps map = new Maps();
	
	public void moveX(int x) {
		if((map.getTile())[y][this.x+x] != 1)
			this.x += x;
	}

	public void moveY(int y) {
		if((map.getTile())[this.y+y][x] != 1)
			this.y += y;
	}

	// Monster moves
	public void move(Car icar) {
		if(icar.getEngine() instanceof BasicEngine) {
			BasicEngine tmp = (BasicEngine)icar.getEngine();
			if(tmp.isBooster()) carBoost = true;
			else carBoost = false;
		}
		if(icar.getEngine() instanceof VantageEngine) {
			VantageEngine tmp = (VantageEngine)icar.getEngine();
			if(tmp.isBooster()) carBoost = true;
			else carBoost = false;
		}
		if(icar.getEngine() instanceof AdvancedEngine) {
			AdvancedEngine tmp = (AdvancedEngine)icar.getEngine();
			if(tmp.isBooster()) carBoost = true;
			else carBoost = false;
		}
		count++;
		count %= speed;
		if(count != speed - 1) return;
		
		if(carBoost)
			setChase(1);
		else
			setChase(-1);

		setDy(getDy() * getChase() * 0);
		setDx(getDx() * getChase() * 0);
		
		if(icar.getX() < getX())
			setDx(getChase() * 1);
		else if(icar.getX() > getX())
			setDx(getChase() * -1);
		
		if(icar.getY() < getY())
			setDy(getChase() * 1);
		else if(icar.getY() > getY())
			setDy(getChase() * -1);
		
		if(dx != 0 && dy != 0) {
			if(Math.random() <= 0.5)
				moveX(dx);
			else
				moveY(dy);
			return;
		} 
		moveX(getDx());
		moveY(getDy());	
	}

	
	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	public int getSeed() {
		return seed;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
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
	
	public int getChase() {
		return chase;
	}

	public void setChase(int chase) {
		this.chase = chase;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Maps getMap() {
		return map;
	}

	public void setMap(Maps map) {
		this.map = map;
	}

	public boolean isSurvived() {
		return survived;
	}

	public void setSurvived(boolean survived) {
		this.survived = survived;
	}
}
