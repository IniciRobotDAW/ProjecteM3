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
        while(true){
            this.movComp(new String[]{"right","ahead","turnTurretRight"}, 100);
            this.movComp(new String[]{"left","ahead","turnTurretLeft"}, 200);
        }
    }
}