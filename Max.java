package engineero;

import robocode.*;
import java.awt.Color;
import java.util.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Max - a robot by (your name here)
 */
public class Max extends Robot {
  Boolean detected = false;
  Random ran;

  /**
   * run: Max's default behavior
   */
  public void run() {
    // Initialization of the robot should be put here
    ran = new Random();

    // After trying out your robot, try uncommenting the import at the top,
    // and the next line:

    // important
    setColors(Color.pink, Color.pink, Color.pink); // body,gun,radar

    // Robot main loop
    while (true) {
      // Movement
      evasion();

      // check if still detected
      // if (stillDetected()) {
      // if (detected) {
      if(false) {
        // shoot
        fire(2);
      } else {
        // detect enemy
        turnGunRight(360);
      }
    }
  }

  /**
   * onScannedRobot: What to do when you see another robot
   */
  public void onScannedRobot(ScannedRobotEvent e) {
    // Replace the next line with any behavior you would like
    // detected = true;
    fire(3);
  }

  /**
   * onHitByBullet: What to do when you're hit by a bullet
   */
  public void onHitByBullet(HitByBulletEvent e) {
    // Replace the next line with any behavior you would like
    randColor();
  }

  /**
   * onHitWall: What to do when you hit a wall
   */
  public void onHitWall(HitWallEvent e) {
    // Replace the next line with any behavior you would like
    back(20);
  }

  public void randColor() {
    Color bodyColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    Color gunColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    Color radarColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    setColors(bodyColor, gunColor, radarColor); // body,gun,radar
  }

  public void stillDetected() {

  }

  public void evasion() {

    // // TODO fix this kappa
    // int leastEnemyPointX = ran.nextInt(600);
    // int leastEnemyPointY = ran.nextInt(600);
    // moveTowardsPoint(leastEnemyPointX,leastEnemyPointY);


    int rotateRightDegree = ran.nextInt(100)+20;
    turnRight(rotateRightDegree);
    int distance = ran.nextInt(150)+50;
    ahead(distance);

  }

  public void moveTowardsPoint(int destX, int destY) {

    // // get current pos
    // int curX = getX();
    // int curY = getY();
    // int diffX = curX - destX;
    // int diffY = curY - destY;

    int distance = ran.nextInt(75);
    ahead(distance);
  }
}
