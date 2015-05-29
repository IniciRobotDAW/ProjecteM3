/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.robots;

import inicirobot.*;
import java.awt.event.KeyEvent;

/**
 * 
 * @author rbarberan
 */
<<<<<<< HEAD
public class Robot1 extends Robot {
    public Robot1(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar, int lives, int bullets) {
        super(x, y, cos, turret, radar, lives, bullets);
=======
public class Robot1 extends KeyRobot {
    public Robot1(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
>>>>>>> parent of 4fae4f9... Revert "aaa"
    }

    @Override
    public void onTouchRobot() {       

    }
    
    @Override
    public void onTouchWall() {
<<<<<<< HEAD
  
=======
        this.movComp(new String[]{"left","turnTurretLeft"}, 90);
//        this.left(90);        
>>>>>>> parent of 6350f68... panell
    }
    
    @Override
    public void onScannedRobot() {
        
    }
    
    @Override
    public void onHitByBullet() {
      
    }
    
    @Override
    public void win(){
       
    }
    
    @Override
    public void run() {
        KeyEvent evt = null;
        while(true){         
<<<<<<< HEAD
         
          this.go(evt);
=======
           this.movComp(new String[]{"right","back","turnTurretRight"}, 100);
           this.movComp(new String[]{"left","back","turnTurretLeft"}, 200);
//           this.fire();
//           this.ahead(100);
>>>>>>> parent of 6350f68... panell
        }
    }
}

    
