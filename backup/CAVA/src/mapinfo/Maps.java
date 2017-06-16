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
	private ArrayList<Things> things;
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
	
	public Maps() {}
	public Maps(int stage){
		this.stage = stage;
		things = new ArrayList();
		carCenter = false;
		magician = false;
	}
	
	public int[][] getTile() {
		return tile;
	}
	public void setTile(int[][] tile) {
		this.tile = tile;
	}
	public ArrayList<Things> getThings() {
		return things;
	}
	public void setThings(ArrayList<Things> things) {
		this.things = things;
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
