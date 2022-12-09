package engineero;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Klaas - a robot by (your name here)
 */
public class Klaas extends Robot
{
	/**
	 * run: Klaas's default behavior
	 */
	public void run() {
		// Initialization robot
		setColors(Color.black, Color.orange, Color.blue); // body,gun,radar
		//setAdjustGunForRobotTurn(true); // Keep the gun still when we turn
		setAdjustRadarForGunTurn(true); // Set radar turn independent

		if (getHeading() < 90) {
			turnRight(90 - getHeading());
		} else {
			turnLeft(getHeading() - 90);
		}

		// Robot main loop
		while(true) {
			// Continuously turn radar
			turnRadarRight(45);

			double maxDistance = 75;

			double farHorizontal = getBattleFieldWidth() / 4;
			double nearHorizontal = getBattleFieldWidth() / 16;
			double farVertical = getBattleFieldHeight() / 4;
			double nearVertical = getBattleFieldHeight() / 16;
			double spaceLeft = 0;

			if (getHeading() == 90) {
				spaceLeft = getBattleFieldWidth() - getX();
				ahead(Math.min(maxDistance, (spaceLeft / 2)));
			} else if (getHeading() == 180) {
				spaceLeft = getY();
				ahead(Math.min(maxDistance, (spaceLeft / 2)));
			} else if (getHeading() == 270) {
				spaceLeft = getX();
				ahead(Math.min(maxDistance, (spaceLeft / 2)));
			} else {
				spaceLeft = getBattleFieldHeight() - getY();
				ahead(Math.min(maxDistance, (spaceLeft / 2)));
			}

			if (spaceLeft < 300)
			{
				turnRight(90);
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		turnGunRight(e.getBearing());
		if (getGunHeat() == 0) {
			fire(Rules.MAX_BULLET_POWER);
		}
		turnGunLeft(e.getBearing());
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		setColors(Color.black, Color.red, Color.red); // body,gun,radar
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
}
