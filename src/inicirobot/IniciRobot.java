/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;
import java.util.*;
import libraries.*;

/**
 *
 * @author atorrillas
 */
public class IniciRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Menu m1 = new Menu();
        int numRobots = m1.mostraMenu();
        
        
        //Marca l'inici de cada robot
        int W = Board.WIDTH-50;
        int H = Board.HEIGHT-50;
        
        int xIniciR1 = (int)(Math.random()*W + 1);
        int yIniciR1 = (int)(Math.random()*H + 1);
        
        int xIniciR2 = (int)(Math.random()*W + 1);
        int yIniciR2 = (int)(Math.random()*H + 1);
        
        int xIniciR3 = (int)(Math.random()*W + 1);
        int yIniciR3 = (int)(Math.random()*H + 1);
        
        int xIniciR4 = (int)(Math.random()*W + 1);
        int yIniciR4 = (int)(Math.random()*H + 1);
        
        int xIniciR5 = (int)(Math.random()*W + 1);
        int yIniciR5 = (int)(Math.random()*H + 1);
        
        int xIniciR6 = (int)(Math.random()*W + 1);
        int yIniciR6 = (int)(Math.random()*H + 1);
        
        //Cos
        RobotPiece cos1 = new RobotPiece("/resources/images/pinkBody.png",xIniciR1, yIniciR1, 0, 0);
        RobotPiece cos2 = new RobotPiece("/resources/images/arnauBody.png",xIniciR2, yIniciR2, 0, 0);
        RobotPiece cos3 = new RobotPiece("/resources/images/body.png",xIniciR3, yIniciR3, 0, 0);
        RobotPiece cos4 = new RobotPiece("/resources/images/greenBody.png",xIniciR4, yIniciR4, 0, 0);
        RobotPiece cos5 = new RobotPiece("/resources/images/pinkBody.png",xIniciR5, yIniciR5, 0, 0);
        RobotPiece cos6 = new RobotPiece("/resources/images/pinkBody.png",xIniciR6, yIniciR6, 0, 0);
        
        //Turret
        RobotPiece turret1 = new RobotPiece("/resources/images/pinkTurret.png",xIniciR1, yIniciR1, 8, -10);
        RobotPiece turret2 = new RobotPiece("/resources/images/arnauTurret.png",xIniciR2, yIniciR2, 8, -10);
        RobotPiece turret3 = new RobotPiece("/resources/images/turret.png",xIniciR3, yIniciR3, 8, -10);
        RobotPiece turret4 = new RobotPiece("/resources/images/greenTurret.png",xIniciR4, yIniciR4, 8, -10);
        RobotPiece turret5 = new RobotPiece("/resources/images/pinkTurret.png",xIniciR5, yIniciR5, 8, -10);
        RobotPiece turret6 = new RobotPiece("/resources/images/pinkTurret.png",xIniciR6, yIniciR6, 8, -10);

        //Radar
        RobotPiece radar1 = new RobotPiece("/resources/images/pinkRadar.png",xIniciR1, yIniciR1, 7, 9);
        RobotPiece radar2 = new RobotPiece("/resources/images/arnauRadar.png",xIniciR2, yIniciR2, 7, 9);
        RobotPiece radar3 = new RobotPiece("/resources/images/radar.png",xIniciR3, yIniciR3, 7, 9);
        RobotPiece radar4 = new RobotPiece("/resources/images/yellowRadar.png",xIniciR4, yIniciR4, 7, 9);
        RobotPiece radar5 = new RobotPiece("/resources/images/arnauRadar.png",xIniciR5, yIniciR5, 7, 9);
        RobotPiece radar6 = new RobotPiece("/resources/images/pinkRadar.png",xIniciR6, yIniciR6, 7, 9);
        
        // Robot sencer
        Robot1 r1 = new Robot1(xIniciR1, yIniciR1, cos1, turret1, radar1);
        Robot2 r2 = new Robot2(xIniciR2, yIniciR2, cos2, turret2, radar2);
        Robot3 r3 = new Robot3(xIniciR3, yIniciR3, cos3, turret3, radar3);
        Robot4 r4 = new Robot4(xIniciR4, yIniciR4, cos4, turret4, radar4);
        Robot1 r5 = new Robot1(xIniciR5, yIniciR5, cos5, turret5, radar5);
        Robot1 r6 = new Robot1(xIniciR6, yIniciR6, cos6, turret6, radar6);

        ArrayList<SimulatorRobot> r = new ArrayList<SimulatorRobot>();
        r.add(r1);
        r.add(r2);
        r.add(r3);
        r.add(r4);
        r.add(r5);
        r.add(r6);
        
        ArrayList<SimulatorRobot> rb = new ArrayList<SimulatorRobot>();
        
        for (int i = 0; i < numRobots; i++) {
            rb.add(r.get(i));
        }
        
        new BattleWindow(rb);
        
    }
}