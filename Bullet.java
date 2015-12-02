import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Bullet extends Object implements Drawable,Movable{

	private boolean isVisible = true;

	public static String URL_IMAGE_PATH_BULLET = "res//ammo.png";
	public Bullet(int x, int y,int s) {
		super(x,y + 10,s);
		width = new ImageIcon(URL_IMAGE_PATH_BULLET).getImage().getWidth(null);
		height = new ImageIcon(URL_IMAGE_PATH_BULLET).getImage().getHeight(null);
	}	
	
	@Override
	public void draw(Graphics g) {
			move(null);
			Graphics2D g2d = (Graphics2D)g;
			super.draw(g2d, URL_IMAGE_PATH_BULLET);
	}
	@Override
	public void move(KeyEvent e) {
		/*
		 *
		 * */
		if(posX < 400) 
			posX+=5;
		else 
			isVisible = false;
	}
	
	public boolean isVisible(){
		return isVisible;
	}
}
