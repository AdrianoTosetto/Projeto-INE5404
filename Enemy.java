import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Enemy extends Object implements Drawable,Movable{

	
	public static String URL_IMAGE_PATH_ENEMY = "res//small_asteroid.gif";
	
	public double theta = 0.0;
	private String spritePath = null;
	
	private boolean isVisible = true;
	
	public Enemy(int x, int y,int s) {
		super(x, y,s);
		width = new ImageIcon(spritePath == null ? URL_IMAGE_PATH_ENEMY: spritePath).getImage().getWidth(null);
		height = new ImageIcon(spritePath == null ? URL_IMAGE_PATH_ENEMY: spritePath).getImage().getHeight(null);
	}
	public Enemy(int x, int y,int s,String sp){
		super(x,y,s);
		spritePath = sp;
		width = new ImageIcon(spritePath == null ? URL_IMAGE_PATH_ENEMY: spritePath).getImage().getWidth(null);
		height = new ImageIcon(spritePath == null ? URL_IMAGE_PATH_ENEMY: spritePath).getImage().getHeight(null);
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		theta += 0.1;
		move(null);
		super.draw(g2d, spritePath == null ? URL_IMAGE_PATH_ENEMY: spritePath);
		
		/*AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.1);
		g2d.setComposite(alpha);*/
	
	}

	@Override 
	public void move(KeyEvent e) {
		
		if(posX >= 0)
			posX-=defaultSpeed;
		else 
			isVisible = false;
	}
	
	public boolean isVisible(){
		return isVisible;
	}

}
