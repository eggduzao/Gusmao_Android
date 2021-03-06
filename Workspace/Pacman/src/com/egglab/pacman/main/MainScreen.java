package com.egglab.pacman.main;

import java.io.IOException;

import android.graphics.Color;
import android.util.Log;

import com.egglab.pacman.asset.MainImageAssets;
import com.egglab.pacman.framework.Game;
import com.egglab.pacman.framework.Screen;
import com.egglab.pacman.implementation.AndroidGraphics;
import com.egglab.pacman.object.Map;

public class MainScreen extends Screen {
	
	private GameState gameState;
	
	private double logoAlpha;
	
	private int currGameLevel;
	private Map currGameMap;
	
	public MainScreen(Game game) {
		super(game);
		this.gameState = GameState.INIT;
		this.logoAlpha = 1.0;
		this.currGameLevel = 1;
		MainImageAssets.loadLogo((MainGame) game);
	}

	@Override
	public void update(float deltaTime) {
	
		MainGame mainGame = (MainGame) this.game;
		AndroidGraphics graphics = (AndroidGraphics) mainGame.getGraphics();
		this.game.getGraphics().setAlpha(255);
		
		switch (this.gameState) {
		case INIT:
			this.game.getGraphics().drawRect(0, 0, mainGame.getScreenSize().x, mainGame.getScreenSize().y, Color.WHITE);
			this.setGameState(GameState.LOAD_UP);
			this.logoAlpha = 1.0;
			break;
		case LOAD_UP:
			this.game.getGraphics().drawRect(0, 0, mainGame.getScreenSize().x, mainGame.getScreenSize().y, Color.WHITE);
			if(this.logoAlpha > 255){
			    this.setGameState(GameState.LOAD_DOWN);
			}
			else{
				this.logoAlpha += deltaTime;
			}
			this.game.getGraphics().setAlpha( (int) Math.min(this.logoAlpha,255));
			this.game.getGraphics().drawImage(MainImageAssets.logoImage, 400, 200);
			break;
		case LOAD_DOWN:
			this.game.getGraphics().drawRect(0, 0, 800, 600, Color.WHITE);
			if(this.logoAlpha < 0){
			    this.setGameState(GameState.MENU);
			}
			else{
				this.logoAlpha -= deltaTime;
			}
			this.game.getGraphics().setAlpha( (int) Math.max(this.logoAlpha,0));
			this.game.getGraphics().drawImage(MainImageAssets.logoImage, 400, 200);
			break;
		case MENU:
			this.game.getGraphics().drawRect(0, 0, mainGame.getScreenSize().x, mainGame.getScreenSize().y, Color.WHITE);
			this.game.getGraphics().drawImage(MainImageAssets.logoImage, 400, 200);
			this.setGameState(GameState.GAME_LOAD);
			break;
		case GAME_LOAD:
			this.game.getGraphics().drawRect(0, 0, mainGame.getScreenSize().x, mainGame.getScreenSize().y, Color.BLACK);
			try {
				this.currGameMap = new Map(graphics.getAssets().open("map"+String.valueOf(this.currGameLevel)+".txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setGameState(GameState.GAME_RUN);
			break;
		case GAME_RUN:
			this.game.getGraphics().drawRect(0, 0, mainGame.getScreenSize().x, mainGame.getScreenSize().y, Color.BLACK);
			this.currGameMap.paint(mainGame);
			break;
		case GAME_OVER:
			break;
		}
		
	}

	@Override
	public void paint(float deltaTime) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
}