import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player extends Object implements Drawable,Movable{

	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	private boolean missileOnLeft = true;
	
	private int health = 100;
	
	private double theta = 0.0;
	
	public Player(int x, int y) {             
		super(x, y);
	}

	public static String URL_IMAGE_PATH_PLAYER = "res//ship.png";
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(theta);
		super.draw(g2d, URL_IMAGE_PATH_PLAYER);
		g2d.rotate(-theta);
	}
	
	public void shoot(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(missileOnLeft){
				bullets.add(new Bullet(posX,posY + 30,theta));
				missileOnLeft = !missileOnLeft;
			}else{
				bullets.add(new Bullet(posX,posY,theta));
				missileOnLeft = !missileOnLeft;
			}
			
		}
	}
	public void move(KeyEvent e){
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			posY-=3;
		break;
		case KeyEvent.VK_DOWN:
			posY+=3;
		break;
		case KeyEvent.VK_LEFT:
			posX-=3;
			//theta+=0.1;
		break;
		case KeyEvent.VK_RIGHT:
			//theta-=0.1;
			posX+=3;
		break;
	
		default:
			break;
		}
	}
	
	public void drawBullets(Graphics g){
		for(int i = 0; i < bullets.size();i++){
			bullets.get(i).draw(g);
		}
	}
	public ArrayList<Bullet> getMissiles(){
		return bullets;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
