package com.egglab.pacman.asset;

import com.egglab.pacman.framework.Graphics;
import com.egglab.pacman.framework.Graphics.ImageFormat;
import com.egglab.pacman.framework.Image;
import com.egglab.pacman.main.MainGame;

public class MainImageAssets {
	
    public static Image logoImage;

	public static void loadLogo(MainGame mainGame) {
		Graphics g = mainGame.getGraphics();
		logoImage = g.newImage("screen1.png", ImageFormat.ARGB4444);
	}

	public static void loadMapImages(){
		
	}
	

	
	public static void dispose() {

	}

}
