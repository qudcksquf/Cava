package playable;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Car {
	private int dx;
	private int dy;
	private int x;
	private int y;
	private int speed;
	private boolean moving;
	private Image image;
	public Car() {
		x = 200;
		y = 200;
		dx = 0;
		dy = 0;
		speed = 7;
		moving = false;
		image = new ImageIcon("images.jpg").getImage();
	}
	public void move() {
		if(!moving) return;
		if(x + dx >= 0 && x + dx <= 960) x += dx;
		if(y + dy >= 0 && y + dy <= 980) y += dy;
	}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	// 부스터 추가할 예정
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