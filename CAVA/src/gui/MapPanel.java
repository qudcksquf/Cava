package gui;

import playable.*;
import objects.*;
import mapinfo.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MapPanel extends JPanel implements ActionListener {
	private Car car;
	private Maps map = new Maps();
	private Timer timer;
	private final int DELAY = 20;

	public MapPanel(Maps map, Car car) {
		this.car = car;
		this.map = map;
	}

	public MapPanel() {
		setBackground(Color.WHITE);
		addKeyListener(new TAdapter());
		setFocusable(true);

		car = new Car();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		car.move();
		
		repaint();
		
	}

	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(600,500);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		

		if(map.map1 == true) {
			if(map.Map[car.getY()/map.tile_size][car.getX()/map.tile_size] == 2) {
				map.map1 = !map.map1; 
				map.map2 = !map.map2;
				car.setX(51);
			}
		int i, j;
		int tx, ty;
		ty = map.start_tile_y;
		for (i = map.start_tile_y; i < map.end_tile_y; i++) {
			tx = map.start_tile_x;
			for (j = map.start_tile_x; j < map.end_tile_x; j++) {
				if (map.Map[i][j] == 1)
					g2d.drawImage(map.back_block, tx, ty, tx+map.tile_size, ty+map.tile_size, null);
				else if (map.Map[i][j] == 2)
					g2d.drawImage(map.item, tx, ty, tx+map.tile_size, ty+map.tile_size, null);
				else if (map.Map[i][j] == 0)
					g2d.drawImage(map.back_blank, tx, ty, tx+map.tile_size, ty+map.tile_size, null);

				tx += map.tile_size;
			}
			ty += map.tile_size;
		}
		
		g2d.drawImage(car.getImage(), car.getX(), car.getY(), 50, 50, null);
	}
		else if(map.map2 == true) {
			if(map.Map2[car.getY()/map.tile_size][car.getX()/map.tile_size] == 1) {
				map.map1 = !map.map1; 
				map.map2 = !map.map2;
				car.setX(549);
			}
			int i, j;
			int tx, ty;
			ty = map.start_tile_y;
			for (i = map.start_tile_y; i < map.end_tile_y; i++) {
				tx = map.start_tile_x;
				for (j = map.start_tile_x; j < map.end_tile_x; j++) {
					if (map.Map2[i][j] == 1)
						g2d.drawImage(map.back_block, tx, ty, tx+map.tile_size, ty+map.tile_size, null);
					else if (map.Map2[i][j] == 2)
						g2d.drawImage(map.item, tx, ty, tx+map.tile_size, ty+map.tile_size, null);
					else if (map.Map2[i][j] == 0)
						g2d.drawImage(map.back_blank, tx, ty, tx+map.tile_size, ty+map.tile_size, null);

					tx += map.tile_size;
				}
				ty += map.tile_size;
			}
			
			g2d.drawImage(car.getImage(), car.getX(), car.getY(), 50, 50, null);
		}
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