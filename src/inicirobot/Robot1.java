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
//        this.fire();
        this.right(90);
    }

    @Override
    public void onTouchWall() {
        this.left(90);   
    }
    
    @Override
    public void onScannedRobot() {
//        this.fire();
    }
    
    @Override
    public void onHitByBullet(){ 
//        this.back(10);
//        this.right(20);
        
    }

    @Override
    public void run() {
        this.ahead(70);
        this.left(90);
        while(true){
            
            this.ahead(100);
            
        }
    }    
}
    


    
   
    

