package unidades;

import jogo.Animacao;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Monstro extends Unidade{
	private int tipo;
//	private Rectangle monstro;
	private Animacao monstro, up, left, down, right;

	public Monstro(int posx, int posy, int tipo) {
		super(posx, posy);
		
		this.tipo = tipo;
		if (tipo == 0){
			speed = 2;
		}
		else{
			speed = 2;
		}
		
//		monstro = new Rectangle(posx, posy, 16, 16);
		
		try {
			image = new Image("res/img/Enemies.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		up = new Animacao();
		up.getAnimation(image, 2, 1, 1, 32, 16, 1, 100, 1.0f);
		
		down = new Animacao();
		down.getAnimation(image, 1, 2, 1, 32, 16, 1, 100, 1.0f);
		
		left = new Animacao();
		left.getAnimation(image, 1, 2, 1, 32, 16, 1, 100, 1.0f);
		
		right = new Animacao();
		right.getAnimation(image, 4, 1, 1, 32, 16, 1, 100, 1.0f);
		
		monstro = new Animacao();
		monstro = right;
		
	}

	@Override
	public void render(Graphics g) {
/*		if(tipo == 0){
			g.setColor(Color.red);
		}
		else{
			g.setColor(Color.blue);
		}
		g.fill(monstro);
*/		
		monstro.draw(posx, posy);
		
	}

	@Override
	public void update(GameContainer gc, TiledMap map) {
		
		int objectLayer = map.getLayerIndex("Objects");
		map.getTileId(0, 0, objectLayer);
		
		if(tipo == 0){
			posx += speed;
			if ( map.getTileId((int) ((posx+20)/32), (int) (posy/32), objectLayer) != 0){
				posx -= speed;
				mudaSpeed();
			}
		}
		else{
			posy += speed;
			monstro = up;
			if ( map.getTileId((int) ((posx)/32), (int) (posy/32), objectLayer) != 0){
				posy -= speed;
				mudaSpeed();
			}
		}
//		monstro.setX(posx);
//		monstro.setY(posy);
		
	}
	
	public void mudaSpeed(){
		speed *= -1;
	}
	

}
