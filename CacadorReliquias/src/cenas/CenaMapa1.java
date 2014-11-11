package cenas;

import java.util.ArrayList;

import jogo.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import unidades.Hero;
import unidades.Monstro;

public class CenaMapa1 extends CenaMapa{
	private Rectangle r ;
	
	CenaMapa1(){
		super();
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		if (nivel == 1){
			mapa1.render(0, 0);
		} else if (nivel == 2){
			mapa2.render(0, 0);
		}else if (nivel == 3){
			mapa3.render(0, 0);
		}
		
		
		for (int i = 0; i < monstros.size(); i++){
			monstros.get(i).render(g);
		}
		 
		hero.render(g);
		e1.drawCentered(hero.getPosx(), hero.getPosy()-10);
		interJog.render(g);
		g.setColor(Color.red);
		g.draw(r);
		
	}
	
	protected void customUpdate(GameContainer gc, int t){
		TiledMap mapaAtual = null;
		if (nivel == 1){
			mapaAtual = mapa1;
		} else if (nivel == 2) {
			mapaAtual = mapa2;
		}else if (nivel == 3) {
			mapaAtual = mapa3;
		}
		
		for (int i = 0; i < monstros.size(); i++){
			monstros.get(i).update(gc, mapaAtual);
		}
			hero.update(gc, mapaAtual);
	}
	
	public void init(GameContainer gc){
		try {
			mapa1 = new TiledMap("res/maps/map01.tmx");
			mapa2 = new TiledMap("res/maps/map02.tmx");
			mapa3 = new TiledMap("res/maps/map03.tmx");
		} catch (SlickException e) {
			e.printStackTrace();
		}

		hero = new Hero(32*2, 32*4);
		
		if (nivel >= 4){
			nivel = 1;
			Game.gerenciador.removerCena(this);
			Game.gerenciador.adicionarCena(new CenaMenu());
		}
		
		if (nivel == 1){
			hero.zerarReliquias();
			
			teleportx = 0;
			teleporty = 32*17;
			
			monstros = new ArrayList<Monstro> ();
			monstros.add(new Monstro(32*7, 32*4 + 10, 0));
			monstros.add(new Monstro(32*7, 32*14, 0));
			monstros.add(new Monstro(32*5, 32*7, 1));
			monstros.add(new Monstro(32*13, 32*15, 1));
			
		} else if(nivel == 2){
			teleportx = 32*24;
			teleporty = 32*17;
			
			monstros = new ArrayList<Monstro> ();
			monstros.add(new Monstro(32*7, 32*4 + 10, 0));
			monstros.add(new Monstro(32*7, 32*16, 0));
			monstros.add(new Monstro(32*23, 32*16, 1));
			monstros.add(new Monstro(32*13, 32*15, 1));
		}
		
		else if(nivel == 3){
			teleportx = 32*24;
			teleporty = 32*9;
			
			monstros = new ArrayList<Monstro> ();
			monstros.add(new Monstro(32*7, 32*4 + 10, 0));
			monstros.add(new Monstro(32*12, 32*18, 0));
			monstros.add(new Monstro(32*23, 32*16, 1));
			monstros.add(new Monstro(32*17, 32*15, 1));
		}
		
		r = new Rectangle(teleportx, teleporty, 32, 32);
		
	}
	
	public String toString(){
		return "CenaMapa1";
	}

}
