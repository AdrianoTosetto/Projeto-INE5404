import javax.swing.ImageIcon;


public class SShipTank extends SShip{

	public SShipTank(int x, int y, int s) {
		super(x, y, s);
		urlPath = "res//sShip_tank.png";
		height = new ImageIcon(urlPath).getImage().getHeight(null);
		width  = new ImageIcon(urlPath).getImage().getWidth(null);
	}

}
