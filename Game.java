
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame implements KeyListener{

	private ArrayList<Enemy> gameEnemies = new ArrayList<Enemy>();
	static SShipFast fastShip = new SShipFast(10,10);
	private Level1 level = new Level1(fastShip,gameEnemies);
	static HealthBar hb = new HealthBar(1, 420);
	static GameStates gameStates = GameStates.INGAME;
	private Audio gameAudio = new Audio("brickHit.wav");
	private Audio soundEffects = new Audio("explosion.wav");
	private Timer gameTimer;
	
	public static int DEFAULT_FRAME = 100;
	static int x = 100;
	
	static ArrayList<Blast> b = new ArrayList<Blast>();
	public static void main(String[] args){
		
		Level1 l;
		new Game(fastShip,new Level1(null,null));
	}
	
	
	
	public Game(SShip p,Level1 l){
		setSize(500,500);
		setResizable(false);
		setFocusable(true);
		add(level);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				fastShip.shoot(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				fastShip.move(e);
				if(e.getKeyCode() == KeyEvent.VK_P){
					if(gameStates == GameStates.INGAME)
						gameStates = GameStates.PAUSED;
					else
						gameStates = GameStates.INGAME;
					
				}
			}
		});
		
		 gameTimer = new Timer();
		 gameTimer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				if(gameStates == GameStates.INGAME){
				//	gameAudio.play();
					new SoundMeter();
					level.revalidate();
					level.repaint();
					ArrayList<Bullet> bullets = fastShip.getMissiles();
					
					for(int i = 0; i < gameEnemies.size();i++){
						Rectangle r1 = gameEnemies.get(i).getBounds();
						if(r1.intersects(fastShip.getBounds())){
							//soundEffects.stop();
							//soundEffects.play();
							fastShip.setHealth(fastShip.getHealth() - 2);
							if(fastShip.getHealth() < 0){
								//gameStates = GameStates.PAUSED;
							}
							Blast blast = new Blast(((int)r1.getX())-40,(int)r1.getY(),10);
							blast.timeInScreen = 20;
							b.add(blast);
							hb.update(hb.getW() - 2);
							gameEnemies.remove(i);
						
						}
					}
					
					for(int i = 0; i < bullets.size();i++){
						
						Rectangle r1 = bullets.get(i).getBounds();
						
						for(int j = 0; j < gameEnemies.size();j++){
							
							Rectangle r2 = gameEnemies.get(j).getBounds();
							
							if(r1.intersects(r2)){
								soundEffects.stop();
								soundEffects.play();
								b.add(new Blast((int)r1.getX(),(int)r2.getY(),0));
								Enemy tmp = gameEnemies.get(j);
								gameEnemies.remove(tmp);
								try{
									bullets.remove(i);
								}catch(Exception e){
									
								}
								if(tmp instanceof BigAsteroid){
									gameEnemies.add(new LitteAsteroid(
											tmp.getPosX() - 10,
											tmp.getPosY() - 10,
											1
									));
									gameEnemies.add(new LitteAsteroid(
											tmp.getPosX() - 15,
											tmp.getPosY() + 10,
											2
									));
									gameEnemies.add(new LitteAsteroid(
											tmp.getPosX() - 20,
											tmp.getPosY() - 30,
											3
									));
									gameEnemies.add(new LitteAsteroid(
											tmp.getPosX() - 10,
											tmp.getPosY() - 35,
											3
									));
									gameEnemies.add(new LitteAsteroid(
											tmp.getPosX() - 2,
											tmp.getPosY() - 10,
											3
									));
								}
							}
						}
					}
					generateEnemies();
					updateMissiles();
					updateEnemies();	
					for(int i = 0; i < b.size();i++){
						if(b.get(i).timeInScreen != 0)b.get(i).timeInScreen--;
						else b.remove(i);
					}
					System.out.println(gameEnemies.size());
					//b.setPosition(600,600);
				}else{
					soundEffects.stop();
				}
			}
			
		},5, 10);

	}
	
	private void updateMissiles(){
		
		ArrayList<Bullet> bullets = fastShip.getMissiles();
		
		for(int i = 0; i < bullets.size();i++){
			if(!bullets.get(i).isVisible()){
				fastShip.bullets.remove(i);
			}
		}
	}
	private void updateEnemies(){
		for(int i = 0; i < gameEnemies.size();i++){
			if(!gameEnemies.get(i).isVisible()){
				gameEnemies.remove(i);
				//gameEnemies.add(new Enemy());
			}
		}
	}
	private void generateEnemies(){
		if(gameEnemies.size() < 25){
			gameEnemies.add(new BigAsteroid((
						new Random().nextInt(500)) + 500,
						new Random().nextInt(500),
						new Random().nextInt(5) + 1
					));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
