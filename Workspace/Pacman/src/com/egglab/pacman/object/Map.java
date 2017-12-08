package com.egglab.pacman.object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.egglab.pacman.main.MainGame;

import android.graphics.Color;

public class Map {
	
	private ArrayList<MapItem> map;
	
	private static int WALL_SIZE = 11;
	private static int CANDY_SIZE = 5;

	public Map(InputStream is) {
		this.map = new ArrayList<MapItem>();
		Scanner s = null;
		s = new Scanner(is);
		int row = 0;
		int col = 0;
		while (s.hasNext()){
			String currStr = s.nextLine();
			char[] currStrVec = currStr.toCharArray();
			System.out.println(currStr);
			col = 0;
			for (char c : currStrVec){
				int x, y, width, height;
				MapItemType type;
				if(c == '#'){
					x = row * WALL_SIZE;
					y = col * WALL_SIZE;
					width = WALL_SIZE;
					height = WALL_SIZE;
					type = MapItemType.WALL;
				}
				else if(c == 'C'){
					x = (row * WALL_SIZE) + ((WALL_SIZE-CANDY_SIZE)/2);
					y = (col * WALL_SIZE) + ((WALL_SIZE-CANDY_SIZE)/2);
					width = CANDY_SIZE;
					height = CANDY_SIZE;
					type = MapItemType.CANDY;
				}
				else if(c == 'S'){
					x = (row * WALL_SIZE) + ((WALL_SIZE-CANDY_SIZE)/2);
					y = (col * WALL_SIZE) + ((WALL_SIZE-CANDY_SIZE)/2);
					width = CANDY_SIZE;
					height = CANDY_SIZE;
					type = MapItemType.SUPERCANDY;
				}
				else{
					col++;
					continue;
				}
				this.map.add(new MapItem(x,y,width,height,type));
				col++;
			}
			row++;
		}
		s.close();
	}
	
	public void paint(MainGame mainGame){
		for (MapItem e : this.map){
			if(e.getType() == MapItemType.WALL){
				mainGame.getGraphics().drawRect(e.getX(), e.getY(), e.getWidth(), e.getHeight(), Color.GRAY);
			}
			else if(e.getType() == MapItemType.CANDY){
				mainGame.getGraphics().drawRect(e.getX(), e.getY(), e.getWidth(), e.getHeight(), Color.WHITE);
				mainGame.getGraphics().drawCircle(e.getX()+(CANDY_SIZE/2), e.getY()+(CANDY_SIZE/2), CANDY_SIZE/2, Color.YELLOW);
			}
			else if(e.getType() == MapItemType.SUPERCANDY){
				mainGame.getGraphics().drawRect(e.getX(), e.getY(), e.getWidth(), e.getHeight(), Color.WHITE);
				mainGame.getGraphics().drawCircle(e.getX()+(CANDY_SIZE/2), e.getY()+(CANDY_SIZE/2), CANDY_SIZE/2, Color.RED);
			}
		}
	}
	
	public int getSize(){
		return this.map.size();
	}

}