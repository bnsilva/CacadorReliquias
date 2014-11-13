package unidades;

import java.util.ArrayList;

import jogo.Animacao;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Hero extends Unidade{
	private static int reliquias;

	private int vida;
	private Animacao sprite, up, left, down, right;
	
	public Hero(int posx, int posy) {
		super(posx, posy);
		speed = 2;
		vida = 5;
		
		try {
			image = new Image("res/img/Char.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}

		up = new Animacao();
		up.getAnimation(image, 4, 1, 1, 32, 32, 1, 100, 1.0f);
		
		down = new Animacao();
		down.getAnimation(image, 1, 1, 1, 32, 32, 1, 100, 1.0f);
		
		left = new Animacao();
		left.getAnimation(image, 2, 1, 1, 32, 32, 1, 100, 1.0f);
		
		right = new Animacao();
		right.getAnimation(image, 3, 1, 1, 32, 32, 1, 100, 1.0f);
		
		sprite = new Animacao();
		sprite = down;
	}

	@Override
	public void render(Graphics g) {
		sprite.draw(posx-14, posy-30);
		
	}

	@Override
	public void update(GameContainer gc, TiledMap map) {
		int objectLayer = map.getLayerIndex("Objects");

		map.getTileId(0, 0, objectLayer);
		
		if (gc.getInput().isKeyDown(Input.KEY_RIGHT)){
			posx += speed;
			sprite = right;
			sprite.start();
			if ( map.getTileId((int) ((posx+5)/32), (int) (posy/32), objectLayer) != 0){
				posx -= speed;
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_LEFT)){
			posx -= speed;
			sprite = left;
			sprite.start();
			if ( map.getTileId((int) ((posx-5)/32), (int) (posy/32), objectLayer) != 0){
				posx += speed;
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_DOWN)){
			posy += speed;
			sprite = down;
			sprite.start();
			if ( map.getTileId((int) (posx/32), (int) ((posy)/32), objectLayer) != 0){
				posy -= speed;		
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_UP)){
			posy -= speed;
			sprite = up;
			sprite.start();
			if ( map.getTileId((int) (posx/32), (int) ((posy-10)/32), objectLayer) != 0){
				posy += speed;
			}
		}
		if (!gc.getInput().isKeyDown(Input.KEY_UP) &&
				!gc.getInput().isKeyDown(Input.KEY_DOWN) &&
				!gc.getInput().isKeyDown(Input.KEY_RIGHT) &&
				!gc.getInput().isKeyDown(Input.KEY_LEFT)){
			sprite.stop();
		}
		if (gc.getInput().isKeyDown(Input.KEY_B)){
			abrirBau(map);
		}
	}
	
	public void isColide(ArrayList<Monstro> monstros) {
		for (int i = 0; i < monstros.size(); i++){
			if (posx+5 > monstros.get(i).getPosx() && posx-5 < monstros.get(i).getPosx() + 32
					&& posy-5 > monstros.get(i).getPosy() && posy < monstros.get(i).getPosy()+32){
				vida--;
				monstros.get(i).mudaSpeed();
				
				if (sprite == up){
					posy +=11;
				} else if (sprite == down){
					posy -=11;
				} else if (sprite == right){
					posx -=11;
				} else if (sprite == left) {
					posx +=11;
				}
			}
		}
	}
	
	public boolean isDead(){
		if(vida > 0) return false;
		else return true;
	}
	
	public void abrirBau(TiledMap map){
		int chestLayer = map.getLayerIndex("Chest");
		map.getTileId(0, 0, chestLayer);
		
		if ( map.getTileId((int) (posx/32), (int) ((posy)/32), chestLayer) != 0){
			reliquias++;
			map.setTileId((int) (posx/32),  (int) ((posy)/32), chestLayer, 0);
		}
		
	}
	
	public void zerarReliquias(){
		reliquias = 0;
	}

	public static int getReliquias() {
		return reliquias;
	}

	public int getVida() {
		return vida;
	}
	
}
