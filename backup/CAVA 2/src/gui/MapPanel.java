package gui;

import playable.*;
import objects.*;
import mapinfo.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import main.Music;

public class MapPanel extends JPanel implements ActionListener {
	private Car car;
	private ArrayList<Image> imageInfo;
	private Image[] carImage;
	private Image[] blockImage;
	private Maps map;
	private Timer timer;
	private final int DELAY = 10;
	private final int tileSize=20;

	public MapPanel(Maps map, Car car, ArrayList<Image> imageInfo) {
		this.car = car;
		this.map = map;
		this.car.setMap(map);
		
		carImage = new Image[8];
		String[] arr = {"right", "left", "up", "down"};
		for(int i=0;i<4;i++) {
			carImage[i] = new ImageIcon("car_" + arr[i] + "(normal).png").getImage();
			carImage[i+4] = new ImageIcon("car_" + arr[i] + "(booster).png").getImage();
		}
		
		blockImage = new Image[8];

		blockImage[0] = imageInfo.get(8); // background
		blockImage[1] = imageInfo.get(7); // wall
		
		blockImage[2] = imageInfo.get(5); // portal
		blockImage[3] = imageInfo.get(6); // wizard
		blockImage[4] = imageInfo.get(0); // engine or item
		blockImage[5] = imageInfo.get(13); // oil
		blockImage[6] = imageInfo.get(14); // kit
		blockImage[7] = imageInfo.get(4); // trap
		
		this.imageInfo = imageInfo;
		
		setBackground(Color.WHITE);
		addKeyListener(new TAdapter());
		setFocusable(true);

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		car.getEngine().boostDelayDown(car.getStatus());
		car.getEngine().boostCountDown();
		
		car.move();

		if(car.getEngine().isBooster()) {
			if (car.getTire().getDx() == 1) 
				car.setImage(carImage[4]);
			if (car.getTire().getDx() == -1) 
				car.setImage(carImage[5]);
			if (car.getTire().getDy() == -1) 
				car.setImage(carImage[6]);
			if (car.getTire().getDy() == 1) 
				car.setImage(carImage[7]);
		}
		else {
			if(car.getTire().getDx() == 1)
				car.setImage(carImage[0]);
			if(car.getTire().getDx() == -1)
				car.setImage(carImage[1]);
			if(car.getTire().getDy() == -1)
				car.setImage(carImage[2]);
			if(car.getTire().getDy() == 1)
				car.setImage(carImage[3]);
		}
		
		int x = car.getX();
		int y = car.getY();
		if(car.getMap().getMonsters()!=null){
			ArrayList<Monster> deadThings = new ArrayList<Monster>();
			for(Monster m : car.getMap().getMonsters()){
				// meets monster
				if(m.getX()==x && m.getY() == y){
					int carHP = car.getStatus().getHp().getValue();
					// Booster on
					if(car.getEngine().isBooster()){
						m.setSurvived(false);
						deadThings.add(m);
						continue;
					}
					// Booster off
					else {
						if(carHP - m.getDamage()<=0){
							car.getStatus().getHp().setValue(0);
							JOptionPane.showMessageDialog(null, 
									"Car is broken!","Game Over",
									JOptionPane.WARNING_MESSAGE);
							System.exit(0);
						}
						else{
							car.getStatus().getHp().setValue(carHP - m.getDamage());
						}
					}
				}
				
				// monster moving, special action
				m.move(car);
				if(m instanceof Monster1) {
					((Monster1)m).boostCountDown();
					((Monster1)m).boostDelayDown();
					((Monster1)m).hasBooster();
				}
				if(m instanceof Monster2) {
					((Monster2)m).shoot();
				}
				if(m instanceof FireBall) {
					if((map.getTile())[m.getY() + m.getDy()][m.getX() +m.getDx()] == 1) {
						m.setSurvived(false);
						deadThings.add(m);
					}
				}
			}
			for(Monster m : deadThings){
				car.getMap().getMonsters().remove(m);
			}
			for(Monster m : map.getAddingMonsters()) {
				map.getMonsters().add(m);
			}
			map.getAddingMonsters().clear();
		}

		// When the car meets portal
		if(map.getTile()[y][x] == 2) {
			map = map.getNorth();	
			car.setMap(map);
			car.setX(15);
			car.setY(20);
		}
		else if(map.getTile()[y][x]==3){
			map = map.getSouth();
			car.setMap(map);
			car.setX(15);
			car.setY(4);
		}
		else if(map.getTile()[y][x]==4){
			map = map.getWest();
			car.setMap(map);
			car.setX(25);
			car.setY(12);
		}
		else if(map.getTile()[y][x]==5){
			map = map.getEast();
			car.setMap(map);
			car.setX(4);
			car.setY(12);
		}
		
		// When the car meets wizard
		if(map.getTile()[y][x]==6){
			//event
			
			if(map.getStage()==2) {
				JOptionPane.showMessageDialog(MapPanel.this, 
						"Finished","Congratulation!",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			
			// move to the next stage
			Music.changeBGM(map.getStage() + 1);
			
			map.setStage(map.getStage() + 1);
			map = map.getEast();
			car.setMap(map);
			car.setX(4);
			car.setY(12);
			
			blockImage[0] = imageInfo.get(8 + map.getStage() * 2); // background
			blockImage[1] = imageInfo.get(7 + map.getStage() * 2); // wall
		}
		
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0;i<30;i++){
			for(int j=0;j<25;j++){
				int tileNumber = map.getTile()[j][i];
				
				g2d.drawImage(blockImage[0], i*tileSize, j*tileSize, tileSize, tileSize, null);
				if(tileNumber > 10) continue; 
				if(tileNumber == 1) g2d.drawImage(blockImage[1], i*tileSize, j*tileSize, tileSize, tileSize, null);
				else if(tileNumber >= 2 && tileNumber <= 5) g2d.drawImage(blockImage[2], i*tileSize, j*tileSize, tileSize, tileSize, null);
				else if(tileNumber >= 6) g2d.drawImage(blockImage[tileNumber - 3], i*tileSize, j*tileSize, tileSize, tileSize, null);
			}
		}
		
		if(map.getMonsters()!=null){
			for(Monster m : map.getMonsters()){
				g2d.drawImage(imageInfo.get(m.getSeed()),m.getX()*tileSize,m.getY()*tileSize,20,20,null);
			}
		}
		
		g2d.drawImage(car.getImage(), car.getX() * 20, car.getY() * 20, 20, 20, null);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			car.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			car.keyPressed(e);
		}
	}
}