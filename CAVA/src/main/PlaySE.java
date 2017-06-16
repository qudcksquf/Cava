package main;

import java.io.BufferedInputStream;

import java.io.FileInputStream;

import javax.sound.sampled.*;

public class PlaySE {

    public void playSound(String filename) {
    	try {
    		AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(filename)));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
			System.out.println("Exception during playing the sounds!");
       }
    }
}
