import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Level1 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String BACKGROUND_IMAGE_PATH;
	
	
	public void paint(Graphics g){
		Graphics2D gd2 = (Graphics2D)g;
		new Player(Game.x,10).draw(gd2);
		new Enemy(100,100).draw(gd2);
		g.dispose();
	}
}
