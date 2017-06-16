package objects;

import playable.Car;
import mapinfo.Maps;

public class FireBall extends Monster{
	public FireBall(int x, int y, int dx, int dy, int speed, int seed, int damage, Maps map) { // 5
		this.x = x;
		this.y = y;
		this.seed = seed;
		this.speed = speed;
		this.damage = damage;
		count = 0;
		touched = false;
		this.dx = dx;
		this.dy = dy;
		if(this.dx != 0 && this.dy != 0) {
			if(Math.random() < 0.5) this.dy = 0;
			else this.dx = 0;
		}
		chase = 0;
		carBoost = false;
		this.map = map;
		survived = true;
	}
	public void move(Car icar) {
		count++;
		count %= speed;
		if(count != speed - 1) return;
		
		moveX(dx);
		moveY(dy);
	}
}
