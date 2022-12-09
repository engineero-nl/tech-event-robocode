package engineero;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html


/**
 * Sander - a robot by (your name here)
 */
public class Sander extends Robot
{
	/**
	 * run: Sander's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		goToCenter();
		//ahead(getBattleFieldWidth()/4);// center /2
setAdjustGunForRobotTurn(true);
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
				//goToCenter();
		//	turnAheadLeft(10, 10);
		ahead(getBattleFieldWidth()/20);		
		turnGunLeft(getBattleFieldHeight()/19);
		turnRight(40);
			//turnGunRight(270);
			//back(100);
			//turnGunRight(360);
			//+
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(getBattleFieldHeight()/5);
		turnRight(90);
		ahead(getBattleFieldWidth()/5);
		goToCenter();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(getBattleFieldWidth()/5);
		turnRight(90);
		ahead(getBattleFieldHeight()/5);
		goToCenter();
	}	
	
    public void goToCenter()
	{
		double xCenter = getBattleFieldWidth()/2;
		double yCenter = getBattleFieldHeight()/2;	
    	double xLoc = getX();
		double yloc=  getY();

		if (xLoc < (xCenter))
		{
			ahead(xCenter-xLoc);
		}
		else
		{
			back(xCenter - xLoc);
		}

	}
}
