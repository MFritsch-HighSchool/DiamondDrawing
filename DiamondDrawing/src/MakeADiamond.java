import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class MakeADiamond  implements Directions{
	Robot r = new Robot(1,1,North,-1);
	public static void main(String[] args) {
		MakeADiamond temp = new MakeADiamond();
		temp.prompt();
	}

	private void prompt() {
		// Ask the user for the diamond size
		System.out.println("Hey dude, I see you want to make a diamond.  Give me the deets: ");
		Scanner keyboard  = new Scanner(System.in);
		int beepersOnSide = keyboard.nextInt();
		World.setVisible(true);
		World.setSize(beepersOnSide*2+1,beepersOnSide*2+1);
		World.setDelay(3);
		diamond(beepersOnSide);	
	}

	private void diamond(int beepersOnSide) {
		while(r.facingEast() == false)
			r.turnLeft();
		for(int i = beepersOnSide; i>0; i--){
			r.move();
		}
		r.turnLeft();
		for(int j = 4; j > 0; j--){
			drawSide(r, beepersOnSide);
			r.turnLeft();
		}
		for(int k = beepersOnSide-1; k>0; k--)
			r.move();
	}

	private void drawSide(Robot r, int beepersOnSide) {
		for(int i = beepersOnSide-1; i > 0; i--){
		r.move();
		turnRight();
		r.move();
		r.putBeeper();
		r.turnLeft();
		}
		
	}
	
	private void turnRight(){
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
	}
	
}
