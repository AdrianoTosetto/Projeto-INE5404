import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Object implements Drawable{

	protected int posX;
	protected int posY;
	
	
	public Object(int x,int y){
		posX = x;
		posY = y;
	}
	public void draw(Graphics g, String path) {
		g.drawImage(new ImageIcon(path).getImage(),posX,posY,null);
	}
	@Override
	public void draw(Graphics g) {
		draw(g);	
	}
}
