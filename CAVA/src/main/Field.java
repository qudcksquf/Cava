package main;

import mapinfo.*;

import gui.*;
import objects.*;
import playable.*;

import javax.swing.*;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Field extends JPanel {
	private MapPanel mappanel; // stage GUI

	private Car usercar;

	private ArrayList<ArrayList<Maps>> stage;
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
			System.out.println("File for tile has not found!");
		} catch (ClassNotFoundException e) {
			System.out.println("Tile class has not found!");
		} catch (IOException e) {
			System.out.println("IOexception for tile data!");
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
		// public Monster(int x, int y, int speed, int seed, int damage, Maps
		// map)
		stage.get(0).get(0).getMonsters().add(new Monster0(2, 2, 20, 1, 1, stage.get(0).get(0)));
		stage.get(0).get(0).getMonsters().add(new Monster0(27, 2, 20, 1, 1, stage.get(0).get(0)));
		stage.get(0).get(3).getMonsters().add(new Monster0(27, 22, 20, 1, 1, stage.get(0).get(3)));
		stage.get(0).get(3).getMonsters().add(new Monster0(27, 2, 20, 1, 1, stage.get(0).get(3)));
		stage.get(0).get(4).getMonsters().add(new Monster0(2, 22, 20, 1, 1, stage.get(0).get(4)));
		stage.get(0).get(4).getMonsters().add(new Monster0(27, 22, 20, 1, 1, stage.get(0).get(4)));

		// stage 1 monster
		stage.get(1).get(0).getMonsters().add(new Monster1(2, 2, 22, 2, 2, stage.get(1).get(0)));
		stage.get(1).get(0).getMonsters().add(new Monster1(27, 2, 22, 2, 2, stage.get(1).get(0)));
		stage.get(1).get(0).getMonsters().add(new Monster1(15, 15, 22, 2, 2, stage.get(1).get(0)));
		stage.get(1).get(1).getMonsters().add(new Monster1(27, 22, 22, 2, 2, stage.get(1).get(1)));
		stage.get(1).get(1).getMonsters().add(new Monster1(27, 2, 22, 2, 2, stage.get(1).get(1)));
		stage.get(1).get(1).getMonsters().add(new Monster1(2, 22, 22, 2, 2, stage.get(1).get(1)));
		stage.get(1).get(1).getMonsters().add(new Monster1(13, 10, 22, 2, 2, stage.get(1).get(1)));
		stage.get(1).get(1).getMonsters().add(new Monster1(13, 15, 22, 2, 2, stage.get(1).get(1)));
		stage.get(1).get(3).getMonsters().add(new Monster1(27, 22, 22, 2, 2, stage.get(1).get(3)));
		stage.get(1).get(3).getMonsters().add(new Monster1(27, 2, 22, 2, 2, stage.get(1).get(3)));
		stage.get(1).get(3).getMonsters().add(new Monster1(9, 11, 22, 2, 2, stage.get(1).get(3)));
		stage.get(1).get(3).getMonsters().add(new Monster1(13, 11, 22, 2, 2, stage.get(1).get(3)));
		stage.get(1).get(4).getMonsters().add(new Monster1(2, 22, 22, 2, 2, stage.get(1).get(4)));
		stage.get(1).get(4).getMonsters().add(new Monster1(27, 22, 22, 2, 2, stage.get(1).get(4)));
		stage.get(1).get(4).getMonsters().add(new Monster1(2, 2, 22, 2, 2, stage.get(1).get(4)));
		stage.get(1).get(4).getMonsters().add(new Monster1(27, 2, 22, 2, 2, stage.get(1).get(4)));
		stage.get(1).get(4).getMonsters().add(new Monster1(10, 8, 22, 2, 2, stage.get(1).get(4)));
		stage.get(1).get(4).getMonsters().add(new Monster1(20, 16, 22, 2, 2, stage.get(1).get(4)));

		// stage 2 monster
		stage.get(2).get(0).getMonsters().add(new Monster2(2, 2, 15, 3, 3, stage.get(2).get(0)));
		stage.get(2).get(0).getMonsters().add(new Monster2(27, 2, 15, 3, 3, stage.get(2).get(0)));
		stage.get(2).get(0).getMonsters().add(new Monster2(25, 10, 15, 3, 3, stage.get(2).get(0)));
		stage.get(2).get(0).getMonsters().add(new Monster2(15, 11, 15, 3, 3, stage.get(2).get(0)));
		stage.get(2).get(0).getMonsters().add(new Monster2(14, 18, 15, 3, 3, stage.get(2).get(0)));
		stage.get(2).get(1).getMonsters().add(new Monster2(27, 22, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(27, 2, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(2, 22, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(18, 14, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(1, 7, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(4, 4, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(1).getMonsters().add(new Monster2(26, 15, 15, 3, 3, stage.get(2).get(1)));
		stage.get(2).get(3).getMonsters().add(new Monster2(27, 22, 15, 3, 3, stage.get(2).get(3)));
		stage.get(2).get(3).getMonsters().add(new Monster2(27, 2, 15, 3, 3, stage.get(2).get(3)));
		stage.get(2).get(3).getMonsters().add(new Monster2(7, 3, 15, 3, 3, stage.get(2).get(3)));
		stage.get(2).get(3).getMonsters().add(new Monster2(11, 11, 15, 3, 3, stage.get(2).get(3)));
		stage.get(2).get(3).getMonsters().add(new Monster2(25, 11, 15, 3, 3, stage.get(2).get(3)));
		stage.get(2).get(4).getMonsters().add(new Monster2(2, 22, 15, 3, 3, stage.get(2).get(4)));
		stage.get(2).get(4).getMonsters().add(new Monster2(27, 22, 15, 3, 3, stage.get(2).get(4)));
		stage.get(2).get(4).getMonsters().add(new Monster2(15, 8, 15, 3, 3, stage.get(2).get(4)));

		// imageInfo
		imageInfo = new ArrayList<Image>();

		// 0 item image in the map
		imageInfo.add(new ImageIcon("Image/" + "item.png").getImage());
		// 1 ~ 3 monster image
		imageInfo.add(new ImageIcon("Image/" + "monster0.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "monster1.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "monster2.png").getImage());
		// 4 trap image
		imageInfo.add(new ImageIcon("Image/" + "trap.png").getImage());
		// 5 portal image
		imageInfo.add(new ImageIcon("Image/" + "portal.png").getImage());
		// 6 wizard image
		imageInfo.add(new ImageIcon("Image/" + "wizard.png").getImage());
		// 7 ~ 12 map tile image for each stage
		imageInfo.add(new ImageIcon("Image/" + "wall_0.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "back_0.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "wall_1.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "back_1.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "wall_2.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "back_2.png").getImage());
		// 13, 14 oil, kit image
		imageInfo.add(new ImageIcon("Image/" + "oil.png").getImage());
		imageInfo.add(new ImageIcon("Image/" + "kit.png").getImage());
		// 15 fireball image
		imageInfo.add(new ImageIcon("Image/" + "fireball.png").getImage());
		// 16 carcenter image
		imageInfo.add(new ImageIcon("Image/" + "carcenter.png").getImage());
	}

	public Field() {
		init();
		setMappanel(new MapPanel(stage.get(0).get(1), usercar, imageInfo));
	}

	public MapPanel getMappanel() {
		return mappanel;
	}

	public void setMappanel(MapPanel mappanel) {
		this.mappanel = mappanel;
	}

	public Car getUserCar() {
		return usercar;
	}
}