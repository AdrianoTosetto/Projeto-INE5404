import java.awt.Graphics;


public class Enemy extends Object implements Drawable{

	public static String URL_IMAGE_PATH_ENEMY = "res//giulio2.png";
	
	public Enemy(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g, URL_IMAGE_PATH_ENEMY);
	}

}
