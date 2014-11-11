package cenas;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import unidades.Hero;

public class CenaMapa2 extends CenaMapa{
	private Rectangle r;
	
	CenaMapa2(){
		super();
/*		teleportx = 32 * 1;
		teleporty = 32 * 18;
		r = new Rectangle(teleportx, teleporty, 32, 32);
	*/}
	
	protected void Render(GameContainer gc, Graphics g){
/*		mapa.render(0, 0);
		hero.render(g);
		interJog.render(g);
		g.setColor(Color.red);
		g.draw(r);
*/	}
	
	protected void Update(GameContainer gc, int t){
//		hero.update(gc, mapa);
	}
	
	public void init(GameContainer gc){
/*		try {
			mapa = new TiledMap ("res/maps/mapa_teste.tmx");
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
		
		hero = new Hero(70,90);
*/		
	}
	
/*	public String toString(){
		return ("CenaMapa2");
	}*/
}
