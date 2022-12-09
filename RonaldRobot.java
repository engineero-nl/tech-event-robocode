package engineero;

import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RonaldRobot - a robot by (your name here)
 */
public class RonaldRobot extends AdvancedRobot {

	private int gunTurnSpeed;
	private int lastGunRightTurn;

	/**
	 * run: RonaldRobot's default behavior
	 */
	public void run() {
		System.out.println("** UNIT TEST **");
		System.out.println(calculateFirePower(0.1)); // Should be 3
		System.out.println(calculateFirePower(150));
		System.out.println(calculateFirePower(300));
		System.out.println(calculateFirePower(450));
		System.out.println(calculateFirePower(600)); // Should be 0.1

		setMaxVelocity(5);

		Random rand = new Random();
		while (true) {
			int right = rand.nextInt(20) + 20;
			setTurnRight(right);

			setTurnGunRight(90);

			int ahead = rand.nextInt(250) + 25;
			ahead(ahead);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		var firePower = calculateFirePower(e.getDistance());
		setFire(firePower);
		setTurnGunRight(270);
	}

	private double calculateFirePower(double distance) {
		var minDist = 0.01;
		var maxDist = 600.0;

		var minFirePower = 0.1;
		var maxFirePower = 3.0;

		return (distance - maxDist) * (maxFirePower - minFirePower) / (minDist - maxDist) + minFirePower;
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
		setTurnRight(45);
	}
}
