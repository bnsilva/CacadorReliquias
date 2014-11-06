package cenas;

import java.awt.Font;

import jogo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class CenaGameOver extends Cena{
	Font texto = new Font("Verdana", Font.ITALIC, 20);
	TrueTypeFont ttf = new TrueTypeFont(texto, true);
	
	public CenaGameOver(){
		super();
		setPrioridade(2);
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		
		ttf.drawString(170f, 300f, "Voce esta morto... Aperte espaco para reiniciar!");
	}
	
	protected void customUpdate(GameContainer gc, int t){
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			Game.gerenciador.adicionarCena(new CenaMenu());
			Game.gerenciador.removerCena(this);
			CenaMapa.nivel = 0;
		}
	}
	
	public void init(GameContainer gc){
		
	}
	
	public String toString()
	{
		return "cenaGameOver";
	}

}
