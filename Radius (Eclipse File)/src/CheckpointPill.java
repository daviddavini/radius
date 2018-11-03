import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class CheckpointPill extends Pill{
	Random r = new Random();
	public CheckpointPill(int x, int y, int radius) {
		super(x, y, radius);
	}
	public void collision(){
		Resources.hit_checkpoint.play();
		Resources.m.checkpoint=Resources.m.bottle1.bottleNumb;
		Resources.m.checkpointSpeed=Resources.m.player1.getSpeed();
		setEaten(true);
	}
	@Override
	public void update() {
		super.update();
	}
	public void paint(Graphics g) {
		switch(r.nextInt(8)){
		case 0:
			g.setColor(Color.PINK);
			break;
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.ORANGE);
			break;
		case 3:
			g.setColor(Color.YELLOW);
			break;
		case 4:
			g.setColor(Color.GREEN);
			break;
		case 5:
			g.setColor(Color.CYAN);
			break;
		case 6:
			g.setColor(Color.BLUE);
			break;
		case 7:
			g.setColor(Color.MAGENTA);
			break;
		}
		super.paint(g);
	}
}
