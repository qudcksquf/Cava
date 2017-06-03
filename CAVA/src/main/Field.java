package main;

import mapinfo.*;
import gui.*;
import objects.*;
import playable.*;
import javax.swing.*;
import java.util.*;

public class Field extends JFrame {
	private MapPanel mapGUI; // map GUI
	
	// 앞으로 활용될 몬스터 위치, 자동차 위치 기록용
	
	private Car usercar; // 얘는 쉘로 카피 때려버리자.
	// 굳이 이차원 어레이리스트로 잡는 이유는 인덱스 1은 숲, 인덱스 2은 산, 인덱스 3을 지옥 스테이지로 잡기 위함이다.
	private ArrayList<ArrayList<Maps> > map; // 얘는 딥카피 때려야한다. 파일 I/O로 관리할 것이다.
	
	// 정보 보관용
	private ArrayList<Item> item;
	private ArrayList<Monster> monster;
	private ArrayList<Trap> trap;
	private ArrayList<Tooltip> tooltip;
	
	public Field() {
		setTitle("Cava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		usercar = new Car(); // Save/Load 기능이 구현 안한다면 늘 새로운 자동차를 생성
		// map은 파일 불러오는 과정에서 초기화 할것
		
		map = new ArrayList<ArrayList<Maps> >();
		map.add(new ArrayList<Maps>());
		map.get(0).add(new Maps());
		// 맵의 최초 시작지점은 0의 0, 튜토리얼
		mapGUI = new MapPanel(usercar, map.get(0).get(0));
		add(mapGUI);
		
		setSize(600, 600);
        setResizable(false);

		setVisible(true);
	}
	public static void main(String[] args) {
		// 주의. 필드 생성 전에 메인함수에서 파일 불러오는 함수를 "반드시" 실행할 것
		
		// 필드 생성
		Field frame = new Field();
	}
}
