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
			int tilenumber=map.getTile()[y][x];
			
			// When the car meets wall
			if(map.getTile()[nextY][nextX]==1) return;
			
			// meets item (engine)
			if(tilenumber==7){
				int stage = map.getStage();
				if(stage==0) {
					setEngine(new VantageEngine());
					status.getDelayPB().setMaximum(900);
					status.getDelayPB().setValue(0);	
				}
				else if(stage==1) {
					setEngine(new AdvancedEngine());
					status.getDelayPB().setMaximum(800);
					status.getDelayPB().setValue(0);	
				}
				map.getTile()[y][x] = 0;
			}
			
			int currentOilGauge = status.getOilgauge().getValue();
			int currentHP = status.getHp().getValue();
			
			// meets oil
			if(tilenumber==8){
				if(currentOilGauge+40>=150)
					status.getOilgauge().setValue(150);
				else
					status.getOilgauge().setValue(currentOilGauge+40);
				map.getTile()[y][x] = 0;
			}
			// meets kit
			else if(tilenumber==9){
				if(currentHP+40>=100)
					status.getHp().setValue(100);
				else
					status.getHp().setValue(currentHP+40);
				map.getTile()[y][x] = 0;
			}
			
			// meets trap
			else if(tilenumber==10){
				if(currentHP-30<=0){
					JOptionPane.showMessageDialog(null, 
							"Car is broken!","Game Over",
							JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
				else
					status.getHp().setValue(currentHP-30);
			}
			
			// oil게이지가 0이 되었을 때 게임 종료
			if(currentOilGauge == 0) {
				JOptionPane.showMessageDialog(null, 
						"The oil has run out!","Game Over",
						JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			currentOilGauge = status.getOilgauge().getValue();
//			status.getOilgauge().setValue(currentOilGauge-1);
			if(x + tire.getDx() >= 0 && x + tire.getDx() < 30) x += tire.getDx();
			if(y + tire.getDy() >= 0 && y + tire.getDy() < 25) y += tire.getDy();
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