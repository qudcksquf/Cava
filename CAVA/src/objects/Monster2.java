package objects;

import mapinfo.Maps;

public class Monster2 extends Monster{
	
	public Monster2(int x, int y, int speed, int seed, int damage, Maps map) {
		this.x = x;
		this.y = y;
		this.seed = seed;
		this.speed = speed;
		this.damage = damage;
		count = 0;
		touched = false;
		dx = dy = 0;
		chase = 0;
		carBoost = false;
		this.map = map;
	}
	
	public void shoot() {
		if(dx == 0 && dy == 0) return;
		if(map.getMonsters().size() >= 50) return;
		if(Math.random() < 0.004)
			map.getAddingFireBalls().add(new FireBall(x, y, dx, dy, 5, 15, 5, map));
	}
}