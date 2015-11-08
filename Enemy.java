import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Enemy extends Object implements Drawable,Movable{

	public static String URL_IMAGE_PATH_ENEMY = "res//giulio2.png";
	
	public double theta = 0.0;
	
	private boolean isVisible = true;
	
	public Enemy(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		theta += 0.1;
		move(null);
		super.draw(g2d, URL_IMAGE_PATH_ENEMY);
		
		/*AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.1);
		g2d.setComposite(alpha);*/
		//g2d.rotate(-theta);
	}

	@Override 
	public void move(KeyEvent e) {
		if(posX >= 0)
			posX-=1;
		else 
			isVisible = false;
	}
	public boolean isVisible(){
		return isVisible;
	}

}
