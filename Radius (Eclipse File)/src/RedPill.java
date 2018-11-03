import java.awt.Color;
import java.awt.Graphics;


public class RedPill extends Pill{

	public RedPill(int x, int y, int radius) {
		super(x, y, radius);
	}
	public void collision(){
		Resources.m.player1.setRadius((float) (Resources.m.player1.getRadius() - 4));
		Resources.hit_red.play();
		setEaten(true);
	}
	@Override
	public void update() {
		super.update();
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		super.paint(g);
	}
	
}
