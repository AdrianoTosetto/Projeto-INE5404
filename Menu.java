import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Menu extends JPanel{
	
	private String[] shipOptions = {"Ship 1","Ship 2"};
	private String[] stageOptions = {"Stage 1","Stage 2","Stage 3"};
	private String[] difficulty  = {"Easy","Normal","Hard"};
	
	private JComboBox<String> chooseStage = new JComboBox<String>(stageOptions);
	private JComboBox<String> chooseShip = new JComboBox<String>(shipOptions);
	private JComboBox chooseDifficulty = new JComboBox<>(difficulty); 
	
	private JLabel showVolumeValue = new JLabel("0",JLabel.CENTER);
	
	private JSlider volume = new JSlider(0, 100, 1);
	
	private JButton ok = new JButton("Ok");
	
	JPanel container = new JPanel();
	
	public Menu(){
		setSize(400,400);
		
		add(chooseShip);
		GridLayout gridLayout = new GridLayout(6,1);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		
		container.setLayout(gridLayout);
		container.add(chooseShip);
		container.add(chooseStage);
		container.add(chooseDifficulty);
		container.add(volume);
		container.add(showVolumeValue);
		ok.setPreferredSize(new Dimension(30,30));
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		container.add(ok);
		volume.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				showVolumeValue.setText(Integer.toString(volume.getValue()));
			}
		});
		add(container);
		setVisible(true);
	}
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.add(new Menu());
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void initComponents(){
		
	}
	
}
