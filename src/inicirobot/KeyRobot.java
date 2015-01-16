/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.event.KeyEvent;


/**
 *
 * @author atorrillas
 */
public abstract class KeyRobot extends Robot{

    public KeyRobot(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, cos, turret, radar);
        
    }

    
    public void go(KeyEvent evt) { 
       
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            this.fire();
            System.out.println("enter");
        }
    } 
    
    
   
}
