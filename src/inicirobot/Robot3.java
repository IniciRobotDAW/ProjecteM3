/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

/**
 *
 * @author rbarberan
 */

public class Robot3 extends Robot{

    public Robot3(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
    }
    
    @Override
    public void onTouchRobot() {       
//        this.back(10);
//        this.fire();
//        this.left(90);
        this.ahead(100);
        
    }
    
    @Override
    public void onTouchWall() {
        this.back(100);
    }
    
    @Override
    public void onScannedRobot() {
//        this.fire();
    }
    
    @Override
    public void onHitByBullet() {

    }
    
    @Override
    public void win(){
        System.out.println("He guanyat"); 
    }
    
    @Override
    public void run() {
        this.right(90);
        while(true){
            this.ahead(1);
        }
    }
}