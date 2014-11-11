package cenas;

import java.util.ArrayList;

import jogo.Game;
import unidades.Hero;
import unidades.Monstro;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public abstract class CenaMapa extends Cena {
	public static int nivel;
	protected int nMapa;
	protected int teleportx, teleporty;
	
	protected TiledMap mapa1;
	protected TiledMap mapa2;
	protected TiledMap mapa3;
	protected Image e1;
	protected InterfaceJogador interJog;
	
	protected ArrayList<Monstro> monstros;
	protected Hero hero;
	
	public CenaMapa(){
		super();
		interJog = new InterfaceJogador();
		
//		nivel ++;
		
//		if(nivel == 1){
			try {
				e1 = new Image("res/img/escuro1.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
/*		}else if(nivel == 2){
			try {
				e1 = new Image("res/img/escuro2.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}else if(nivel == 3){
			try {
				e1 = new Image("res/img/escuro3.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
*/	}
	
	public void render(GameContainer gc, Graphics g){
		if(state == STATE.ON){
			customRender(gc, g);
			interJog.render(g);
		}
		if(state == STATE.FREEZE){
			g.drawImage(cena, 0, 0);
		}
	}
	
	public void update(GameContainer gc, int t){
		if (state == STATE.ON){
			
			if (gc.getInput().isKeyPressed(Input.KEY_P)){
				this.setState(STATE.INVISIBLE);
				Game.gerenciador.adicionarCena(new CenaPause());
			}
			if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
				gc.exit();
			}
			
			customUpdate(gc, t);
			hero.isColide(monstros);
			interJog.update(hero.getVida(), t);
			
			if(hero.isDead()){
				this.setState(STATE.INVISIBLE);
				Game.gerenciador.adicionarCena(new CenaGameOver());
				Game.gerenciador.removerCena(this);
			}
			
			if(hero.getPosx() > teleportx && hero.getPosx() < teleportx+32
					&& hero.getPosy() > teleporty && hero.getPosy() < teleporty+32){
				this.setState(STATE.INVISIBLE);
				CenaMapa.nivel++;
				Game.gerenciador.removerCena(this);
				Game.gerenciador.adicionarCena(new CenaMapa1());

				
			}
		}
	}

}
