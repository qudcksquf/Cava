package playable;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import mapinfo.Maps;

public class Car {
	private int dx;
	private int dy;
	private int x;
	private int y;
	Maps map = new Maps();
	
	private int speed;
	private boolean moving;
	private Image image;
	public Car() {
		x = 0;
		y = 0;
		dx = 0;
		dy = 0;
		speed = 10;
		moving = false;
<<<<<<< HEAD
		image = new ImageIcon("car.jpg").getImage();
	}
	public void move() {
		if(!moving) return;
		if(x + dx >= 0 && x + dx <= 542) x += dx;
		if(y + dy >= 0 && y + dy <= 571) y += dy;
=======
		image = new ImageIcon("car.png").getImage();
	}
	public void move() {
		if(!moving) return;
		
		if(x + dx > 0 && x + dx < 600) x += dx;
		if(y + dy > 0 && y + dy < 500) y += dy;
>>>>>>> fe41512c2bf7eb4f2a7bc415ebda1d6f02350997
	}
	public Image getImage() {
		return image;
	}
	public void setX(int idx) {
		this.x = idx;
	}
	public void setY(int idy) {
		this.y = idy;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	// 遺��뒪�꽣 異붽��븷 �삁�젙
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) dy = 0;
		if(key == KeyEvent.VK_DOWN) dy = 0;
		if(key == KeyEvent.VK_LEFT) dx = 0;
		if(key == KeyEvent.VK_RIGHT) dx = 0;
		if(key == KeyEvent.VK_SPACE) moving = false;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) dy = -speed;
		if(key == KeyEvent.VK_DOWN) dy = speed;
		if(key == KeyEvent.VK_LEFT) dx = -speed;
		if(key == KeyEvent.VK_RIGHT) dx = speed;
		if(key == KeyEvent.VK_SPACE) moving = true;
		
	}
}