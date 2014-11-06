package unidades;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Monstro extends Unidade{
	private int tipo;
	private Rectangle monstro;

	public Monstro(int posx, int posy, int tipo) {
		super(posx, posy);
		
		this.tipo = tipo;
		if (tipo == 0){
			speed = 2;
		}
		else{
			speed = 3;
		}
		
		monstro = new Rectangle(posx, posy, 16, 16);
	}

	@Override
	public void render(Graphics g) {
		if(tipo == 0){
			g.setColor(Color.red);
		}
		else{
			g.setColor(Color.blue);
		}
		g.fill(monstro);
	}

	@Override
	public void update(GameContainer gc, TiledMap map) {
		
		int objectLayer = map.getLayerIndex("Objects");
		map.getTileId(0, 0, objectLayer);
		
		if(tipo == 0){
			posx += speed;
			if ( map.getTileId((int) ((posx)/32), (int) (posy/32), objectLayer) != 0){
				posx -= speed;
				mudaSpeed();
			}
		}
		else{
			posy += speed;
			if ( map.getTileId((int) ((posx)/32), (int) (posy/32), objectLayer) != 0){
				posy -= speed;
				mudaSpeed();
			}
		}
		monstro.setX(posx);
		monstro.setY(posy);
		
	}
	
	public void mudaSpeed(){
		speed *= -1;
	}
	

}
