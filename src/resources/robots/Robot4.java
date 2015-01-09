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

public class Robot4 extends Robot{

    public Robot4(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar, int lives, int bullets) {
        super(x, y, cos, turret, radar, lives, bullets);
    }
    
    @Override
    public void onTouchRobot() {       
        this.left(180);    
    }
    
    @Override
    public void onTouchWall() {
        this.left(20);
    }
    
    @Override
    public void onScannedRobot() {
        this.fire();
    }
    
    @Override
    public void onHitByBullet() {
        this.right(90);
    }
    
    @Override
    public void win(){
        this.right(360);
    }
    
    @Override
    public void run() {
        System.out.println("Soc robot 4");
//        this.right(90);
        while(true){
            this.ahead(100);
        }
    }
}