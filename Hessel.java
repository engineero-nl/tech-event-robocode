package engineero;
import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Hessel - a robot by (your name here)
 */
public class Hessel extends Robot
{
	/**g
	 * run: Hessel's default behavior
	 * 
	 * 
	 * 
	 * 
	 */
	
	Random ran = new Random();

	public String getName(){
		return "Hessel ft. Max";
	}

	public void run() {
		// Initialization of the robot should be put here
		
		turnGunRight(90);

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

			

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(3000000);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if(e.getDistance() < 150){
			fire(1);
			if(e.getDistance() < 50){
				fire(3);
			}
		}
		
	}

	public void onHitRobot(HitRobotEvent e){
		if(e.isMyFault()){
			turnGunLeft(90);
			fire(3);
			fire(3);
			turnGunRight(90);
		}
	}
	
	public void onStatus(StatusEvent e){
		randColor();
	}
	
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
			turnRight(90 + e.getBearing());
	}	
	
	public void randColor() {
		Color bodyColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		Color gunColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		Color radarColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		setColors(bodyColor, gunColor, radarColor); // body,gun,radar
	}
}
