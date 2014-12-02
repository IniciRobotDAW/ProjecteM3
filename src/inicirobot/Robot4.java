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

public class Robot4 extends Robot{

    public Robot4(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
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
        this.right(90);
        while(true){
            this.ahead(100);
        }
    }
}