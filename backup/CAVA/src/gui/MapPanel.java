package gui;

import playable.*;

import objects.*;
import mapinfo.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MapPanel extends JPanel implements ActionListener {
	private Car car;
	private ArrayList<Image> imageInfo;
	private Maps map;
	private Timer timer;
	private final int DELAY = 10;

	public MapPanel(Maps map, Car car, ArrayList<Image> imageInfo) {
		this.car = car;
		this.map = map;
		this.car.setMap(map);
		
		this.imageInfo = imageInfo;
		
		setBackground(Color.WHITE);
		addKeyListener(new TAdapter());
		setFocusable(true);

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(car.getEngine().isBooster()) {
			if (car.getTire().getDx() == 1) 
				car.setImage(new ImageIcon("car_right(booster).png").getImage());
			if (car.getTire().getDx() == -1) 
				car.setImage(new ImageIcon("car_left(booster).png").getImage());
			if (car.getTire().getDy() == -1) 
				car.setImage(new ImageIcon("car_up(booster).png").getImage());
			if (car.getTire().getDy() == 1) 
				car.setImage(new ImageIcon("car_down(booster).png").getImage());
		}
		else {
			if(car.getTire().getDx() == 1)
				car.setImage(new ImageIcon("car_right(normal).png").getImage());
			if(car.getTire().getDx() == -1)
				car.setImage(new ImageIcon("car_left(normal).png").getImage());
			if(car.getTire().getDy() == -1)
				car.setImage(new ImageIcon("car_up(normal).png").getImage());
			if(car.getTire().getDy() == 1)
				car.setImage(new ImageIcon("car_down(normal).png").getImage());
		}
		
		// When the car meets portal
		int x = car.getX();
		int y = car.getY();
		if(car.getMap().getThings()!=null){
			
			ArrayList<Things> deadThings = new ArrayList<Things>();
			for(Things m : car.getMap().getThings()){
				// meets monster
				Monster monster = (Monster)m;
				if(monster.getX()==x && monster.getY() == y){
					int carHP = car.getStatus().getHp().getValue();
					// Booster on
					if(car.getEngine().isBooster()){
						monster.setSurvived(false);
						deadThings.add(monster);
					}
					// Booster off
					else {
						if(carHP-monster.getDamage()<=0){
							JOptionPane.showMessageDialog(null, 
									"Car is broken!","Game Over",
									JOptionPane.WARNING_MESSAGE);
							System.exit(0);
						}
						else{
							car.getStatus().getHp().setValue(carHP-monster.getDamage());
						}
					}
					
				}
			}
			for(Things m : deadThings){
				car.getMap().getThings().remove(m);
			}
		}
		
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
		
		car.getEngine().boostDelayDown(car.getStatus());
		car.getEngine().boostCountDown();
		
		car.move();
		if(map.getThings()!=null){
			for(Things m : map.getThings()){
				Monster monster = (Monster)m;
				monster.move(car);
			}
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
			map.setStage(map.getStage()+1);
			System.out.println("Stage: "+map.getStage());
			map = map.getEast();
			car.setMap(map);
			car.setX(4);
			car.setY(12);
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
		Image wall = null;
		Image back = null;
		Image trap = imageInfo.get(3);
		Image portal=imageInfo.get(4);
		Image wizard=imageInfo.get(5);
		if(map.getStage() == 0){
			wall = imageInfo.get(6);
			back = imageInfo.get(7);
		}
		else if(map.getStage() == 1){
			wall = imageInfo.get(8);
			back = imageInfo.get(9);
		}
		else if(map.getStage() == 2){
			wall = imageInfo.get(10);
			back = imageInfo.get(11);
		}
		Image engine = imageInfo.get(0);
		Image oil = imageInfo.get(12);
		Image kit = imageInfo.get(13);
		
		int tileSize=20;
		
		for(int i=0;i<30;i++){
			for(int j=0;j<25;j++){
				int tileNumber = map.getTile()[j][i];
				
				g2d.drawImage(back, i*tileSize,j*tileSize,20, 20,null);
				if(tileNumber==1){
					g2d.drawImage(wall, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber==2 || tileNumber==3 || tileNumber==4 || tileNumber==5){
					g2d.drawImage(portal, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber == 6){
					g2d.drawImage(wizard, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber == 7){
					g2d.drawImage(engine, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber == 8){
					g2d.drawImage(oil, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber == 9){
					g2d.drawImage(kit, i*tileSize, j*tileSize, 20, 20, null);
				}
				else if(tileNumber == 10){
					g2d.drawImage(trap, i*tileSize, j*tileSize, 20, 20, null);
				}
			}
		}
		
		g2d.drawImage(car.getImage(), car.getX() * 20, car.getY() * 20, 20, 20, null);
		
		if(map.getThings()!=null){
			for(Things m : map.getThings()){
				Monster monster = (Monster)m;
				g2d.drawImage(imageInfo.get(monster.getMap().getStage()),monster.getX()*tileSize,monster.getY()*tileSize,20,20,null);
			}
			
		}
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