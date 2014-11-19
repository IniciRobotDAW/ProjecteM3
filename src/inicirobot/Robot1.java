/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

/**
 * @author rbarberan
 */

public class Robot1 extends Robot{

    public Robot1(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
    }
      
    @Override
    public void onTouchRobot() {
        this.right(90);
    }

    @Override
    public void onTouchWall() {

    }
    
    @Override
    public void onScannedRobot() {

    }
    
    @Override
    public void onHitByBullet(){

    }

    @Override
    public void run() {

        while(true){
            
            this.back(100);
            
        }
    }    
}
    


    
   
    

