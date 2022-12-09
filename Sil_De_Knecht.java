package engineero;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Sil_De_Knecht - a robot by (your name here)
 */
public class Sil_De_Knecht extends Robot
{
	/**
	 * run: Sil_De_Knecht's default behavior
	 */
	
//https://www.geeksforgeeks.org/java-sqrt-method-examples/
//https://www.google.com/search?q=pythagoras+theorem&rlz=1C1CHZN_enNL974NL974&oq=pythargos&aqs=chrome.2.69i57j46i10i512j0i10i512l7.4035j0j7&sourceid=chrome&ie=UTF-8
	//https://www.google.com/search?q=pythagoras+theorem&rlz=1C1CHZN_enNL974NL974&oq=pythargos&aqs=chrome.2.69i57j46i10i512j0i10i512l7.4035j0j7&sourceid=chrome&ie=UTF-8#wptab=s:H4sIAAAAAAAAAONglpJIT83PjS-oLMlITM8vSk3Miy_JSAUycqVYk60SdZKUOPRz9Q1Mi4yyHjEacwu8_HFPWEpr0pqT1xhVuLiCM_LLXfNKMksqhcS42KAsHikuLrgmnl1Mgs75ecmpBSXOiTnJpTmJJflFi1jlkCxUgFqokAxXAAD62v8cmAAAAA
	// https://www.google.com/search?q=java+normalize&rlz=1C1CHZN_enNL974NL974&oq=java+normalize&aqs=chrome.0.0i512l10.74859j0j7&sourceid=chrome&ie=UTF-8
	//https://docs.oracle.com/javase/7/docs/api/java/text/Normalizer.html
	
	double fieldHeight = 0.0;
	double fieldWidth = 0.0;
	
	double tenPercentX = 0.0;
	double tenPercentY = 0.0;
	
	double maxDistance = 0.0;
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		
		fieldWidth = getBattleFieldWidth();
		fieldHeight = getBattleFieldHeight();
		
		tenPercentX = fieldWidth / 5.0;
		tenPercentY = fieldHeight / 5.0;

		maxDistance = Math.sqrt(((fieldWidth / 2.0) * (fieldWidth / 2.0)) + ((fieldHeight / 2.0) * (fieldHeight / 2.0)));
	
		setColors(Color.red, Color.white, Color.red); // body,gun,radar

		// Robot main loop
		while(true) {
		
			turnGunLeft(360);
			double x = getX();
			double y = getY();
			double distance = 0.0;
			double turnAmount = 0.0;
			
			// Too close to left and bottom
			if (x <= tenPercentX && y <= tenPercentY){
				distance = Math.sqrt(((x) * (x)) + ((y) * (y)));
				turnAmount = distance / maxDistance * 90.0 * 2;
				turnLeft(turnAmount);
			}

			// Too close to right and bottom
			if (x >= fieldWidth - tenPercentX && y <= tenPercentY){
				distance = Math.sqrt(((fieldWidth - x) * (fieldWidth - x)) + ((y) * (y)));
				turnAmount = distance / maxDistance * 90.0 * 2;
				turnLeft(turnAmount);
			}			

			// Too close to right and top
			if (x >= fieldWidth - tenPercentX && y >= fieldHeight - tenPercentY){
				distance = Math.sqrt(((fieldWidth - x) * (fieldWidth - x)) + ((fieldHeight - y) * (fieldHeight - y)));
				turnAmount = distance / maxDistance * 90.0 * 2;
				turnLeft(turnAmount);
			}			

			// Too close to left and top
			if (x <= tenPercentX && y >= fieldHeight - tenPercentY){
				distance = Math.sqrt(((x) * (x)) + ((fieldHeight - y) * (fieldHeight - y)));
				turnAmount = distance / maxDistance * 90.0 * 2;
				turnLeft(turnAmount);
			}
			
			ahead(50);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if (getGunHeat() == 0){
			fire(Rules.MAX_BULLET_POWER);
		}
	}
	
	public void OnWin(WinEvent e){

	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	}	
}
