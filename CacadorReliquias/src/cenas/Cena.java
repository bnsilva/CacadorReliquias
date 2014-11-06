package cenas;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public abstract class Cena implements Comparable<Cena>{
	
	public enum STATE {ON, FREEZE, INVISIBLE};
	protected STATE state;
	protected Image cena;
	private int prioridade = 0;
	
	public Cena(){
		state = STATE.ON;
		try{
			cena = new Image(800, 600);
		} catch (SlickException e){
			e.printStackTrace();
		}
	}
	
	protected void customRender(GameContainer gc, Graphics g){
		
	}
	
	protected void customUpdate(GameContainer gc, int t){
		
	}
	
	public void init(GameContainer gc){
		
	}
	
	public void render(GameContainer gc, Graphics g){
		if(state == STATE.ON){
			customRender(gc, g);
		}
		if(state == STATE.FREEZE){
			g.drawImage(cena, 0, 0);
		}
	}
	
	public void update(GameContainer gc, int t){
		if (state == STATE.ON){
			customUpdate(gc, t);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
	}
	
	public String toString(){
		return "default";
	}
	
	public void setState(STATE s){
		state = s;
	}
	
	public void setPrioridade(int prioridade){
		this.prioridade = prioridade;
	}
	
	public int getPrioridade(){
		return prioridade;
	}
	
	public int compareTo(Cena compareObject){
		if (getPrioridade() < compareObject.getPrioridade()){
			return -1;
		}
		else if (getPrioridade() == compareObject.getPrioridade()){
			return 0;
		}
		else{
			return 1;
		}
	}
}


