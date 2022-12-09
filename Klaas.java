package engineero;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Klaas - a robot by (your name here)
 */
public class Klaas extends Robot
{
	enum Direction {
		STRAIGHT,
		LEFT,
		RIGHT
	}

	Direction getDirection(double maxDistance, boolean backwards) {
		double spaceLeft = 0;

		double heading = getHeading();
		if (backwards) {
			heading = heading + 180;
			if (heading == 360) {
				heading = 0;
			}
		}

		if (heading == 0) {
			spaceLeft = getBattleFieldHeight() - getY();
			if (spaceLeft < maxDistance) {
				if (getX() < (getBattleFieldWidth() / 2)) {
					return Direction.RIGHT;
				}
				return Direction.LEFT;
			}
		}

		else if (heading == 90) {
			spaceLeft = getBattleFieldWidth() - getX();
			if (spaceLeft < maxDistance) {
				if (getY() < (getBattleFieldHeight() / 2)) {
					return Direction.LEFT;
				}
				return Direction.RIGHT;
			}

		} else if (heading == 180) {
			spaceLeft = getY();
			if (spaceLeft < maxDistance) {
				if (getX() < (getBattleFieldWidth() / 2)) {
					return Direction.LEFT;
				}
				return Direction.RIGHT;
			}

		} else if (heading == 270) {
			spaceLeft = getX();
			if (spaceLeft < maxDistance) {
				if (getY() < (getBattleFieldHeight() / 2)) {
					return Direction.RIGHT;
				}
				return Direction.LEFT;
			}
		}

		return Direction.STRAIGHT;
	}

	double findPath(double maxDistance, boolean backwards) {
		double farHorizontal = getBattleFieldWidth() / 4;
		double nearHorizontal = getBattleFieldWidth() / 16;
		double farVertical = getBattleFieldHeight() / 4;
		double nearVertical = getBattleFieldHeight() / 16;
		double spaceLeft = 0;

		double heading = getHeading();
		if (backwards) {
			heading = heading + 180;
			if (heading == 360) {
				heading = 0;
			}
		}

		if (heading == 90) {
			spaceLeft = getBattleFieldWidth() - getX();
			return (Math.min(maxDistance, (spaceLeft / 2)));
		} else if (heading == 180) {
			spaceLeft = getY();
			return (Math.min(maxDistance, (spaceLeft / 2)));
		} else if (heading == 270) {
			spaceLeft = getX();
			return (Math.min(maxDistance, (spaceLeft / 2)));
		} else {
			spaceLeft = getBattleFieldHeight() - getY();
			return (Math.min(maxDistance, (spaceLeft / 2)));
		}
	}

	/**
	 * run: Klaas's default behavior
	 */
	public void run() {
		// Initialization robot
		setColors(Color.black, Color.orange, Color.blue); // body,gun,radar
		setAdjustRadarForGunTurn(true); // Set radar turn independent

		if (getHeading() < 90) {
			turnRight(90 - getHeading());
		} else {
			turnLeft(getHeading() - 90);
		}

		// Robot main loop
		while(true) {
			// Continuously turn radar
			turnRadarRight(360);

			double maxDistance = 100;
			double toTravel = findPath(maxDistance, false);

			ahead(toTravel);

			Direction dir = getDirection(maxDistance, false);
			if (dir == Direction.LEFT) {
				turnLeft(90);
			} else if (dir == Direction.RIGHT) {
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
			if (e.getDistance() > 250) {
				fire(1);
			} else {
				fire(Rules.MAX_BULLET_POWER);
			}
		}
		turnGunLeft(e.getBearing());

		double maxDistance = 250;

		Direction dir = getDirection(maxDistance, false);
		if (dir == Direction.LEFT) {
			turnLeft(90);
		} else if (dir == Direction.RIGHT) {
			turnRight(90);
		}

		ahead(findPath(150, false));
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		double maxDistance = 200;
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			// Should go back if we have space
			Direction dir = getDirection(maxDistance, true);
			if (dir == Direction.STRAIGHT) {
				back(findPath(maxDistance, true));
			} else if (dir == Direction.LEFT) {
				turnRight(90);
				back(findPath(maxDistance, true));
			} else {
				turnLeft(90);
				back(findPath(maxDistance, true));
			}
		} else {
			// Should go forward if we have space
			Direction dir = getDirection(maxDistance, false);
			if (dir == Direction.STRAIGHT) {
				ahead(findPath(maxDistance, false));
			} else if (dir == Direction.LEFT) {
				turnLeft(90);
				ahead(findPath(maxDistance, false));
			} else {
				turnRight(90);
				ahead(findPath(maxDistance, false));
			}
		}
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		double maxDistance = 50;
		if (e.getBearing() == -180) {
			ahead(findPath(maxDistance, false));
		} else {
			back(findPath(maxDistance, true));
		}
	}
}
