import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Bullet extends Object implements Drawable,Movable{

	private boolean isVisible = true;
	
	private double theta = 0.0;
	
	public Bullet(int x, int y,double t) {
		super(x,y + 10);
		theta = t;
	}

	public static String URL_IMAGE_PATH_BULLET = "res//ammo.png";
	
	
	
	
	@Override
	public void draw(Graphics g) {
			move(null);
			Graphics2D g2d = (Graphics2D)g;
			g2d.rotate(theta);
			super.draw(g2d, URL_IMAGE_PATH_BULLET);
			g2d.rotate(-theta);
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
