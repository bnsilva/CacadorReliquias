package unidades;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Unidade {
	protected int posx, posy, speed;
	protected Image image;
	
	Unidade(int posx, int posy){
		this.posx = posx;
		this.posy = posy;
	}
	
	public abstract void render(Graphics g);
	
	public abstract void update(GameContainer gc, TiledMap map);

	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

}
