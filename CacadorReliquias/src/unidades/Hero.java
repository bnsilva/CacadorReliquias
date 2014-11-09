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
	private int vida;
	private Animacao sprite, up, left, down, right;
	
	public Hero(int posx, int posy) {
		super(posx, posy);
		speed = 2;
		vida = 10;
		
		try {
			image = new Image("res/img/SaraFullSheet.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		up = new Animacao();
		up.getAnimation(image, 8, 9, 1, 64, 64, 9, 100, 0.5f);
		
		left = new Animacao();
		left.getAnimation(image, 9, 9, 1, 64, 64, 9, 100, 0.5f);
		
		down = new Animacao();
		down.getAnimation(image, 10, 9, 1, 64, 64, 9, 100, 0.5f);
		
		right = new Animacao();
		right.getAnimation(image, 11, 9, 1, 64, 64, 9, 100, 0.5f);
		
		sprite = new Animacao();
		sprite = right;
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
			if ( map.getTileId((int) (posx/32), (int) ((posy+5)/32), objectLayer) != 0){
				posy -= speed;		
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_UP)){
			posy -= speed;
			sprite = up;
			sprite.start();
			if ( map.getTileId((int) (posx/32), (int) ((posy-5)/32), objectLayer) != 0){
				posy += speed;
			}
		}
		if (!gc.getInput().isKeyDown(Input.KEY_UP) &&
				!gc.getInput().isKeyDown(Input.KEY_DOWN) &&
				!gc.getInput().isKeyDown(Input.KEY_RIGHT) &&
				!gc.getInput().isKeyDown(Input.KEY_LEFT)){
			sprite.stop();
		}
	}
	
	public void isColide(ArrayList<Monstro> monstros) {
		for (int i = 0; i < monstros.size(); i++){
			if (posx+5 > monstros.get(i).getPosx() && posx-5 < monstros.get(i).getPosx() + 16
					&& posy+10 > monstros.get(i).getPosy() && posy-10 < monstros.get(i).getPosy()+16){
				vida--;
				monstros.get(i).mudaSpeed();
				if(posx<monstros.get(i).getPosx()) posx-=16;
				if(posx>monstros.get(i).getPosx()) posx+=16;
				if(sprite.equals(up)) posy-=16;
				if(sprite.equals(down)) posy-=16;
			}
		}
	}
	
	public boolean isDead(){
		if(vida > 0) return false;
		else return true;
	}

	public int getVida() {
		return vida;
	}

}
