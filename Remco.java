package engineero;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Remco - a robot by (your name here)
 */
public class Remco extends Robot {
	/**
	 * run: RobotRemco's default behavior
	 */

	public int bulletCount = 0;

	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.WHITE, Color.red, Color.BLACK); // body,gun,radar

		turnGunLeft(90 + 45);

		// Robot main loop
		while (true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(45);
			ahead(30);
			turnGunRight(45);
			if (bulletCount > 0) {
				if (getGunHeat() == 0) {
					fire(1);
				}
				bulletCount--;
			}
			ahead(30);
			turnGunLeft(45);
			ahead(30);
			turnGunLeft(45);
			// turnGunRight(360);
			// back(100);
			// turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		// fire(1);
		bulletCount = 2;
		if (getGunHeat() == 0) {
			setBulletColor(new Color((int) (Math.random() * 0x1000000)));
			fire(2);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(45);
		ahead(50);
		turnRight(45);
		// back(10);
	}

	public void onHitRobot(HitRobotEvent e) {
		double curHeading = getGunHeading();
		double hitRobotHeading = e.getBearing() + getHeading();
		double diff = hitRobotHeading - curHeading;
		turnGunLeft(diff);
		fire(Rules.MAX_BULLET_POWER);
		turnGunRight(diff);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnLeft(90 - e.getBearing());
	}

	public void onWin(WinEvent e) {
		while (true) {
			turnRight(90);
			setAllColors(new Color((int) (Math.random() * 0x1000000)));
		}
	}
}
