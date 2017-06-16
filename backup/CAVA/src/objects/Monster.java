package objects;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import mapinfo.Maps;
import playable.Car;
import playable.component.*;

public class Monster extends Things{
	private int dx;
	private int dy;
	private int chase; // chase or run.
	private int speed;
	private int count;
	private int damage;
	private boolean survived;
	private boolean carBoost;
	private Maps map = new Maps();
	
	public Monster(){}
	
	public Monster(int speed){
		this.speed = speed;
		count = 0;
		touched = false;
		dx = dy = 0;
		chase = 0;
		carBoost = false;
		survived = true;
	}
	
	public Monster(int x, int y, int speed, int seed, int damage, Maps map) { // 5
		this.x = x;
		this.y = y;
		this.seed = seed;
		this.speed = speed;
		this.setDamage(damage);
		count = 0;
		touched = false;
		dx = dy = 0;
		chase = 0;
		carBoost = false;
		this.setMap(map);
		survived = true;
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

	public int getX() {
		return x;
	}

	public void moveX(int x) {
		if((map.getTile())[y][this.x+x]!=1)
			this.x += x;
	}

	public int getY() {
		return y;
	}

	public void moveY(int y) {
		if((map.getTile())[this.y+y][x]!=1)
		this.y += y;
	}

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

	public int getChase() {
		return chase;
	}

	public void setChase(int chase) {
		this.chase = chase;
	}

	@Override
	void Touched() {
		
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
