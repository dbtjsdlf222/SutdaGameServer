package music;

import java.io.File;
import java.io.FileInputStream;

import org.slf4j.LoggerFactory;


import org.slf4j.Logger;

import javazoom.jl.player.Player;

public class MusicPlayer extends Thread {

	
	private Player player;
	private File file;
	boolean loop = true;
	public MusicPlayer() {
		try {
//			File file = new File(MainScreen.class.getResource("../Music/BigSleep.mp3").getFile());
//			this.player = new Player(new BufferedInputStream(new FileInputStream(file)));
		} catch (Exception e) {
		}
	}

	public void close() {
		this.player.close();
		interrupt();
	}

	public void run() {
		try {
			do {
				FileInputStream buff = new FileInputStream(file);
				player = new Player(buff);
				player.play();
			} while (loop);	
		} catch (Exception e) { }
}}
