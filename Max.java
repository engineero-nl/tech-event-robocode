package engineero;

import robocode.*;
import java.awt.Color;
import java.util.*;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Max - a robot by (your name here)
 */
public class Max extends AdvancedRobot {
  Boolean detected = false;
  // int ramming = true;
  Random ran;
  int cornerCounter = 0;

  double mapSizeX;
  double mapSizeY;

  /**
   * run: Max's default behavior
   */
  public void run() {
    // Initialization of the robot should be put here
    ran = new Random();
    mapSizeX = getBattleFieldWidth();
    mapSizeY = getBattleFieldHeight();

    // After trying out your robot, try uncommenting the import at the top,
    // and the next line:

    // important
    setColors(Color.pink, Color.pink, Color.pink); // body,gun,radar

    // Robot main loop
    while (true) {
      goCrazy();
      // if (ramming) {
      // ramEnemy();
      // } else {
      // runAway();
      // }

      // // detect enemy
      // turnGunRight(360);

    }
  }

  public void goCrazy() {
    setMaxVelocity(Rules.MAX_VELOCITY);
    setMaxTurnRate(Rules.MAX_TURN_RATE);
    setTurnGunRight(360);
    setAhead(1000);
    execute();
  }

  /**
   * onScannedRobot: What to do when you see another robot
   */
  public void onStatus(StatusEvent e) {
    randColor();
  }

  public void onScannedRobot(ScannedRobotEvent e) {
    // Replace the next line with any behavior you would like
    // detected = true;
    fire(2);
  }

  /**
   * onHitByBullet: What to do when you're hit by a bullet
   */
  public void onHitByBullet(HitByBulletEvent e) {
    // Replace the next line with any behavior you would like
  }

  public void onHitRobot(HitRobotEvent e) {
    setTurnLeft(ran.nextInt(100) + 100);
  }

  /**
   * onHitWall: What to do when you hit a wall
   */
  public void onHitWall(HitWallEvent e) {
    setTurnRight(ran.nextInt(100) + 100);

    // // Replace the next line with any behavior you would like
    // ramming = ramming * -1;
  }

  public void ramEnemy() {
    setTurnGunRight(360);
  }

  public void runAway() {

  }

  // public void moveToCorner() {
  // // calculate corner point
  // int evasionPointX = cornerCounter ? mapSizeX - 50 : 50;
  // int evasionPointY = cornerCounter ? 50 : mapSizeY - 50;
  // System.out.println("evasionPointX: " + evasionPointX + " evasionPointY: " +
  // evasionPointY);

  // // calc distance
  // int distance = Math.sqrt((evasionPointX * getX()) * (evasionPointX * getX())
  // + (evasionPointY * getY()) * (evasionPointY * getY()));
  // System.out.println("distance: " + distance);

  // // calc heading
  // double cornerHeading = getAbsHeadingToPoint(evasionPointX, evasionPointY);

  // // set heading
  // setAbsHeading(cornerHeading);

  // // move to corner
  // ahead(distance);
  // }

  // public void evasion() {
  // // move to corner
  // int evasionPointX = cornerCounter ? mapSizeX - 50 : 50;
  // int evasionPointY = cornerCounter ? 50 : mapSizeY - 50;
  // cornerCounter = cornerCounter + 1;

  // int rotateRightDegree = ran.nextInt(100) + 20;
  // turnRight(rotateRightDegree);
  // int distance = ran.nextInt(150) + 50;
  // ahead(distance);

  // }

  public double getAbsHeadingToPoint(int evasionPointX, int evasionPointY) {
    double currentHeading = getHeading();
    double out = Math.atan2(evasionPointX, evasionPointX);
    System.out.println("corner x:" + evasionPointX + "y: " + evasionPointY + " current heading" + currentHeading
        + " -> absHeadingToPoint: " + out);
    return out;
  }

  // public void moveTowardsPoint(int destX, int destY) {
  // // // get current pos
  // // int curX = getX();
  // // int curY = getY();
  // // int diffX = curX - destX;
  // // int diffY = curY - destY;
  // int distance = ran.nextInt(75);
  // ahead(distance);
  // }

  public void setAbsHeading(double heading) {
    // get current heading
    double currentHeading = getHeading();
    double headingDifference = currentHeading - heading;
    if (headingDifference > 0) {
      System.out.println("turning right degrees: " + headingDifference);
      turnRight(headingDifference);
    } else {
      System.out.println("turning left degrees: " + -headingDifference);
      turnLeft(-headingDifference);
    }
  }

  public void onWin(WinEvent e) {
    for (int i = 0; i < 50; i++) {
      turnRight(30);
      turnLeft(30);
    }
  }

  public void randColor() {
    Color bodyColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    Color gunColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    Color radarColor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
    setColors(bodyColor, gunColor, radarColor); // body,gun,radar
  }

}
