package playable;

import java.awt.Image;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mapinfo.Maps;
import playable.component.*;

public class Car {
	private Engine engine;
	private Tire tire;
	private int x;
	private int y;
	private Maps map = new Maps();
	ArrayList<Integer> hasItem; //use seed
	
	private Image image;
	
	private Status status;
	private Inventory inventory;
	
	public Car() {
		x = 2;
		y = 2;
		hasItem = new ArrayList<Integer>(20);
		engine = new BasicEngine();
		tire = new Tire();
		image = new ImageIcon("car_right(normal).png").getImage();
		status = new Status();
		inventory = new Inventory();
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Image getImage() {
		return image;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Integer getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Integer getY() {
		return y;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Tire getTire() {
		return tire;
	}
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	public ArrayList<Integer> getHasItem() {
		return hasItem;
	}
	public void setHasItem(ArrayList<Integer> hasItem) {
		this.hasItem = hasItem;
	}
	
	public void move() {
		if(engine.getMove()) {
			int nextX = x + tire.getDx();
			int nextY = y + tire.getDy();
			int tileNumber=map.getTile()[nextY][nextX];
			
			// When the car meets wall
			if(tileNumber == 1) return;
			
			
			int currentOilGauge = status.getOilgauge().getValue();
			int currentHP = status.getHp().getValue();
			// meets oil
			if(tileNumber==8){
				if(currentOilGauge+120>=status.getOilgauge().getMaximum())
					status.getOilgauge().setValue(status.getOilgauge().getMaximum());
				else
					status.getOilgauge().setValue(currentOilGauge+120);
				map.getTile()[nextY][nextX] = 0;
			}
			
			// meets kit
			else if(tileNumber==9){
				if(currentHP+50>=status.getHp().getMaximum())
					status.getHp().setValue(status.getHp().getMaximum());
				else
					status.getHp().setValue(currentHP+50);
				map.getTile()[nextY][nextX] = 0;
			}
			
			// meets trap
			else if(tileNumber==10){
				if(currentHP-30<=0){
					JOptionPane.showMessageDialog(null, 
							"Car is broken!","Game Over",
							JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
				else
					status.getHp().setValue(currentHP-30);
			}
			
			// When oilgauge is 0, game over
			if(currentOilGauge == 0) {
				JOptionPane.showMessageDialog(null, 
						"The oil has run out!","Game Over",
						JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			
			currentOilGauge = status.getOilgauge().getValue();
			status.getOilgauge().setValue(currentOilGauge-engine.getUseOil());

			// meets item (engine)
			if(tileNumber==7){
				int stage = map.getStage();
				if(stage==0) {
					Engine tmp = engine;
					setEngine(new VantageEngine());
					if(tmp.isMoving()) engine.setMoving(true);
					
					status.getDelayPB().setMaximum(900);
					status.getDelayPB().setValue(0);	
				}
				else if(stage==1) {
					Engine tmp = engine;
					setEngine(new AdvancedEngine());
					if(tmp.isMoving()) engine.setMoving(true);
					
					status.getDelayPB().setMaximum(800);
					status.getDelayPB().setValue(0);	
				}
				map.getTile()[nextY][nextX] = 0;
			}
			
			x += tire.getDx();
			y += tire.getDy();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) engine.setMoving(false);
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			tire.setDx(0);
			tire.setDy(-1);
		}
		if(key == KeyEvent.VK_DOWN) {
			tire.setDx(0);
			tire.setDy(1);
		}
		if(key == KeyEvent.VK_LEFT) {
			tire.setDx(-1);
			tire.setDy(0);
		}
		if(key == KeyEvent.VK_RIGHT) {
			tire.setDx(1);
			tire.setDy(0);
		}
		if(key == KeyEvent.VK_SPACE) {
			engine.setMoving(true);
		}
		if(key == KeyEvent.VK_CONTROL){
			engine.hasBooster(status);
		}
	}
	public Maps getMap() {
		return map;
	}
	public void setMap(Maps map) {
		this.map = map;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}