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

public class Robot3 extends Robot{

    public Robot3(String color, double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar, int lives, int bullets) {
        super(color, x, y, cos, turret, radar, lives, bullets);
    }
    
    @Override
    public void onTouchRobot() {       
        this.left(100);
    }
    
    @Override
    public void onTouchWall() {
        this.movComp(new String[]{"right","turnTurretRight"}, 90);
    }
    
    @Override
    public void onScannedRobot() {
        this.fire();
    }
    
    @Override
    public void onHitByBullet() {
        this.back(100);               
    }
    
    @Override
    public void win(){
        this.left(360);
    }
    
    @Override
    public void run() {
        System.out.println("Soc robot 3");
        while(true){
            this.movComp(new String[]{"right","ahead","turnTurretRight"}, 100);
            this.movComp(new String[]{"left","ahead","turnTurretLeft"}, 200);
        }
    }
}