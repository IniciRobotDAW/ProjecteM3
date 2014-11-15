/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;


import robotlibrary3.*;

/**
 *
 * @author atorrillas
 */
public class IniciRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Cos
        RobotPiece cos1 = new RobotPiece("/resources/images/greenbody.png",300, 200, 0, 0);
        RobotPiece cos2 = new RobotPiece("/resources/images/body.png",300, 400, 0, 0);
        
        //Turret
        RobotPiece turret1 = new RobotPiece("/resources/images/greenTurret.png",300, 200, 8, -10);
        RobotPiece turret2 = new RobotPiece("/resources/images/turret.png",300, 400, 8, -10);
        
        //Radar
        RobotPiece radar1 = new RobotPiece("/resources/images/yellowRadar.png",300, 200, 7, 9);
        RobotPiece radar2 = new RobotPiece("/resources/images/radar.png",300, 400, 7, 9);
        
        // Robot sencer
        Robot1 r1 = new Robot1(300, 200, cos1, turret1, radar1);
        Robot2 r2 = new Robot2(300, 400, cos2, turret2, radar2);

        new BattleWindow(r1, r2);     
    }
}