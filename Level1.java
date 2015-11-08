import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Level1 extends JPanel{

	public Level1(Player p, ArrayList<Enemy> e){
		player = p;
		enemies = e;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String BACKGROUND_IMAGE_PATH = "res//background.png";
	private Player player;
	 ArrayList<Enemy> enemies;
	 
	 
	public void paint(Graphics g){
		Graphics2D gd2 = (Graphics2D)g;
		gd2.drawImage(new ImageIcon(BACKGROUND_IMAGE_PATH).getImage(),0,0,null);
		
		player.draw(gd2);
		player.drawBullets(gd2);
		
		for(int i = 0; i < enemies.size();i++){
			enemies.get(i).draw(gd2);
		}
		Game.hb.draw(g);
		
		g.dispose();
	}
	
	void update(Player p, ArrayList<Enemy> e){
		player = p;
		enemies = e;
	}
}
