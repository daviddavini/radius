import java.awt.Color;
import java.awt.Graphics;


public class YellowPill extends Pill{

	public YellowPill(int x, int y, int radius) {
		super(x, y, radius);
		setMaxSpeed(10);
	}
	
	@Override
	public void collision() {
		Resources.hit_yellow.play();
		setEaten(true);
		Resources.m.player1.setSpeed((float) (Resources.m.player1.getSpeed()+0.5));
	}
	public void update() {
		super.update();
		setDx(getDx()*1.03125);
		setDy(getDy()*1.03125);
	}
	public void paint(Graphics g) {
		g.setColor(new Color(255,215,0));
		super.paint(g);
	}
}
