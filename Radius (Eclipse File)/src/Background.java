import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Background {
	static Random r = new Random();
	static int gameOverCount = 0;
	static int ballX = r.nextInt(Resources.m.getWidth()-50)+50;
	static int ballY = r.nextInt(Resources.m.getWidth()-50)+50;
	static int ballDx = r.nextInt(4)+1;
	static double ballDy = r.nextInt(4)+1;
	
	public Background() {
	}
	static void menupaint(Graphics g){
		
		g.setColor(new Color(240,250,250));
		g.fillRect(0, 0, Resources.m.getWidth(), Resources.m.getHeight());
		
		g.setFont(new Font("Courier",Font.BOLD,200));
		g.setColor(new Color(0,230,0));
		g.drawString("Radius", 46, 276);
		g.setColor(new Color(80,255,80));
		g.drawString("Radius", 40, 270);
		g.setFont(new Font("Courier",Font.ITALIC,32));
		g.setColor(Color.DARK_GRAY);
		g.drawString("(Press 'r' To Start Game)", 166, 386);
		g.setColor(Color.BLACK);
		g.drawString("(Press 'r' To Start Game)", 165, 385);
		
		g.setFont(new Font("Courier",Font.ITALIC,27));
		g.setColor(Color.BLACK);
		g.drawString("Good Pill", 115, 482);
		g.drawString("Bad Pill", 180, 531);
		g.drawString("Speed Pill", 428, 481);
		g.drawString("Checkpoint Pill", 500, 527);
		
		g.setColor(Color.GREEN);
		g.fillOval(70, 457, 33, 33);
		g.setColor(Color.RED);
		g.fillOval(135, 507, 30, 30);
		g.setColor(new Color(255,215,0));
		g.fillOval(398, 466, 15, 15);
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
		}g.fillOval(450, 503, 35, 35);
		g.setColor(Color.BLUE);
		g.fillOval(ballX, ballY, 50, 50);
		if(ballX<0 || ballX>Resources.m.getWidth()-50){
			ballDx *= -1;
		}if(ballY<0 || ballY>Resources.m.getHeight()-50){
			ballDy *= -1;
		}
		ballX += ballDx;
		ballY += ballDy;
	}
	static void paint(Graphics g){
		if(Resources.m.gameOver){
			g.setColor(Color.PINK);
			g.fillRect(0, 0, Resources.m.getWidth(),Resources.m.getHeight());
			g.setFont(new Font("Courier",Font.BOLD,150+gameOverCount*5/9));
			g.setColor(Color.GRAY);
			g.drawString(String.valueOf(Resources.m.bottle1.bottleNumb),
					10, Resources.m.getHeight()-11-(gameOverCount/7));
			g.setColor(Color.DARK_GRAY);
			g.drawString(String.valueOf(Resources.m.bottle1.bottleNumb),
					6, Resources.m.getHeight()-15-(gameOverCount/7));
			if(gameOverCount < 500){
				gameOverCount += 1;
			}
			g.setFont(new Font("Courier",Font.BOLD,110));
			g.setColor(Color.GRAY);;
			g.drawString(String.valueOf(Resources.m.bottle1.numbOfGreenEaten), 5, 85);
			g.setColor(Color.LIGHT_GRAY);
			g.drawString(String.valueOf(Resources.m.bottle1.numbOfGreenEaten), 1, 82);
			
			g.setFont(new Font("Courier",Font.ITALIC,32));
			g.setColor(Color.DARK_GRAY);;
			g.drawString("(Press 'r' To Return To Checkpoint)", Resources.m.getWidth()-676,60);
			g.setColor(Color.GRAY);
			g.drawString("(Press 'r' To Return To Checkpoint)", Resources.m.getWidth()-677,59);
			
			g.setFont(new Font("Courier",Font.BOLD,50));
			g.setColor(Color.DARK_GRAY);
			g.drawString(String.valueOf(Resources.m.checkpoint),
					Resources.m.getWidth()-113, Resources.m.getHeight()-11);
			g.setColor(Color.GRAY);
			g.drawString(String.valueOf(Resources.m.checkpoint),
					Resources.m.getWidth()-115, Resources.m.getHeight()-13);
			g.setFont(new Font("Courier",Font.BOLD,20));
			g.setColor(Color.DARK_GRAY);
			g.drawString("Checkpoint:",
					Resources.m.getWidth()-134, Resources.m.getHeight()-49);
			g.setColor(Color.GRAY);
			g.drawString("Checkpoint:",
					Resources.m.getWidth()-135, Resources.m.getHeight()-50);
			
			g.setFont(new Font("Courier",Font.BOLD,20));
			g.setColor(Color.DARK_GRAY);
			if(Resources.m.player1.getSpeed()<8){
				g.drawString(String.valueOf((int)((2*Resources.m.player1.getSpeed())-5)),
						Resources.m.getWidth()-47, Resources.m.getHeight()-72);
				g.setColor(Color.GRAY);
				g.drawString(String.valueOf((int)((2*Resources.m.player1.getSpeed())-5)),
						Resources.m.getWidth()-48, Resources.m.getHeight()-73);
			}else{
				g.drawString(String.valueOf("MAX"),
						Resources.m.getWidth()-47, Resources.m.getHeight()-72);
				g.setColor(Color.GRAY);
				g.drawString(String.valueOf("MAX"),
						Resources.m.getWidth()-48, Resources.m.getHeight()-73);
			
			}g.setColor(Color.DARK_GRAY);
			g.drawString("Speed:",
					Resources.m.getWidth()-138, Resources.m.getHeight()-72);
			g.setColor(Color.GRAY);
			g.drawString("Speed:",
					Resources.m.getWidth()-139, Resources.m.getHeight()-73);
		}else{
			g.setFont(new Font("Courier",Font.BOLD,150));
			g.setColor(Color.GRAY);
			g.drawString(String.valueOf(Resources.m.bottle1.bottleNumb),
					4, Resources.m.getHeight()-11);
			g.setColor(Color.DARK_GRAY);
			g.drawString(String.valueOf(Resources.m.bottle1.bottleNumb),
					0, Resources.m.getHeight()-15);
			g.setFont(new Font("Courier",Font.BOLD,110));
			g.setColor(Color.BLUE);;
			g.drawString(String.valueOf(Resources.m.bottle1.numbOfGreenEaten), 5, 85);
			g.setColor(Color.CYAN);
			g.drawString(String.valueOf(Resources.m.bottle1.numbOfGreenEaten), 1, 82);
			
			g.setFont(new Font("Courier",Font.BOLD,50));
			g.setColor(Color.GRAY);
			g.drawString(String.valueOf(Resources.m.checkpoint),
					Resources.m.getWidth()-113, Resources.m.getHeight()-11);
			g.setColor(Color.DARK_GRAY);
			g.drawString(String.valueOf(Resources.m.checkpoint),
					Resources.m.getWidth()-115, Resources.m.getHeight()-13);
			g.setFont(new Font("Courier",Font.BOLD,20));
			g.setColor(Color.GRAY);
			g.drawString("Checkpoint:",
					Resources.m.getWidth()-139, Resources.m.getHeight()-49);
			g.setColor(Color.DARK_GRAY);
			g.drawString("Checkpoint:",
					Resources.m.getWidth()-140, Resources.m.getHeight()-50);
			
			g.setFont(new Font("Courier",Font.BOLD,20));
			g.setColor(Color.GRAY);
			if(Resources.m.player1.getSpeed()<8){
				g.drawString(String.valueOf((int)((2*Resources.m.player1.getSpeed())-5)),
						Resources.m.getWidth()-47, Resources.m.getHeight()-72);
				g.setColor(Color.DARK_GRAY);
				g.drawString(String.valueOf((int)((2*Resources.m.player1.getSpeed())-5)),
						Resources.m.getWidth()-48, Resources.m.getHeight()-73);
			}else{
				g.drawString(String.valueOf("MAX"),
						Resources.m.getWidth()-47, Resources.m.getHeight()-72);
				g.setColor(Color.DARK_GRAY);
				g.drawString(String.valueOf("MAX"),
						Resources.m.getWidth()-48, Resources.m.getHeight()-73);
			
			}
			g.setColor(Color.GRAY);
			g.drawString("Speed:",
					Resources.m.getWidth()-138, Resources.m.getHeight()-72);
			g.setColor(Color.DARK_GRAY);
			g.drawString("Speed:",
					Resources.m.getWidth()-139, Resources.m.getHeight()-73);
			
			}
		
	}
}
