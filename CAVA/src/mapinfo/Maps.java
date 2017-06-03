package mapinfo;

import objects.*;
import java.util.*;

public class Maps {
	private Maps west; // shallow copy
	private Maps east; // ''
	private Maps north; // ''
	private Maps south; // ''
	private boolean carcenter; // deep copy! or null
	private Tooltip tooltip; // deep copy! or null
	private Item item; // deep copy! or null
	private ArrayList<Monster> monster; // deep copy! or null
	private ArrayList<Trap> trap; // deep copy! or null
	public Maps getWest() {
		return west;
	}
	public void setWest(Maps west) {
		this.west = west;
	}
	public Maps getEast() {
		return east;
	}
	public void setEast(Maps east) {
		this.east = east;
	}
	public Maps getNorth() {
		return north;
	}
	public void setNorth(Maps north) {
		this.north = north;
	}
	public Maps getSouth() {
		return south;
	}
	public void setSouth(Maps south) {
		this.south = south;
	}
	public boolean getCarcenter() {
		return carcenter;
	}
	public void setCarcenter(boolean carcenter) {
		this.carcenter = carcenter;
	}
	public Tooltip getTooltip() {
		return tooltip;
	}
	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ArrayList<Monster> getMonster() {
		return monster;
	}
	public void setMonster(ArrayList<Monster> monster) {
		this.monster.monster;
	}
	public ArrayList<Trap> getTrap() {
		return trap;
	}
	public void setTrap(ArrayList<Trap> trap) {
		this.trap = trap;
	}
}
