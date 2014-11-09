package cenas;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.SlickException;

import unidades.Hero;

public class CenaMapa2 extends CenaMapa{
	CenaMapa2(){
		super();
	}
	
	protected void Render(GameContainer gc, Graphics g){
/*		mapa.render(0, 0);
		hero.render(g);
		interJog.render(g);
*/	}
	
	protected void Update(GameContainer gc, int t){
//		hero.update(gc, mapa);
	}
	
	public void init(GameContainer gc){
/*		try {
			mapa = new TiledMap ("res/maps/map01");
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
*/		
//		hero = new Hero(64,64);
		
	}
	
/*	public String toString(){
		return ("CenaMapa2");
	}*/
}
