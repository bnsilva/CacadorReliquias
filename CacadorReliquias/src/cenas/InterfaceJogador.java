package cenas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class InterfaceJogador {
	public static int time;
	private String tempo;
	private int vida;
	static final int VIDA_MAX = 5;
	
	InterfaceJogador(){
		tempo = new String("TEMPO %02d : %02d : %03d");
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(300, 10, vida*50, 10);
		g.setColor(Color.white);
		g.drawRect(300, 10, VIDA_MAX*50, 10);
		
		g.drawString("Vida:  ", 250, 10);
		g.drawString(String.format(tempo, time/60000%60, time/1000%60, time%1000), 600, 10);
	}
	
	public void update(int vida, int delta){
		this.vida = vida;
		time += delta;
	}
	
	public static void espera(long tempoEspera){
	}
	
}
