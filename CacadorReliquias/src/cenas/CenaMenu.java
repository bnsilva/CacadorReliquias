package cenas;

import jogo.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class CenaMenu extends Cena{
	private Image menu;
	private boolean textoVisivel = true;
	private int cont = 0;
	
	public CenaMenu(){
		super();
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		g.drawImage(menu, 0, 0);
		
		if (!textoVisivel){
			g.setColor(Color.black);
			g.fillRect(72, 432, 500, 100);
		}
	}
	
	protected void customUpdate(GameContainer gc, int t){
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			Game.gerenciador.adicionarCena(new CenaMapa1());
			Game.gerenciador.removerCena(this);
		}
		
		if(cont < 40){
			textoVisivel = true;
		}
		else if(cont < 70){
			textoVisivel = false;
		}
		else cont = 0;
		
		cont++;
	}
	
	public void init(GameContainer gc){
		try {
			menu = new Image("res/Menu_Cacador_Reliquias.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		InterfaceJogador.time = 0;
	}
	
	public String toString()
	{
		return "cenaMenu";
	}

}
