package main;

import mapinfo.*;

import gui.*;
import objects.*;
import playable.*;
import playable.component.*;

import javax.swing.*;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Field extends JPanel{
	private MapPanel mappanel; // stage GUI
	
	private Car usercar;

	private ArrayList<ArrayList<Maps>> stage;
	private ArrayList<Things> things;

	private ArrayList<Image> imageInfo;

	private void init() {
		usercar = new Car();

		// Set Maps
		stage = new ArrayList<ArrayList<Maps>>();
		for (int i = 0; i < 3; i++) {
			stage.add(new ArrayList<Maps>());
			for (int j = 0; j < 5; j++)
				stage.get(i).add(new Maps(i));
		}
		Tiles tileInfo = new Tiles();

		try {
			FileInputStream fis = new FileInputStream("Tiles.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob = ois.readObject();
			tileInfo = (Tiles) ob;
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Set maptiles
		stage.get(0).get(0).setTile(tileInfo.getMapOne_1());
		stage.get(0).get(1).setTile(tileInfo.getMapOne_2());
		stage.get(0).get(2).setTile(tileInfo.getMapOne_3());
		stage.get(0).get(3).setTile(tileInfo.getMapOne_4());
		stage.get(0).get(4).setTile(tileInfo.getMapOne_5());

		stage.get(1).get(0).setTile(tileInfo.getMapTwo_1());
		stage.get(1).get(1).setTile(tileInfo.getMapTwo_2());
		stage.get(1).get(2).setTile(tileInfo.getMapTwo_3());
		stage.get(1).get(3).setTile(tileInfo.getMapTwo_4());
		stage.get(1).get(4).setTile(tileInfo.getMapTwo_5());

		stage.get(2).get(0).setTile(tileInfo.getMapThree_1());
		stage.get(2).get(1).setTile(tileInfo.getMapThree_2());
		stage.get(2).get(2).setTile(tileInfo.getMapThree_3());
		stage.get(2).get(3).setTile(tileInfo.getMapThree_4());
		stage.get(2).get(4).setTile(tileInfo.getMapThree_5());

		// Set Maps pointer
		for (int i = 0; i < 3; i++) {
			stage.get(i).get(0).setSouth(stage.get(i).get(2));

			stage.get(i).get(1).setEast(stage.get(i).get(2));

			stage.get(i).get(2).setNorth(stage.get(i).get(0));
			stage.get(i).get(2).setWest(stage.get(i).get(1));
			stage.get(i).get(2).setEast(stage.get(i).get(3));
			stage.get(i).get(2).setSouth(stage.get(i).get(4));

			stage.get(i).get(3).setWest(stage.get(i).get(2));

			stage.get(i).get(4).setNorth(stage.get(i).get(2));
		}
		stage.get(0).get(3).setEast(stage.get(1).get(1));
		stage.get(1).get(3).setEast(stage.get(2).get(1));
		// 맵정보(맵에 있는 아이템이나 몬스터나 트랩) 설계되면 여기 아래에 추가로 초기화 해주어야 함
		
		// Monsters for each maps
		//public Monster(int x, int y, int speed, int seed, int damage, Maps map)
		stage.get(1).get(0).getThings().add(new Monster(2,2,20,5,1,stage.get(1).get(0)));
		stage.get(1).get(0).getThings().add(new Monster(27,2,20,5,1,stage.get(1).get(0)));
		stage.get(1).get(1).getThings().add(new Monster(27,22,20,5,1,stage.get(1).get(1)));
		stage.get(1).get(1).getThings().add(new Monster(27,2,20,5,1,stage.get(1).get(1)));
		stage.get(1).get(3).getThings().add(new Monster(27,22,20,5,1,stage.get(1).get(3)));
		stage.get(1).get(3).getThings().add(new Monster(27,2,20,5,1,stage.get(1).get(3)));
		stage.get(1).get(4).getThings().add(new Monster(2,22,20,5,1,stage.get(1).get(4)));
		stage.get(1).get(4).getThings().add(new Monster(27,22,20,5,1,stage.get(1).get(4)));
		
		stage.get(2).get(0).getThings().add(new Monster(2,2,15,6,2,stage.get(2).get(0)));
		stage.get(2).get(0).getThings().add(new Monster(27,2,15,6,2,stage.get(2).get(0)));
		stage.get(2).get(1).getThings().add(new Monster(27,22,15,6,2,stage.get(2).get(1)));
		stage.get(2).get(1).getThings().add(new Monster(27,2,15,6,2,stage.get(2).get(1)));
		stage.get(2).get(3).getThings().add(new Monster(27,22,15,6,2,stage.get(2).get(3)));
		stage.get(2).get(3).getThings().add(new Monster(27,2,15,6,2,stage.get(2).get(3)));
		stage.get(2).get(4).getThings().add(new Monster(2,22,15,6,2,stage.get(2).get(4)));
		stage.get(2).get(4).getThings().add(new Monster(27,22,10,5,40,stage.get(2).get(4)));
		
		// things
		things = new ArrayList<Things>();
		// 0 ~ 4 Item
		things.add(new Tire());
		things.add(new BasicEngine());
		things.add(new VantageEngine());
		things.add(new AdvancedEngine());
		// 5 ~ 6 Monster
		things.add(new Monster(15));
		things.add(new Monster(13));
		// 7 Trap
		things.add(new Trap());

		// imageInfo
		imageInfo = new ArrayList<Image>();
		// 0 item image in the map
		imageInfo.add(new ImageIcon("item.png").getImage());
		// 1 ~ 2 monster image
		imageInfo.add(new ImageIcon("monster1.png").getImage());
		imageInfo.add(new ImageIcon("monster2.png").getImage());
		// 3 trap image
		imageInfo.add(new ImageIcon("trap.png").getImage());
		// 4 portal image
		imageInfo.add(new ImageIcon("portal.png").getImage());
		// 5 wizard image
		imageInfo.add(new ImageIcon("wizard.png").getImage());
		// 6 ~ 11 map tile image for each stage
		imageInfo.add(new ImageIcon("wall_0.png").getImage());
		imageInfo.add(new ImageIcon("back_0.png").getImage());
		imageInfo.add(new ImageIcon("wall_1.png").getImage());
		imageInfo.add(new ImageIcon("back_1.png").getImage());
		imageInfo.add(new ImageIcon("wall_2.png").getImage());
		imageInfo.add(new ImageIcon("back_2.png").getImage());
		// 11, 12 Oil, Kit image
		imageInfo.add(new ImageIcon("oil.png").getImage());
		imageInfo.add(new ImageIcon("kit.png").getImage());
		
	}

	public Field() {
		init();
		setMappanel(new MapPanel(stage.get(0).get(1), usercar, imageInfo));
	}

	public static void main(String[] args) {
		Field frame = new Field();
	}

	public MapPanel getMappanel() {
		return mappanel;
	}

	public void setMappanel(MapPanel mappanel) {
		this.mappanel = mappanel;
	}
}