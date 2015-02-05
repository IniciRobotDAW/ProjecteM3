/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.robots;

import inicirobot.*;

/**
 * 
 * @author rbarberan
 */
public class Robot1 extends Robot {
    public Robot1(String color, double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar, int lives, int bullets) {
        super(color, x, y, cos, turret, radar, lives, bullets);
    }
    
    @Override
    public void onTouchRobot() {       
       this.left(100);
       this.fire();
    }
    
    @Override
    public void onTouchWall() {
        this.movComp(new String[]{"left","turnTurretLeft"}, 90);
//        this.left(90);        
    }
    
    @Override
    public void onScannedRobot() {
        this.fire();
    }
    
    @Override
    public void onHitByBullet() {
       this.movComp(new String[]{"left","back","turnTurretRight"}, 30);
    }
    
    @Override
    public void win(){
        this.right(360);
    }
    
    @Override
    public void run() {
        System.out.println("Soc Robot 1");
//        this.right(180);
        while(true){         
           this.movComp(new String[]{"right","back","turnTurretRight"}, 100);
           this.movComp(new String[]{"left","back","turnTurretLeft"}, 200);
//           this.fire();
//           this.ahead(100);
        }
    }
}

    
