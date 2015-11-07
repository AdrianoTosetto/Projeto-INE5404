import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Player extends Object implements Drawable{

	public Player(int x, int y) {
		super(x, y);
	}

	public static String URL_IMAGE_PATH_PLAYER = "res//ship.png";
	
	@Override
	public void draw(Graphics g) {
		super.draw(g, URL_IMAGE_PATH_PLAYER);
	}
	
}
