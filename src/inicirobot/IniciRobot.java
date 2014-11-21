/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;
import libraries.*;
//import robotlibrary3.*;

/**
 *
 * @author atorrillas
 */
public class IniciRobot{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int xIniciR1 = 300;
        int yIniciR1 = 200;
        
        int xIniciR2 = 400;
        int yIniciR2 = 200;
        
        
        //Cos
        RobotPiece cos1 = new RobotPiece("/resources/images/ricardbody.png",xIniciR1, yIniciR1, 0, 0);
        RobotPiece cos2 = new RobotPiece("/resources/images/arnauBody.png",xIniciR2, yIniciR2, 0, 0);
        
        //Turret
        RobotPiece turret1 = new RobotPiece("/resources/images/ricardTurret.png",xIniciR1, yIniciR1, 8, -10);
        RobotPiece turret2 = new RobotPiece("/resources/images/arnauTurret.png",xIniciR2, yIniciR2, 8, -10);
        
        //Radar
        RobotPiece radar1 = new RobotPiece("/resources/images/ricardRadar.png",xIniciR1, yIniciR1, 7, 9);
        RobotPiece radar2 = new RobotPiece("/resources/images/arnauRadar.png",xIniciR2, yIniciR2, 7, 9);
        
        // Robot sencer
        Robot1 r1 = new Robot1(xIniciR1, yIniciR1, cos1, turret1, radar1);
        Robot2 r2 = new Robot2(xIniciR2, yIniciR2, cos2, turret2, radar2);

        new BattleWindow(r1, r2);
    }
}