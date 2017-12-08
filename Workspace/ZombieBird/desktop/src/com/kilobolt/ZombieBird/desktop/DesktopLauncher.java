package com.kilobolt.ZombieBird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kilobolt.ZombieBird.ZBGame;

public class DesktopLauncher {
	public static void main(String[] arg) {

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ZombieBird";
		cfg.useGL30 = false;
		cfg.width = 272;
		cfg.height = 408;

		new LwjglApplication(new ZBGame(), cfg);

	}
}
