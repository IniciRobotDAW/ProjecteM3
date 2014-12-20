/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import libraries.Board;
import libraries.SimulatorRobot;

/**
 *
 * @author rbarberan
 */
public class Factory {

    private DefaultListModel selectedRobots;
    private ArrayList<SimulatorRobot> robots;
    private ArrayList<SimulatorRobot> robotsTotal;
    
    public Factory(DefaultListModel selectedRobots) {
        this.selectedRobots = selectedRobots;
        this.robots = new ArrayList<SimulatorRobot>();
        this.robotsTotal = new ArrayList<SimulatorRobot>();
    }

    public ArrayList<SimulatorRobot> deploy() {

        int W = Board.WIDTH-30;
        int H = Board.HEIGHT-30;
        
        for (int i = 0; i < selectedRobots.getSize(); i++) {
            
            //Anem agafant els noms dels robots seleccionats
            String[] nameRobotSplit = selectedRobots.get(i).toString().split("\\.");
            Object nameRobot = nameRobotSplit[0];
            
            //Marquem la posició del robot
            int xInici = (int) (Math.random() * W + 1);
            int yInici = (int) (Math.random() * H + 1);

            //Fabricació dels xassís
            RobotPiece cos1 = new RobotPiece("/resources/images/pinkBody.png", xInici, yInici, 0, 0);
//            RobotPiece cos2 = new RobotPiece("/resources/images/arnauBody.png", xInici, yInici, 0, 0);
//            RobotPiece cos3 = new RobotPiece("/resources/images/body.png", xInici, yInici, 0, 0);
//            RobotPiece cos4 = new RobotPiece("/resources/images/greenBody.png", xInici, yInici, 0, 0);
//            RobotPiece cos5 = new RobotPiece("/resources/images/pinkBody.png", xInici, yInici, 0, 0);
//            RobotPiece cos6 = new RobotPiece("/resources/images/pinkBody.png", xInici, yInici, 0, 0);

            //Fabricació dels canons
            RobotPiece turret1 = new RobotPiece("/resources/images/pinkTurret.png", xInici, yInici, 8, -10);
    //        RobotPiece turret2 = new RobotPiece("/resources/images/arnauTurret.png", xInici, yInici, 8, -10);
    //        RobotPiece turret3 = new RobotPiece("/resources/images/turret.png", xInici, yInici, 8, -10);
    //        RobotPiece turret4 = new RobotPiece("/resources/images/greenTurret.png", xInici, yInici, 8, -10);
    //        RobotPiece turret5 = new RobotPiece("/resources/images/pinkTurret.png", xInici, yInici, 8, -10);
    //        RobotPiece turret6 = new RobotPiece("/resources/images/pinkTurret.png", xInici, yInici, 8, -10);

            //Fabricació dels radars
            RobotPiece radar1 = new RobotPiece("/resources/images/pinkRadar.png", xInici, yInici, 7, 9);
    //        RobotPiece radar2 = new RobotPiece("/resources/images/arnauRadar.png", xInici, yInici, 7, 9);
    //        RobotPiece radar3 = new RobotPiece("/resources/images/radar.png", xInici, yInici, 7, 9);
    //        RobotPiece radar4 = new RobotPiece("/resources/images/yellowRadar.png", xInici, yInici, 7, 9);
    //        RobotPiece radar5 = new RobotPiece("/resources/images/arnauRadar.png", xInici, yInici, 7, 9);
    //        RobotPiece radar6 = new RobotPiece("/resources/images/pinkRadar.png", xInici, yInici, 7, 9);
            
            this.robotsTotal.add(new nameRobot(xInici, yInici, cos1, turret1, radar1));
//            Robot1 r1 = new Robot1(xInici, yInici, cos1, turret1, radar1);
    //        Robot2 r2 = new Robot2(xIniciR2, yInici, cos2, turret2, radar2);
    //        Robot3 r3 = new Robot3(xIniciR3, yInici, cos3, turret3, radar3);
    //        Robot4 r4 = new Robot4(xInici, yInici, cos4, turret4, radar4);
    //        Robot1 r5 = new Robot1(xInici, yInici, cos5, turret5, radar5);
    //        Robot1 r6 = new Robot1(xIniciR6, yIniciR6, cos6, turret6, radar6);

    //        this.robotsTotal.add(r1);
    //        this.robotsTotal.add(r2);
    //        this.robotsTotal.add(r3);
    //        this.robotsTotal.add(r4);
    //        this.robotsTotal.add(r5);
    //        this.robotsTotal.add(r6);

//            this.robots.add(this.robotsTotal.get(i));
            
        }

        return this.robots;

    }

}
