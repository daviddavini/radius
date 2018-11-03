import java.awt.Graphics;

public class Pill {

	private float x;
	private float y;
	private float dx;
	private float dy;
	private float radius;
	private float maxSpeed;
	private boolean eaten;
	private boolean free;
	public Pill (int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.maxSpeed = 7;
		this.radius = radius;
		this.free = false;
	}
	public boolean offScreen(){
		if((x>=0-radius && x<=Resources.m.getWidth()+radius) &&
				(y>=0-radius && y<=Resources.m.getHeight()+radius)){
			return false;
		}else{
			return true;
		}
	}
	public boolean offMiddle(){
		if((x>0 && x<Resources.m.getWidth()) &&
				(y>0 && y<Resources.m.getHeight())){
			return false;
		}else{
			return true;
		}
	}
	public void collision(){
	}
	public void update() {
		x += dx;
		y += dy;
		if(eaten){
			x = -100;
			y = -100;
		}
		dx *= 1 + (Resources.m.bottle1.bottleNumb*(0.116/Resources.m.getWidth()))+.000999;
		dy *= 1 + (Resources.m.bottle1.bottleNumb*(0.087/Resources.m.getHeight()))+.000999;
		if(dx > maxSpeed){
			dx = maxSpeed;
		}else if(dy > maxSpeed){
			dy = maxSpeed;
		}if(dx < -maxSpeed){
			dx = -maxSpeed;
		}else if(dy < -maxSpeed){
			dy = -maxSpeed;
		}
		if(Resources.m.gameOver){
			dx = 0;
			dy = 0;
			if(Resources.m.frame%10==0){
				radius -= 1;
			}
		}
	}
	public void paint(Graphics g) {
		g.fillOval((int)(x)-(int)(radius), (int)(y)-(int)(radius),
					(int)(radius)*2, (int)(radius)*2);
	}

	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	public boolean isEaten() {
		return eaten;
	}
	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}
	public float getDx() {
		return dx;
	}
	public void setDx(double d) {
		this.dx = (float) d;
	}
	public float getDy() {
		return dy;
	}
	public void setDy(double d) {
		this.dy = (float) d;
	}
	public float getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	
	
}
