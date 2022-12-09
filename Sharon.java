package engineero;
import robocode.*;
import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;


import java.awt.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Sharon - a robot by Sharon
 */
public class Sharon extends Robot
{
	int dist = 50;
	
   	public void run(){
		// Set colors
		setBodyColor(Color.orange);
		setGunColor(Color.pink);
		setRadarColor(Color.red);
		setScanColor(Color.red);
		setBulletColor(Color.yellow);
      
		while(true){
		
         	ahead(100);
		    turnGunRight(360);
		    back(75);
		    turnGunRight(360);
      	}
   	}
	
	public void onScannedRobot(ScannedRobotEvent e){
		if (e.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		}
		else {
			fire(1);
		}
	
		scan();
	}
	
	public void onHitRobot(HitRobotEvent e) {
		double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
		
		turnGunRight(turnGunAmt);
		fire(3);
	}
	
	public void onHitByBulled(HitByBulletEvent e) {
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

		ahead(dist);
		dist *= -1;
		scan();
	}
  
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		double bearing = e.getBearing();
		turnRight(-bearing); 
		ahead(100);
	}	
}
