package gui;

import playable.*;
import objects.*;
import mapinfo.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class MapPanel extends JPanel implements ActionListener{
	private Car car;
	private Maps map;
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
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);

        //Toolkit.getDefaultToolkit().sync();
    }
	
	private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(car.getImage(), car.getX(), car.getY(), 40, 20, this);        
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