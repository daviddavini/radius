import java.awt.Color;
import java.awt.Graphics;

public class GreenPill extends Pill{

	public GreenPill(int x, int y, int radius) {
		super(x, y, radius);
	}
	@Override
	public void collision() {
		Resources.hit_green.play();
		Resources.m.player1.setRadius((float) (Resources.m.player1.getRadius() + 0.5));
		setEaten(true);
		Resources.m.bottle1.numbOfGreenEaten++;
	}
	@Override
	public void update() {
		super.update();
	}
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		super.paint(g);
	}
}
