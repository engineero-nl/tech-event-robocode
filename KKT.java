
package engineero;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * KKT - a robot by (your name here)
 */
public class KKT extends Robot
{
	/**
	 * run: KKT's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		int i = 1;
		//double height = getBattleFieldHeight();
		//double width = getBattleFieldWidth();
		int factorAhead = 2;
		int factorBack = 1;

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(factorAhead * 100);
			turnGunRight(360);
			back(factorBack * 100);
			turnGunRight(360);
			
			turnRight((i*10));
			i++;
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(5);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
		turnLeft(90 - e.getBearing());
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent event) {
		// Replace the next line with any behavior you would like
       if (event.getBearing() > -90 && event.getBearing() <= 90) {
           back(20);
       } else {
           ahead(20);
       }
	}
	
	/**
	 * onHitRobot: What to do when you hit a robot
	 */
    public void onHitRobot(HitRobotEvent event) {
       if (event.getBearing() > -90 && event.getBearing() <= 90) {
           back(100);
       } else {
           ahead(100);
       }
    }
	
}
