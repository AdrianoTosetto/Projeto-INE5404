import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class HealthBar implements Drawable{

	private int posX;
	private int posY;
	private final int height = 40;
	private int width = 200;
	
	
	public HealthBar(int x,int y) {
		posX = x;
		posY = y;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.fillRect(posX, posY, 200, 40);
		g2d.setColor(Color.GREEN);
		g2d.fillRect(posX, posY, width, height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Tahoma",100,20));
		g2d.drawString(Integer.toString(width),posX + 80, posY + 30);
	}
	
	public void update(int w){
		width = w;
	}
	public int getW(){
		return width;
	}
	
}
