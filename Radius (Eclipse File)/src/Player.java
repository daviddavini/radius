import java.awt.Color;
import java.awt.Graphics;

public class Player {

	float x;
	float y;
	float dx;
	float dy;
	float radius;
	float speed;
	float maxSpeed;

	public Player(int x, int y, int radius, double speed) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.radius = radius;
		this.speed = (float) speed;
		this.maxSpeed = 8;

	}

	public void update(){
		x += dx;
		y += dy;
		if(Resources.m.gameOver){
			dx = 0;
			dy = 0;
			radius += 1;
			if(Resources.m.frame%4==0){
				radius -= 5;
			}
		}
		if(radius<2){
			Resources.m.gameOver = true;
		}else if(radius>25){
			radius = 25;
		}
		if(x<=45){
			x = 46;
		}else if(x>=Resources.m.getWidth()-45){
			x = Resources.m.getWidth()-46;
		}if(y<=45){
			y = 46;
		}else if(y>=Resources.m.getHeight()-45){
			y = Resources.m.getHeight()-46;
		}if(speed>maxSpeed){
			speed = maxSpeed;
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval((int)(x)-(int)(radius), (int)(y)-(int)(radius),
				(int)(radius)*2, (int)(radius)*2);
	}
	
	public void moveLeft(){
		this.dx = -speed;
	}
	public void moveRight(){
		this.dx = speed;
	}
	public void moveUp(){
		this.dy = -speed;
	}
	public void moveDown(){
		this.dy = speed;
	}
	public void stopLeft(){
		this.dx = 0;
	}
	public void stopRight(){
		this.dx = 0;
	}
	public void stopUp(){
		this.dy = 0;
	}
	public void stopDown(){
		this.dy = 0;
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
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public float getspeed() {
		return speed;
	}

	public void setspeed(float speed) {
		this.speed = speed;
	}

	
}
