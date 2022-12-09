package engineero;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Remco - a robot by (your name here)
 */
public class Remco extends AdvancedRobot {
	/**
	 * run: RobotRemco's default behavior
	 */

	public int bulletCount = 0;
	public boolean robotHit = false;

	public void run() {

		setColors(Color.WHITE, Color.red, Color.BLACK); // body,gun,radar

		// Gun should be 225
		rotateGun(225);

		// Robot main loop
		while (true) {
			ahead(80 + (int) (Math.random() * ((125 - 80) + 1)));

			if (robotHit == false) {
				rotateGun(270);
				ahead(25 + (int) (Math.random() * ((35 - 25) + 1)));
				rotateGun(315);
			}

			if (bulletCount > 0) {
				if (getGunHeat() == 0) {
					fire(1);
				}
				bulletCount--;
			}

			if (robotHit == false) {
				rotateGun(270);
				ahead(25 + (int) (Math.random() * ((35 - 25) + 1)));
				rotateGun(225);
			}

			robotHit = false;
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		bulletCount = 2;
		if (getGunHeat() == 0) {
			if (e.getDistance() < 50) {
				fire(Rules.MAX_BULLET_POWER);
			} else if (e.getDistance() < 150) {
				fire(2);
			} else {
				fire(1);
			}
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		rotateGun(e.getBearing());
		fire(1);

		setTurnLeft(45);
		setAhead(100);
		execute();

		setTurnRight(45);
		setAhead(60);
		execute();
	}

	public void onHitRobot(HitRobotEvent e) {
		robotHit = true;
		rotateGun(e.getBearing());
		fire(Rules.MAX_BULLET_POWER);
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

	public void rotateGun(double degree) {
		double setPoint = getGunHeading() - ((degree + getHeading()) % 360);
		double goal;
		if (setPoint >= 0) {
			goal = setPoint % 360;
			if (goal > 180) {
				turnGunRight(goal - 180);
			} else {
				turnGunLeft(goal);
			}
		} else {
			goal = (setPoint * -1) % 360;
			if (goal > 180) {
				turnGunLeft(goal - 180);
			} else {
				turnGunRight(goal);
			}
		}
	}

}
