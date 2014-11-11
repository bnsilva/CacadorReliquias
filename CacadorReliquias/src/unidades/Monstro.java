package unidades;

import jogo.Animacao;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Monstro extends Unidade{
	private int tipo;
//	private Rectangle monstro;
	private Animacao monstro, up, left, right;

	public Monstro(int posx, int posy, int tipo) {
		super(posx, posy);
		
		this.tipo = tipo;
			speed = 2;
	
		try {
			image = new Image("res/img/Enemies.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		left = new Animacao();
		left.getAnimation(image, 1, 2, 1, 32, 16, 1, 100, 1.0f);
		
		up = new Animacao();
		up.getAnimation(image, 2, 1, 1, 32, 16, 1, 100, 1.0f);
		
		right = new Animacao();
		right.getAnimation(image, 4, 1, 1, 32, 16, 1, 100, 1.0f);
		
		monstro = new Animacao();
		monstro = right;
		
	}

	@Override
	public void render(Graphics g) {		
		monstro.draw(posx, posy);
		
	}

	@Override
	public void update(GameContainer gc, TiledMap map) {
		
		int objectLayer = map.getLayerIndex("Objects");
		map.getTileId(0, 0, objectLayer);
		
		if(tipo == 0){
			posx += speed;
			if ( map.getTileId((int) ((posx+16)/32), (int) (posy/32), objectLayer) != 0){
				posx -= speed;
				mudaSpeed();
				
				if (monstro == right){
					monstro = left;
				} else monstro = right;
				
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
		
	}
	
	public void mudaSpeed(){
		speed *= -1;
	}
}
