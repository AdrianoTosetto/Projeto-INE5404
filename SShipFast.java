import javax.swing.ImageIcon;


public class SShipFast extends SShip{
	
	public SShipFast(int x, int y) {
		super(x, y, 15);
		urlPath = "res//sShip_speed.png";
		height = new ImageIcon(urlPath).getImage().getHeight(null);
		width  = new ImageIcon(urlPath).getImage().getWidth(null);
	}
}
