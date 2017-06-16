package mapinfo;

import objects.*;

import java.util.*;

public class Maps {
	private int stage;
	private int[][] tile;
	private ArrayList<Monster> monsters;
	private ArrayList<FireBall> addingFireBalls;
	private boolean carCenter;
	private boolean magician;
	private Maps east;
	private Maps west;
	private Maps south;
	private Maps north;
	
	public Maps getEast() {
		return east;
	}
	public void setEast(Maps east) {
		this.east = east;
	}
	public Maps getWest() {
		return west;
	}
	public void setWest(Maps west) {
		this.west = west;
	}
	public Maps getSouth() {
		return south;
	}
	public void setSouth(Maps south) {
		this.south = south;
	}
	public Maps getNorth() {
		return north;
	}
	public void setNorth(Maps north) {
		this.north = north;
	}
	
	public Maps() {
		monsters = new ArrayList<Monster>();
		addingFireBalls = new ArrayList<FireBall>();
		carCenter = false;
		magician = false;
	}
	public Maps(int stage){
		this.stage = stage;
		monsters = new ArrayList<Monster>();
		addingFireBalls = new ArrayList<FireBall>();
		carCenter = false;
		magician = false;
	}
	
	public ArrayList<FireBall> getAddingFireBalls() {
		return addingFireBalls;
	}
	public void setAddingFireBalls(ArrayList<FireBall> addingFireBalls) {
		this.addingFireBalls = addingFireBalls;
	}
	
	public int[][] getTile() {
		return tile;
	}
	public void setTile(int[][] tile) {
		this.tile = tile;
	}
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
	public boolean isCarCenter() {
		return carCenter;
	}
	public void setCarCenter(boolean carCenter) {
		this.carCenter = carCenter;
	}
	public boolean isMagician() {
		return magician;
	}
	public void setMagician(boolean magician) {
		this.magician = magician;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
}
