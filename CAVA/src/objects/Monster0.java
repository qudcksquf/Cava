package objects;

import mapinfo.Maps;

public class Monster0 extends Monster{
	
	public Monster0(int x, int y, int speed, int seed, int damage, Maps map) {
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
}
