package engineero;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;
import java.util.Random;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Jasja - a robot by Jasja
 */
public class Jasja extends Robot {
    /**
     * run: Jasja's default behavior.
     */
    public void run() {
        setColors(new Color(28, 30, 42),new Color(28, 30, 42),new Color(28, 30, 42)); // body,gun,radar

        // Robot main loop
        while (true) {
            ahead(new Random().nextInt(500));
            turnLeft(new Random().nextInt(180));
            turnGunRight(new Random().nextInt(360));
            back(new Random().nextInt(400));
            turnRight(new Random().nextInt(90));
            turnGunLeft(new Random().nextInt(360));
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getDistance() < 100) {
            fire(3);
        } else {
            fire(1);
        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        turnLeft(new Random().nextInt(40));
        back(new Random().nextInt(200));
        turnGunLeft(new Random().nextInt(360));
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        turnRight(new Random().nextInt(90));
        back(new Random().nextInt(200));
        turnGunRight(new Random().nextInt(360));
    }
}
