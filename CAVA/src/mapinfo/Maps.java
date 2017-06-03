package mapinfo;

import objects.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.JFrame;

public class Maps {
<<<<<<< HEAD
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
=======
//	ArrayList<Monster> monster;
//	ArrayList<Trap> trap;
//	Carcenter carcenter;
//	private Maps west; // shallow copy
//	private Maps east; // ''
//	private Maps north; // ''
//	private Maps south; // ''
//	Tooltip tooltip; // deep copy! or null
//	Item item; // deep copy! or null
	public boolean map1 = true;
	public boolean map2 = false;
	
	public int Map[][] = {
			 {0,0,1,0,0,0,0,0,0,0,0,0},
			 {1,0,1,0,0,0,0,0,0,0,0,0},
			 {1,0,1,0,0,0,0,0,0,0,0,0},
			 {1,0,1,0,0,0,0,0,0,0,0,0},
			 {1,0,1,0,0,0,0,0,0,0,0,2},
			 {1,0,1,1,1,1,1,1,1,1,1,0},
			 {1,0,0,0,0,0,0,0,0,0,0,0},
			 {1,1,1,1,1,1,1,1,1,1,1,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public int Map2[][] = {
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {1,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0,0,0,0,0}};
	public int screen_width=600;
	public int screen_height=500;
	public int tile_size=50;
	public int start_tile_x=0;
	public int start_tile_y=0;
	public int end_tile_x= (screen_width)/tile_size;
	public int end_tile_y= (screen_height)/tile_size;
	
	public Image background = Toolkit.getDefaultToolkit().getImage("./image/background1.jpg");
	public Image back_blank = Toolkit.getDefaultToolkit().getImage("./image/back_blank.jpg");
	public Image back_block = Toolkit.getDefaultToolkit().getImage("./image/back_block.jpg");
	public Image item = Toolkit.getDefaultToolkit().getImage("./image/item.jpg");
			
>>>>>>> fe41512c2bf7eb4f2a7bc415ebda1d6f02350997
}
