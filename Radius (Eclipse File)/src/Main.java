import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Main extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	
	//Variables
	Player player1;
	Bottle bottle1;
	boolean gameOver;
	int frame;
	int checkpoint;
	float checkpointSpeed;
	boolean menu;
	
	YellowPill p;
	@Override
	public void init() {
		setSize(800,600);
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		new Resources(this);
		menu = true;
		Resources.intro_theme.play();
		player1 = new Player(200,400,25, 3);
		checkpoint = 1;
		checkpointSpeed = (float) 3.0;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void start() {
		bottle1 = new Bottle(checkpoint);
		frame = 0;
		new Background();
		Resources.fail_played = false;
		player1 = new Player(200,400, 25, checkpointSpeed);
		gameOver = false;
	}
	
	@Override
	public void run() {
		while (true){
			if(!menu){
				if(gameOver&&!Resources.fail_played){
					Resources.fail_level.play();
					Resources.fail_played = true;
				}
				player1.update();
				bottle1.update();
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		if(menu){
			Background.menupaint(g);
		}else{
			Background.paint(g);
			player1.paint(g);
			bottle1.paint(g);
		}
	}
	
//Double Buffer
	private Image i;
	private Graphics doubleG;
	@Override
	public void update(Graphics g) {
		if(i == null){
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0,  0,  this.getSize().width, this.getSize().height);
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void stop() {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	
//Key And Mouse Interactions
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			player1.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			player1.moveRight();
			break;
		case KeyEvent.VK_UP:
			player1.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			player1.moveDown();
			break;
		case KeyEvent.VK_A:
			player1.moveLeft();
			break;
		case KeyEvent.VK_D:
			player1.moveRight();
			break;
		case KeyEvent.VK_W:
			player1.moveUp();
			break;
		case KeyEvent.VK_S:
			player1.moveDown();
			break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			player1.stopLeft();
			break;
		case KeyEvent.VK_RIGHT:
			player1.stopRight();
			break;
		case KeyEvent.VK_UP:
			player1.stopUp();
			break;
		case KeyEvent.VK_DOWN:
			player1.stopDown();
			break;
		case KeyEvent.VK_A:
			player1.stopLeft();
			break;
		case KeyEvent.VK_D:
			player1.stopRight();
			break;
		case KeyEvent.VK_W:
			player1.stopUp();
			break;
		case KeyEvent.VK_S:
			player1.stopDown();
			break;
		case KeyEvent.VK_R:
			if(menu){
				menu = false;
				start();
				Resources.intro_theme.stop();
			}else if(gameOver){
				start();
			}
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
