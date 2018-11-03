import java.awt.Graphics;
import java.util.Random;

public class Bottle {
	Random r = new Random();
	Pill[] pills;
	int bottleNumb;
	int numbOfGreenEaten;
	int currentPill;
	
	public Bottle (int botNumb){
		spawnNewPills(botNumb);
	}
	public void spawnNewPills(int botNumb) {
		numbOfGreenEaten = 0;
		currentPill = 0;
//EDIT
		pills = new Pill[botNumb*2 + r.nextInt((int)(botNumb))];
		this.bottleNumb = botNumb;
		if(!Resources.m.menu){
			if(bottleNumb%6==0 && !(bottleNumb%10==0) && !Resources.half2_playing){
				Resources.evil_theme.stop();
				Resources.evil_playing = false;
				Resources.half1_theme.stop();
				Resources.half1_playing = false;
				Resources.main_theme.stop();
				Resources.main_playing = false;
				Resources.half2_theme.loop();
				Resources.half2_playing = true;
			}else if(bottleNumb%10==0 && !(bottleNumb%6==0) && !Resources.half1_playing){
				Resources.half2_theme.stop();
				Resources.half2_playing = false;
				Resources.evil_theme.stop();
				Resources.evil_playing = false;
				Resources.main_theme.stop();
				Resources.main_playing = false;
				Resources.half1_theme.loop();
				Resources.half1_playing = true;
			}else if((bottleNumb%6==0 && bottleNumb%10==0) && !Resources.evil_playing){
				Resources.half2_theme.stop();
				Resources.half2_playing = false;
				Resources.half1_theme.stop();
				Resources.half1_playing = false;
				Resources.main_theme.stop();
				Resources.main_playing = false;
				Resources.evil_theme.loop();
				Resources.evil_playing = true;
			}else if(!(bottleNumb%6==0) && !(bottleNumb%10==0) && (!Resources.main_playing)){
				Resources.half2_theme.stop();
				Resources.half2_playing = false;
				Resources.evil_theme.stop();
				Resources.evil_playing = false;
				Resources.half1_theme.stop();
				Resources.half1_playing = false;
				Resources.main_theme.loop();
				Resources.main_playing = true;
			}
		}
		for(int i = 0; i < pills.length; i++){
			switch (r.nextInt(4)) {
			case 0: //TOP POSITION
				pills[i] = new RedPill(r.nextInt(Resources.m.getWidth()-200)+100, 0,
						r.nextInt(10)+10);
				break;
			case 1: //BOTTOM POSITION
				pills[i] = new RedPill(r.nextInt(Resources.m.getWidth()-200)+100, Resources.m.getHeight(),
						r.nextInt(10)+10);
				break;
			case 2: //LEFT POSITION
				pills[i] = new RedPill(0, r.nextInt(Resources.m.getHeight()-200)+100,
						r.nextInt(10)+10);
				break;
			case 3: //LEFT POSITION
				pills[i] = new RedPill(Resources.m.getWidth(), r.nextInt(Resources.m.getHeight()-200)+100,
						r.nextInt(10)+10);
				break;
			}
		}
		//YELLOW PILLS
		for(int i = 0; i < pills.length; i++){
			if(r.nextInt((int) (bottleNumb*1.5))==0){
				switch (r.nextInt(4)) {
				case 0: //TOP POSITION
					pills[i] = new YellowPill(r.nextInt(Resources.m.getWidth()-200)+100, 0,
							r.nextInt(5)+7);
					break;
				case 1: //BOTTOM POSITION
					pills[i] = new YellowPill(r.nextInt(Resources.m.getWidth()-200)+100, Resources.m.getHeight(),
							r.nextInt(5)+7);
					break;
				case 2: //LEFT POSITION
					pills[i] = new YellowPill(0, r.nextInt(Resources.m.getHeight()-200)+100,
							r.nextInt(5)+7);
					break;
				case 3: //LEFT POSITION
					pills[i] = new YellowPill(Resources.m.getWidth(), r.nextInt(Resources.m.getHeight()-200)+100,
							r.nextInt(5)+7);
					break;
				}
			}
		}
		int numbOfGreens = 0;
		while(numbOfGreens != bottleNumb){
			int nextGreen;
			do{
				nextGreen = r.nextInt(pills.length);
			}while(pills[nextGreen].getClass().getName()=="GreenPill");
			switch(r.nextInt(4)){
			case 0:
				pills[nextGreen] = new GreenPill(r.nextInt(Resources.m.getWidth()-200)+100, 0,
						r.nextInt(10)+10);
				break;
			case 1:
				pills[nextGreen] = new GreenPill(r.nextInt(Resources.m.getWidth()-200)+100, Resources.m.getHeight(),
						r.nextInt(10)+10);
				break;
			case 2:
				pills[nextGreen] = new GreenPill(0, r.nextInt(Resources.m.getHeight()-200)+100,
						r.nextInt(10)+10);
				break;
			case 3:
				pills[nextGreen] = new GreenPill(Resources.m.getWidth(), r.nextInt(Resources.m.getHeight()-200)+100,
						r.nextInt(10)+10);
				break;
			}
			numbOfGreens++;
		}
		//CHECKPOINT PILLS
				if((bottleNumb%3==0) && !(bottleNumb%30==0)){
					int i;
					do{
						i = r.nextInt(pills.length-2)+2;
					}while(pills[i].getClass().getName()=="GreenPill");
					pills[i] = new CheckpointPill(r.nextInt(600)+100, 0,
							r.nextInt(5)+7);
					switch (r.nextInt(4)) {
					case 0: //TOP POSITION
						pills[i] = new CheckpointPill(r.nextInt(Resources.m.getWidth()-200)+100, 0,
								r.nextInt(10)+10);
						break;
					case 1: //BOTTOM POSITION
						pills[i] = new CheckpointPill(r.nextInt(Resources.m.getWidth()-200)+100, Resources.m.getHeight(),
								r.nextInt(10)+10);
						break;
					case 2: //LEFT POSITION
						pills[i] = new CheckpointPill(0, r.nextInt(Resources.m.getHeight()-200)+100,
								r.nextInt(10)+10);
						break;
					case 3: //LEFT POSITION
						pills[i] = new CheckpointPill(Resources.m.getWidth(), r.nextInt(Resources.m.getHeight()-200)+100,
								r.nextInt(10)+10);
						break;
					}
				}
	}
	public void update() {
		for(int i = 0; i < pills.length; i++) {
			pills[i].update();
		}
		checkForCollisions();

		double chance = ((bottleNumb*bottleNumb)/100)-((bottleNumb*105)/71)+85;
		if(chance<36){
			chance = 36;
		}if(currentPill<pills.length){
			if (pills[currentPill].getClass().getName()=="GreenPill"){
				chance *= 2.5;
			}
		}
		boolean allOffMiddle = true;
		for(int i = 0; i < pills.length; i++){
			if(!pills[i].offMiddle()){
				allOffMiddle = false;
			}
		}if(allOffMiddle){
			chance = 30;
		}
		if(r.nextInt((int)(chance))==0 && currentPill<pills.length){
			if(bottleNumb%6==0 && pills[currentPill].isFree()==false){
				pills[currentPill].setFree(true);
				//TOP
				if(pills[currentPill].getY()==0){
					if(pills[currentPill].getX()>=Resources.m.getWidth()/2){
						pills[currentPill].setDy(1.3);
						pills[currentPill].setDx(-((r.nextInt(67)/100)+0.67));
					}else{
						pills[currentPill].setDy(1.3);
						pills[currentPill].setDx(((r.nextInt(67)/100)+0.67));
					}
				//BOTTOM
				}else if(pills[currentPill].getY()==Resources.m.getHeight()){
					if(pills[currentPill].getX()>=Resources.m.getWidth()/2){
						pills[currentPill].setDy(-1.3);
						pills[currentPill].setDx(-((r.nextInt(67)/100)+0.67));
					}else{
						pills[currentPill].setDy(-1.3);
						pills[currentPill].setDx(((r.nextInt(67)/100)+0.67));
					}
				//LEFT
				}else if(pills[currentPill].getX()==0){
					if(pills[currentPill].getY()>=Resources.m.getHeight()/2){
						pills[currentPill].setDx(1.3);
						pills[currentPill].setDy(-((r.nextInt(67)/100)+0.67));
					}else{
						pills[currentPill].setDx(1.3);
						pills[currentPill].setDy(((r.nextInt(67)/100)+0.67));
					}
				//RIGHT
				}else if(pills[currentPill].getX()==Resources.m.getWidth()){
					if(pills[currentPill].getY()>=Resources.m.getHeight()/2){
						pills[currentPill].setDx(-1.3);
						pills[currentPill].setDy(-((r.nextInt(67)/100)+0.67));
					}else{
						pills[currentPill].setDx(-1.3);
						pills[currentPill].setDy(((r.nextInt(67)/100)+0.67));
					}
				}
				currentPill++;
			}else if(pills[currentPill].isFree()==false){
				pills[currentPill].setFree(true);
				//TOP
				if(pills[currentPill].getY()==0){
					pills[currentPill].setDy(1.3);
					currentPill++;
				//BOTTOM
				}else if(pills[currentPill].getY()==Resources.m.getHeight()){
					pills[currentPill].setDy(-1.3);
					currentPill++;
				//LEFT
				}else if(pills[currentPill].getX()==0){
					pills[currentPill].setDx(1.3);
					currentPill++;
				//RIGHT
				}else if(pills[currentPill].getX()==Resources.m.getWidth()){
					pills[currentPill].setDx(-1.3);
					currentPill++;
				}
			}
		}
		boolean allOffScreen= true;
		for(int i = 0; i < pills.length; i++){
			if(!pills[i].offScreen()){
				allOffScreen = false;
			}else if (pills[i].getClass().getName() == "GreenPill" && !pills[i].isEaten()){
				Resources.m.gameOver = true;
			}
		}
	//LEVEL 5 SETS
		if(bottleNumb%10 == 0){
			for(int i = 0; i < pills.length; i++){
				if(pills[i].offScreen() && pills[i].getClass().getName() == "RedPill" 
						&& pills[i].isFree() && numbOfGreenEaten!=bottleNumb){
					if(pills[i].getX()<=0){
						pills[i].setDx(0.6);
					}else if(pills[i].getX()>=Resources.m.getWidth()){
						pills[i].setDx(-0.6);
					}if(pills[i].getY()<=0){
						pills[i].setDy(0.6);
					}else if(pills[i].getY()>=Resources.m.getHeight()){
						pills[i].setDy(-0.6);
					}
					pills[i].setMaxSpeed((float) 0.68);
					System.out.println(pills[i].getMaxSpeed());
				}
			}
		}
		if(numbOfGreenEaten==bottleNumb){
			if(allOffScreen){
				Resources.next_level.play();
				spawnNewPills(bottleNumb+1);
			}
		}
	}
	public void checkForCollisions(){
		for(int p1 = 0; p1 < pills.length; p1++) {
			//ONE PILL ONE PLAYER
			int a = (int)(pills[p1].getX())-(int)(Resources.m.player1.getX());
			int b = (int)(pills[p1].getY())-(int)(Resources.m.player1.getY());
			float c = (float) Math.sqrt((a*a)+(b*b));
			if(c < pills[p1].getRadius()+Resources.m.player1.getRadius()){
				pills[p1].collision();
			}
		}
	}
	public void paint(Graphics g) {
		for(int i = 0; i < pills.length; i++) {
			pills[i].paint(g);
		}
	}
}
