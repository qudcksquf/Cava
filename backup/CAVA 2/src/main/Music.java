package main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	public static Clip clip;
	
	public static void init() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("stage0.wav")));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void changeBGM(int stageNumber) {
		try {
			clip.stop();
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("stage" + stageNumber + ".wav")));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(-1);
		}
		catch(Exception e4) {
			e4.printStackTrace();
		}
	}
}
