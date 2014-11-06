package jogo;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Animacao extends Animation{
	public Animacao getAnimation(Image i, int startY, int spritesX, int spritesY, int spriteWidth, int spriteHeight, int frames, int duration, float scale){
		int cont = 0;
		
		for(int y = startY; y < startY + spritesY; y++){
			for(int x = 0; x < spritesX; x++){
				if (cont < frames) this.addFrame(i.getSubImage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight).getScaledCopy(scale), duration);
				cont++;
			}
		}
		return this;
	}

}
