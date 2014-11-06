package jogo;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import cenas.CenaMenu;
import cenas.GerenciadorCena;

public class Game extends BasicGame{
	public static GerenciadorCena gerenciador;

	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		gerenciador = new GerenciadorCena(gc);
		gerenciador.adicionarCena(new CenaMenu());
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		gerenciador.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int t) throws SlickException {
		gerenciador.update(gc, t);
	}

}
