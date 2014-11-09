package cenas;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import unidades.Hero;
import unidades.Monstro;

public class CenaMapa1 extends CenaMapa{
	Rectangle r ;
	
	CenaMapa1(){
		super();
		teleportx = 32*1;
		teleporty = 32*18;
		r = new Rectangle(teleportx, teleporty, 32, 32);
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		mapa.render(0, 0);
		
		for (int i = 0; i < monstros.size(); i++){
			monstros.get(i).render(g);
		}
		
		hero.render(g);
		e1.drawCentered(hero.getPosx(), hero.getPosy());
		interJog.render(g);
		g.setColor(Color.red);
		g.draw(r);
		
	}
	
	protected void customUpdate(GameContainer gc, int t){
		for (int i = 0; i < monstros.size(); i++){
			monstros.get(i).update(gc, mapa);
		}
		
		hero.update(gc, mapa);
	}
	
	public void init(GameContainer gc){
		try {
			mapa = new TiledMap("res/maps/mapa1.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		monstros = new ArrayList<Monstro> ();
		monstros.add(new Monstro(32*5, 32, 0));
		monstros.add(new Monstro(32*4, 32*4, 1));
		
		hero = new Hero(34, 34);
		
	}
	
	public String toString(){
		return "CenaMapa1";
	}

}
