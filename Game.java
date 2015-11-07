import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame{

	
	private Player player;
	private Level1 level;
	
	private ArrayList<Enemy> gameEnemies = new ArrayList<Enemy>();
	
	private Timer gameTimer;
	
	public static int DEFAULT_FRAME = 100;
	static int x = 100;
	
	public Game(Player p,Level1 l){
		level = l;
		player = p;
		setSize(500,500);
		add(level);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		 gameTimer = new Timer();
		 gameTimer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				level.revalidate();
				level.repaint();
				System.out.println("hue");
				Game.x++;
			}
		},1, 1000);

	}
	
	public static void main(String[] args){
	
		
		new Game(new Player(10,10),new Level1());
	}
}
