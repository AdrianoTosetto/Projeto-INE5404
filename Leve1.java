import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Level1 extends JPanel{

	public Level1(SShip p, ArrayList<Enemy> e){
		player = p;
		enemies = e;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String BACKGROUND_IMAGE_PATH = "res//background.png";
	private SShip player;
	 ArrayList<Enemy> enemies;
	 
	 
	public void paint(Graphics g){
		//if(Game.gameStates == GameStates.PAUSED)
		//	g.drawString("PAUSED", 10, 10);
		Graphics2D gd2 = (Graphics2D)g;
		gd2.drawImage(new ImageIcon(BACKGROUND_IMAGE_PATH).getImage(),0,0,null);
		
		player.	draw(gd2);
		player.drawBullets(gd2);
		for(int i = 0; i < Game.b.size();i++){
			if(Game.b.get(i).timeInScreen != 0)Game.b.get(i).draw(g);;
		}
		for(int i = 0; i < player.getMissiles().size();i++){
			player.getMissiles().get(i).getBounds(gd2);
		}
		for(int i = 0; i < enemies.size();i++){
			enemies.get(i).draw(gd2);
			//enemies.get(i).getBounds(gd2);
		}
		Game.hb.draw(g);
		
		g.dispose();
	}
	
	void update(SShip p, ArrayList<Enemy> e){
		player = p;
		enemies = e;
	}
}
