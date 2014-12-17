/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

/**
 *
 * @author atorrillas
 */

public class Robot2 extends Robot{

    public Robot2(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
    }
    
    @Override
    public void onTouchRobot() {       
       this.back(10);
       this.left(10);
       
    }
    
    @Override
    public void onTouchWall() {
        this.left(90);
    }
    
    @Override
    public void onScannedRobot() {
//       this.fire();
    }
    
    @Override
    public void onHitByBullet() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
        this.back(45);
        this.fire();
        
    }
    
    @Override
    public void run() {
        this.right(90);
        while(true){
            
            this.back(100);
            this.left(45);
        }
    }  
}


    
   
    

