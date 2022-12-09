package engineero;

import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RonaldRobot - a robot by (your name here)
 */
public class RonaldRobot extends Robot {

	private int gunTurnSpeed;

	/**
	 * run: RonaldRobot's default behavior
	 */
	public void run() {
		Random rand = new Random();

		while (true) {
			int right = rand.nextInt(10) + 10;
			turnRight(right);
			turnGunRight(50);

			int ahead = rand.nextInt(100) + 25;
			ahead(ahead);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		// back(10);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		// back(20);
		turnRight(45);
	}
}
