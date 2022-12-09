
package engineero;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * KKT - a robot by (your name here)
 */
public class KKT extends Robot
{
	int i = 1;
	int factorAhead = 3;
	int factorBack = 2;
	/**
	 * run: KKT's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		 setColors(Color.black,Color.white,Color.black); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like

			for(int index=0; index <= factorAhead; index++) {
				ahead(50);
				turnGunRight(360);
				ahead(25);
				turnGunRight(360);
			}
			for(int index=0; index <= factorBack; index++) {
				back(50);
				turnGunRight(360);
				back(50);
				turnGunRight(360);
			}
			turnRight((i*10));
			if (i++ > 18){
				i = 1;
			}
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
		back(30);
		turnLeft(90 - e.getBearing());
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent event) {
		// Replace the next line with any behavior you would like
       if (event.getBearing() > -90 && event.getBearing() <= 90) {
           back(50);
       } else {
           ahead(50);
       }
	}
	
	/**
	 * onHitRobot: What to do when you hit a robot
	 */
    public void onHitRobot(HitRobotEvent event) {
		if (event.getBearing() > -10 && event.getBearing() < 10) {
			fire(3);
		}
       if (event.getBearing() > -90 && event.getBearing() <= 90) {
           back(50);
       } else {
           ahead(75);
       }
    }
	
	public void onBulletHit(BulletHitBulletEvent event) {
       fire(1);
    }
	
}
