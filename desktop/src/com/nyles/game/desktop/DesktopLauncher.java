package com.nyles.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nyles.game.FirstFlappyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FirstFlappyGame.WIDTH;
		config.height = FirstFlappyGame.HEIGHT;
		config.title = FirstFlappyGame.TITLE;
		new LwjglApplication(new FirstFlappyGame(), config);
	}
}
