package engineero;
import robocode.*;
import java.awt.Color;
import java.util.ArrayList;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Sil_De_Knecht - a robot by (your name here)
 */
public class Sil_De_Knecht extends Robot
{
	/**
	 * run: Sil_De_Knecht's default behavior
	 */
	
//Credit:
//https://www.geeksforgeeks.org/java-sqrt-method-examples/
//https://www.google.com/search?q=pythagoras+theorem&rlz=1C1CHZN_enNL974NL974&oq=pythargos&aqs=chrome.2.69i57j46i10i512j0i10i512l7.4035j0j7&sourceid=chrome&ie=UTF-8
	//https://www.google.com/search?q=pythagoras+theorem&rlz=1C1CHZN_enNL974NL974&oq=pythargos&aqs=chrome.2.69i57j46i10i512j0i10i512l7.4035j0j7&sourceid=chrome&ie=UTF-8#wptab=s:H4sIAAAAAAAAAONglpJIT83PjS-oLMlITM8vSk3Miy_JSAUycqVYk60SdZKUOPRz9Q1Mi4yyHjEacwu8_HFPWEpr0pqT1xhVuLiCM_LLXfNKMksqhcS42KAsHikuLrgmnl1Mgs75ecmpBSXOiTnJpTmJJflFi1jlkCxUgFqokAxXAAD62v8cmAAAAA
	// https://www.google.com/search?q=java+normalize&rlz=1C1CHZN_enNL974NL974&oq=java+normalize&aqs=chrome.0.0i512l10.74859j0j7&sourceid=chrome&ie=UTF-8
	//https://docs.oracle.com/javase/7/docs/api/java/text/Normalizer.html
	//https://www.google.com/search?q=java+map+one+value+to+range+of+another&rlz=1C1CHZN_enNL974NL974&oq=java+map+one+value+to+range+of+another&aqs=chrome..69i57j33i160l4j33i22i29i30.7564j0j7&sourceid=chrome&ie=UTF-8
	//https://stackoverflow.com/questions/5731863/mapping-a-numeric-range-onto-another //https://www.google.com/search?q=java+intropolate+one+value+to+another&rlz=1C1CHZN_enNL974NL974&sxsrf=ALiCzsboKqibm0oAxkD6SlMSo1NvjTUGRg%3A1670597554940&ei=skuTY5r3OIb3sAe0x77QCA&ved=0ahUKEwiamMzu5Oz7AhWGO-wKHbSjD4oQ4dUDCA8&uact=5&oq=java+intropolate+one+value+to+another&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIHCCEQoAEQCjIHCCEQoAEQCjoECCMQJzoFCAAQkQI6BAgAEEM6CwguEIAEEMcBENEDOggILhCABBDUAjoECC4QQzoFCAAQgAQ6BQguEIAEOgoIABCABBCHAhAUOgcIABCABBAKOgcIABCABBANOgYIABAeEA06CAgAEBYQHhAKOggIABAeEA0QCjoICAAQHhAPEA06BAghEBVKBAhBGABKBAhGGABQAFiDOGCVP2gHcAB4AIABe4gB3hqSAQQ0Mi4ymAEAoAEBwAEB&sclient=gws-wiz-ser		
	//https://stackoverflow.com/questions/58773896/interpolation-in-java-mapping-a-random-number-from-one-range-to-another
	//https://www.google.com/search?q=java+math.max&rlz=1C1CHZN_enNL974NL974&oq=java+math.max&aqs=chrome..69i57j0i512l9.1729j0j7&sourceid=chrome&ie=UTF-8
	//https://www.tutorialspoint.com/java/lang/math_max_int.htm
	//https://www.google.com/search?q=java+array&rlz=1C1CHZN_enNL974NL974&oq=java+array&aqs=chrome..69i57j0i67l3j0i10i512l6.2044j0j7&sourceid=chrome&ie=UTF-8
	//https://www.google.com/search?q=java+list&rlz=1C1CHZN_enNL974NL974&sxsrf=ALiCzsYBlW3OBCs12BHho0AbXwPHVW4qqQ%3A1670598783872&ei=f1CTY93aNKiU9u8P_8GmqAo&ved=0ahUKEwidlsy46ez7AhUoiv0HHf-gCaUQ4dUDCA8&uact=5&oq=java+list&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCAAQkQIyBQgAEJECMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6CggAEEcQ1gQQsAM6BwgAELADEEM6BAgjECc6BAgAEENKBAhBGABKBAhGGABQ2wJY_w1g7Q5oAXABeACAAa8BiAGbBpIBAzYuM5gBAKABAcgBCsABAQ&sclient=gws-wiz-serp
	// https://docs.oracle.com/javase/8/docs/api/java/util/List.html
	//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	//https://robocode.sourceforge.io/docs/robocode/robocode/ScannedRobotEvent.html
	// Sharon's Bullet Damage idea.
	
	
	double fieldHeight = 0.0;
	double fieldWidth = 0.0;
	
	double tenPercentX = 0.0;
	double tenPercentY = 0.0;
	
	double maxDistance = 0.0;
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		
		fieldWidth = getBattleFieldWidth();
		fieldHeight = getBattleFieldHeight();
		
		tenPercentX = fieldWidth / 9.0;
		tenPercentY = fieldHeight / 9.0;

		maxDistance = Math.sqrt(((fieldWidth / 2.0) * (fieldWidth / 2.0)) + ((fieldHeight / 2.0) * (fieldHeight / 2.0)));
	
		setColors(Color.red, Color.white, Color.red); // body,gun,radar
		
		setAdjustGunForRobotTurn(true);

		// Robot main loop
		while(true) {
		
			double x = getX();
			double y = getY();
			double distance = 0.0;
			double turnAmount = 0.0;
			double turnAmountRatio = 0.0;
			
			double distX = 0.0000001;
			double distY = 0.0000001;

			/*
			// Too close to left and bottom
			if (x <= tenPercentX && y <= tenPercentY){
				distance = Math.sqrt(((x) * (x)) + ((y) * (y)));
			}

			// Too close to right and bottom
			if (x >= fieldWidth - tenPercentX && y <= tenPercentY){
				distance = Math.sqrt(((fieldWidth - x) * (fieldWidth - x)) + ((y) * (y)));
			}			

			// Too close to right and top
			if (x >= fieldWidth - tenPercentX && y >= fieldHeight - tenPercentY){
				distance = Math.sqrt(((fieldWidth - x) * (fieldWidth - x)) + ((fieldHeight - y) * (fieldHeight - y)));
			}			

			// Too close to left and top
			if (x <= tenPercentX && y >= fieldHeight - tenPercentY){
				distance = Math.sqrt(((x) * (x)) + ((fieldHeight - y) * (fieldHeight - y)));
			}
			*/
			
			// Too close to bottom.
			if (x <= tenPercentX){
				distX = x;
			}
			
			// Too close to top.
			if (x >= fieldWidth - tenPercentX){
				distX = fieldWidth - x;
			}
			
			// Too close to left.
			if (y <= tenPercentY){
				distY = y;
			}
			
			// Too close to right.
			if (y >= fieldHeight - tenPercentY){
				distY = fieldHeight - y;
			}
			
			distance = Math.sqrt((distX * distX) + (distY * distY));
			
			turnAmountRatio = distance / maxDistance;
			
			turnGunRight(120);
			turnAmount = Math.min(350.0 / (1.0 / turnAmountRatio), 45);
			System.out.println("TurnAmount = " + turnAmount);
			turnLeft(turnAmount);
			
			ahead(150);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if (e.getDistance() <= 50){
			fire(Rules.MAX_BULLET_POWER);
		} else {
			fire(Rules.MAX_BULLET_POWER / 2.0);
		}
	}
	
	public void OnWin(WinEvent e){
		stop();		
		turnGunRight(5000);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
	}
	
	public void onBulletHit(BulletHitEvent e){
		
	}

	public void onBulletMissed(BulletMissedEvent e){
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	}	
}
