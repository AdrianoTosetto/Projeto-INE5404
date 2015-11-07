import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player extends Object implements Drawable,Movable{

	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	public Player(int x, int y) {
		super(x, y);
	}

	public static String URL_IMAGE_PATH_PLAYER = "res//ship.png";
	
	@Override
	public void draw(Graphics g) {
		super.draw(g, URL_IMAGE_PATH_PLAYER);
	}
	
	public void shoot(){
		bullets.add(new Bullet(posX,posY));
	}
	
	public void move(KeyEvent e){
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			posY++;
			System.out.println(posY);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			shoot();
		}
	}
	
	public void drawBullets(Graphics g){
		for(int i = 0; i < bullets.size();i++){
			bullets.get(i).draw(g);
		}
	}
	
}
