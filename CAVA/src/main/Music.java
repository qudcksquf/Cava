package main;

import java.io.BufferedInputStream;

import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	private static Clip bgm = null;
	private static Clip driveSE = null;
	private static PlaySE[] ps = new PlaySE[7];
	
	public static void init() {
		for(int i=0;i<7;i++) ps[i] = new PlaySE();
	}
	
	public static void offBGM() {
		if(bgm != null) {
			bgm.stop();
			bgm.close();
			bgm = null;
		}
	}
	public static void changeBGM(String fileName) {
		if(bgm != null) {
			bgm.stop();
			bgm.close();
			bgm = null;
		}
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			bgm = AudioSystem.getClip();
			bgm.open(ais);
			bgm.start();
			bgm.loop(-1);
		}
		catch(Exception e4) {
			System.out.println("Exception during changing the BGM!");
		}
	}
	public static void drive(boolean running) {
		if(running == false) {
			if(driveSE != null) {
				driveSE.stop();
				driveSE.close();         
				driveSE = null;
			}
		}
		else if(driveSE == null) {
			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("SE/" + "engine_sound.wav")));
				driveSE = AudioSystem.getClip();
				driveSE.open(ais);
				driveSE.start();
				driveSE.loop(-1);
			} catch (Exception e) {
				System.out.println("Exception during playing the driving sound!");
			}
		}
	}
	public static void boost() {
		ps[0].playSound("SE/" + "booster_sound.wav");
	}
	public static void kit() {
		ps[1].playSound("SE/" + "kit_sound.wav");
	}
	public static void oil() {
		ps[2].playSound("SE/" + "oil_sound.wav");
	}
	public static void getItem() {
		ps[3].playSound("SE/" + "get_item_sound.wav");
	}
	public static void monster() {
		ps[4].playSound("SE/" + "monster_sound.wav");
	}
	public static void carcenterZero() {
		ps[5].playSound("SE/" + "carcenter0_sound.wav");
	}
	public static void carcenterOne() {
		ps[6].playSound("SE/" + "carcenter1_sound.wav");
	}
}
