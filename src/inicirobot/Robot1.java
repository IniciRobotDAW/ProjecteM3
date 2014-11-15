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
       this.left(90);
    }
    
    @Override
    public void onTouchWall() {
        System.out.println("-----------------------------------" + this.angle);
        //Prova torrillas patata
        this.right(90);   
    }
    
    @Override
    public void onScannedRobot() {
        this.fire();
    }
    
    @Override
    public void onHitByBullet(){
        System.out.println("TOOOOOOOOOC");
//        this.left(360);
//        this.fire();
    }

    @Override
    public void run() {
       
        while(true){
            
            this.ahead(100);
            
        }
    }    
}
    


    
   
    

