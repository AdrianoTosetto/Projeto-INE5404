import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Object implements Drawable{

	protected int posX;
	protected int posY;
	
	
	public Object(int x,int y){
		posX = x;
		posY = y;
	}
	public void draw(Graphics2D g, String path) {
		g.drawImage(new ImageIcon(path).getImage(),posX,posY,null);
	}
	@Override
	public void draw(Graphics g) {
		draw(g);	
	}
}
