package cenas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GerenciadorCena {
	private List<Cena> cenas;
	private GameContainer gc;
	
	public GerenciadorCena(GameContainer gc){
		this.gc = gc;
		cenas = new ArrayList<Cena>();
	}
	
	public void adicionarCena(Cena cena){
		cenas.add(cena);
		cena.init(gc);
		this.sortear();
	}
	
	public void removerCena(Cena cena){
		cenas.remove(cena);
	}
	
	public void render(GameContainer gc, Graphics g){
		for (int i = 0; i < cenas.size(); i++){
			cenas.get(i).render(gc,  g);
		}
	}
	
	public void update(GameContainer gc, int t){
		for (int i = 0; i < cenas.size(); i++){
			cenas.get(i).update(gc,  t);
		}
	}
	
	public void sortear(){
		Collections.sort(cenas);
	}
	
	public Cena getCena ( String cena )
	{
		for( int i = 0 ; i < cenas.size() ; i++ )
		{
			if( cenas.get(i).toString().equals(cena) )
			{
				return cenas.get(i);
			}
		}
		return null;
	}

}
