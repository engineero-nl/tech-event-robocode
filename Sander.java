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
		ahead(getBattleFieldWidth()/4);// center /2
		turnLeft(90);
		LookToRight();
//setAdjustGunForRobotTurn(true);
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
	double width= getBattleFieldWidth();
	double height = getBattleFieldWidth();
		// Robot main loop
		while(true) {
		//ahead(20);		
	//	turnGunRight(360);
	//	turnRight(75);

	double xPos = getX();
	if (xPos +10 >		width)
	{
		LookToRight();
		back(100);
	}
	xPos = getX();
	if (getX() < 10 )
	{
		LookToRight();
		ahead(100);
	}
double yPos = getY();
		if ((yPos +10) > height)
	{
		LookToRight();
		turnLeft(90);
		ahead(100);
	}
	 yPos = getY();
		if ( yPos < 10 )
	{
			LookToRight();
		turnRight(90);
		ahead(100);
	}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
	double bearing = getHeading() + e.getBearing();
		turnGunRight(bearing - getGunHeading());
	fire(3);
			ahead(20);		
		turnGunRight(360);
		turnRight(75);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(getBattleFieldHeight()/5);
		turnRight(90);
	
		ahead(getBattleFieldWidth()/5);
	//	goToCenter();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	back(getBattleFieldHeight()/5);
		turnRight(90);
		ahead(getBattleFieldWidth()/5);	
//	goToCenter();
	}	

    public void goToCenter()
	{
	    double xCenter = getBattleFieldWidth()/2;
		double yCenter = getBattleFieldHeight()/2;	
    	LookToRight();
		back(50);
		ahead(30);
	turnRight(60);
double xLoc = getX();
		double yLoc=getY();
		if (xLoc < (xCenter))
		{
			ahead(xCenter-xLoc);
		}
		else
		{
			back(xCenter - xLoc);
		}
	/// Y coordinates
		turnRight(90);
		yLoc =  getY();
		if (yLoc < (yCenter))
		{
			ahead(yCenter-yLoc);
		}
		else
		{
			back(yCenter - yLoc);
		}

	}
	
	public void LookToRight()
	{
	if (getHeading() < 90) {
			turnRight(90 - getHeading());
		} else {
			turnLeft(getHeading() - 90);
		}
	}
}
