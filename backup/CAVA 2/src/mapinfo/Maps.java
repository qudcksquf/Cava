package mapinfo;

import objects.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.JFrame;

public class Maps {
	private int stage;
	private int[][] tile;
	private ArrayList<Monster> monsters;
	private ArrayList<Monster> addingMonsters;
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
		addingMonsters = new ArrayList<Monster>();
		carCenter = false;
		magician = false;
	}
	public Maps(int stage){
		this.stage = stage;
		monsters = new ArrayList<Monster>();
		addingMonsters = new ArrayList<Monster>();
		carCenter = false;
		magician = false;
	}
	
	public ArrayList<Monster> getAddingMonsters() {
		return addingMonsters;
	}
	public void setAddingMonsters(ArrayList<Monster> addingMonsters) {
		this.addingMonsters = addingMonsters;
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
