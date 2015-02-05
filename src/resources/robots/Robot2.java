/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.robots;

import inicirobot.*;

/**
 *
 * @author atorrillas
 */

public class Robot2 extends Robot{

    public Robot2(String color, double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar, int lives, int bullets) {
        super(color, x, y, cos, turret, radar, lives, bullets);
    }
    
    @Override
    public void onTouchRobot() {          
       this.fire();
    }
    
    @Override
    public void onTouchWall() {
        this.back(30);
       
    }
    
    @Override
    public void onScannedRobot() {
        this.fire();
    }
    
    @Override
    public void onHitByBullet() {
//        this.fire();
    }
    
    @Override
    public void win(){
        this.right(360); 
    }
    
    @Override
    public void run() {
        System.out.println("Soc robot 2");
//        this.left(90);
        while(true){
             this.movComp(new String[]{"ahead","right","turnTurretRight"}, 100);

        }
    }
}