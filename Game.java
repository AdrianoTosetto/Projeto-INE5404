import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame implements KeyListener{

	private ArrayList<Enemy> gameEnemies = new ArrayList<Enemy>();
	static Player player = new Player(10,10);
	private Level1 level = new Level1(player,gameEnemies);
	static HealthBar hb = new HealthBar(1, 420);
	
	private Timer gameTimer;
	
	public static int DEFAULT_FRAME = 100;
	static int x = 100;
	
	public static void main(String[] args){
	
		
		new Game(new Player(10,10),new Level1(null,null));
	}
	
	
	
	public Game(Player p,Level1 l){
		setSize(500,500);
		add(level);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				player.shoot(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				player.move(e);
			}
		});
		
		 gameTimer = new Timer();
		 gameTimer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				level.revalidate();
				level.repaint();
				generateEnemies();
				updateMissiles();
				updateEnemies();
				//hb.update(hb.getW() - 1);
				
			}
		},5, 10);

	}
	
	private void updateMissiles(){
		
		ArrayList<Bullet> bullets = player.getMissiles();
		
		for(int i = 0; i < bullets.size();i++){
			if(!bullets.get(i).isVisible()){
				player.bullets.remove(i);
			}
		}
	}
	private void updateEnemies(){
		for(int i = 0; i < gameEnemies.size();i++){
			if(!gameEnemies.get(i).isVisible()){
				gameEnemies.remove(i);
			}
		}
	}
	private void generateEnemies(){
		if(gameEnemies.size() < 20){
			gameEnemies.add(new Enemy((new Random().nextInt(500)) + 500,new Random().nextInt(500)));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
