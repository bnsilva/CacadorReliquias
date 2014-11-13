package cenas;

import java.awt.Font;

import jogo.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class CenaFinal extends Cena{
	Font texto = new Font("Verdana", Font.ITALIC, 20);
	TrueTypeFont ttf = new TrueTypeFont(texto, true);
	
	public CenaFinal(){
		super();
		setPrioridade(2);
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		ttf.drawString(150f, 150f, "Parabens! Voce passou por todos os niveis em "+ InterfaceJogador.time/60000%60 + " min e "+ InterfaceJogador.time/1000%60 + " seg!");
		ttf.drawString(150f, 250f, "Coletando " + unidades.Hero.getReliquias() + " de 15 Reliquias.");
		ttf.drawString(150f, 350f, "Aperte ESPACO para continuar.");
	}
	
	protected void customUpdate(GameContainer gc, int t){
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			Game.gerenciador.removerCena(this);
			Game.gerenciador.adicionarCena(new CenaMenu());
		}
	}
	
	public String toString()
	{
		return "cenaPause";
	}

}
