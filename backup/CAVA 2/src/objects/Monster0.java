package objects;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import mapinfo.Maps;
import playable.Car;
import playable.component.*;

public class Monster0 extends Monster{
	
	public Monster0(int x, int y, int speed, int seed, int damage, Maps map) { // 5
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
		survived = true;
	}
}
