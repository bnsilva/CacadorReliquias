package cenas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import unidades.Hero;

public class InterfaceJogador {
	public static int time;
	private String tempo;
	private int vida, reliquias;
	static final int VIDA_MAX = 5;
	
	InterfaceJogador(){
		tempo = new String("TEMPO %02d : %02d : %03d");
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(300, 10, vida*50, 10);
		g.setColor(Color.white);
		g.drawRect(300, 10, VIDA_MAX*50, 10);
		
		g.drawString("Reliquias:  " + reliquias, 50, 10);
		g.drawString("Vida:  ", 250, 10);
		g.drawString(String.format(tempo, time/60000%60, time/1000%60, time%1000), 600, 10);
	}
	
	public void update(Hero hero, int delta){
		this.vida = hero.getVida();
		this.reliquias = hero.getReliquias();
		time += delta;
	}
	
}
