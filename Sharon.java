package engineero;
import robocode.*;
import java.awt.Color;
import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

/**
 * Sharon - a robot by Sharon
 */
public class Sharon extends AdvancedRobot
{
	//Global variables
	static double direction;
	static double enemyEnergy;
	static double hits;
	static int movementMode;

	public void run() {
		setTurnRadarRightRadians(direction = 100000);
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		//Local variables
		double absoluteBearing;
		double bearing;
		double lead;	
		
		//gun
		setTurnGunRightRadians(Utils.normalRelativeAngle((absoluteBearing = getHeadingRadians() + (bearing = e.getBearingRadians())) +
			(lead = Math.asin(e.getVelocity() / 14 * Math.sin(e.getHeadingRadians() - absoluteBearing))) - getGunHeadingRadians()));
			
		//movement		
		//oscillating			
		if(enemyEnergy > (enemyEnergy = e.getEnergy()) && movementMode == 1) {
			onHitWall(null);
		}
		//orbiting
		setAhead(direction);
		setTurnRightRadians(Math.cos(bearing - ((absoluteBearing = e.getDistance()) - 160) * (direction / 35000000)));
		
		//ramming
		if (movementMode > 1) {
			setTurnRightRadians(Math.tan(bearing += lead));
			setAhead(Math.cos(bearing) / 0);
		}
		
		//gun
		setFire(Math.min(2 + (100 / (int)absoluteBearing), enemyEnergy / 4));
	
		//radar
		setTurnRadarLeftRadians(getRadarTurnRemaining());
	}

	public void onBulletHit (BulletHitEvent e) {
		enemyEnergy -= 10;
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		if ((hits += (0.4)) > getRoundNum() + 2) {
			movementMode++;
			hits = 0;
		}
	}
	
	public void onHitRobot(HitRobotEvent e) {
			double turnGunAmt = robocode.util.Utils.normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
			
			turnGunRight(turnGunAmt);
			fire(3);
		}
	
	public void onHitWall(HitWallEvent e) {
		double bearing = e.getBearing();
		turnRight(-bearing); 
		ahead(100);
	}
}
