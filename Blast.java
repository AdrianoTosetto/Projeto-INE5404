import java.awt.Graphics;
import java.awt.Graphics2D;


public class Blast extends Object{

	public Blast(int x, int y,int s) {
		super(x, y,s);
	}

	public int timeInScreen = 70;
	
	String URL_IMAGE_PATH_BLAST = "res//explosao_02.gif";
	
	public void draw(Graphics g){
		super.draw((Graphics2D)g,URL_IMAGE_PATH_BLAST);
	}
	
	void setPosition(int x,int y){
		posX = x;
		posY = y;
	}
}
