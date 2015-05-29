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
         
          this.go(evt);
        }
    }
}

    
