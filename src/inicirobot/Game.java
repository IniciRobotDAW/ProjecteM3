/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;


import java.lang.reflect.Constructor;

import inicirobot.RobotPiece;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javafx.scene.shape.Line;
import javax.swing.DefaultListModel;
import libraries.*;
import libraries.Board;
import libraries.SimulatorRobot;
import resources.robots.*;

/**
 *
 * @author rbarberan
 */
public class Game extends Exception {

    private String theme;
    private int rounds;
    private int lifes;
    private int bullets;
    private int numRobots;
    private ArrayList<SimulatorRobot> robots;
    private DefaultListModel selectedRobots;
    private ArrayList<Double> posXs;    
    private ArrayList<Double> posYs;
    private double tposXs;
    private double tposYs;

    public Game(String theme, int rounds, int lifes, int bullets, DefaultListModel selectedRobots) {
        this.theme = theme;
        this.rounds = rounds;
        this.lifes = lifes;
        this.bullets = bullets;
        this.numRobots = selectedRobots.getSize();
        this.robots = new ArrayList<SimulatorRobot>();
        this.posXs = new ArrayList<>();
        this.posYs = new ArrayList<>();
        this.selectedRobots = selectedRobots;
    }
   
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public int getBullets() {
        return bullets;
    }

    public ArrayList<Double> getPosXs() {
        return posXs;
    }

    public ArrayList<Double> getPosYs() {
        return posYs;
    }

    public void setPosXs(ArrayList<Double> posX) {
        this.posXs = posXs;
    }

    public void setPosYs(ArrayList<Double> posY) {
        this.posYs = posYs;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getNumRobots() {
        return numRobots;
    }

    public void setNumRobots(int numRobots) {
        this.numRobots = numRobots;
    }

    public ArrayList<SimulatorRobot> getRobots() {
        return robots;
    }

    public void setRobots(ArrayList<SimulatorRobot> robots) {
        this.robots = robots;
    }

    public DefaultListModel getSelectedRobots() {
        return selectedRobots;
    }

    public void setSelectedRobots(DefaultListModel selectedRobots) {
        this.selectedRobots = selectedRobots;
    }

    public ArrayList<SimulatorRobot> deploy() throws Exception {

        int W = Board.WIDTH - 30;
        int H = Board.HEIGHT - 30;
        
//        if(this.theme=="Sea"){
//            RobotPiece cos1 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(0), posYs.get(0),0,0);
//            RobotPiece cos2 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(1), posYs.get(1), 0, 0);
//            RobotPiece cos3 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(2), posYs.get(2), 0, 0);
//            RobotPiece cos4 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(3), posYs.get(3), 0, 0);
//            RobotPiece cos5 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(4), posYs.get(4), 0, 0);
//            RobotPiece cos6 = new RobotPiece("/resources/images/boats/Boat.png", posXs.get(5), posYs.get(5), 0, 0);
//
//            //Fabricació dels canons
//            RobotPiece turret1 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(0), posYs.get(0), 0, 0);
//            RobotPiece turret2 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(1), posYs.get(1), 8, -10);
//            RobotPiece turret3 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(2), posYs.get(2), 8, -10);
//            RobotPiece turret4 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(3), posYs.get(3), 8, -10);
//            RobotPiece turret5 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(4), posYs.get(4), 8, -10);
//            RobotPiece turret6 = new RobotPiece("/resources/images/boats/boatTurret.png", posXs.get(5), posYs.get(5), 8, -10);
//
//            //Fabricació dels radars
//            RobotPiece radar1 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(0), posYs.get(0), 0, 0);
//            RobotPiece radar2 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(1), posYs.get(1), 7, 9);
//            RobotPiece radar3 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(2), posYs.get(2), 7, 9);
//            RobotPiece radar4 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(3), posYs.get(3), 7, 9);
//            RobotPiece radar5 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(4), posYs.get(4), 7, 9);
//            RobotPiece radar6 = new RobotPiece("/resources/images/boats/boatRadar.png", posXs.get(5), posYs.get(5), 7, 9);
//
//            Robot1 r1 = new Robot1(posXs.get(0), posYs.get(0), cos1, turret1, radar1);
//            Robot2 r2 = new Robot2(posXs.get(1), posYs.get(1), cos2, turret2, radar2);
//            Robot3 r3 = new Robot3(posXs.get(2), posYs.get(2), cos3, turret3, radar3);
//            Robot4 r4 = new Robot4(posXs.get(3), posYs.get(3), cos4, turret4, radar4);
//            Robot5 r5 = new Robot5(posXs.get(4), posYs.get(4), cos5, turret5, radar5);
//    //        Robot6 r6 = new Robot6(xIniciR6, yIniciR6, cos6, turret6, radar6);
//
//            robotsTotal.add(r1);
//            robotsTotal.add(r2);
//            robotsTotal.add(r3);
//            robotsTotal.add(r4);
//            robotsTotal.add(r5);
//    //        this.robotsTotal.add(r6);
//        
////        } else {
        
        posXs.add(Math.random() * W + 1);
        posYs.add(Math.random() * H + 1);

        for(int i=0; i<5; i++){
                        
            tposXs = Math.random() * W + 1;
            tposYs = Math.random() * H + 1;
             
            for(int j=0; j<posXs.size(); j++){
               
                Line ln = new Line(posXs.get(j), posYs.get(j), posXs.get(j)+20, posYs.get(j)+20);
               
                while(ln.contains(tposXs, tposYs)){
                    tposXs = Math.random() * W + 1;
                    tposYs = Math.random() * H + 1;
                }
            }

            this.posXs.add(tposXs);
            this.posYs.add(tposYs);
            System.out.println(this.posXs.size());
        }
        
        //Fabricació dels xassís
        RobotPiece cos1 = new RobotPiece("/resources/images/realBody.png", posXs.get(0), posYs.get(0),0,0);
        RobotPiece cos2 = new RobotPiece("/resources/images/arnauBody.png", posXs.get(1), posYs.get(1), 0, 0);
        RobotPiece cos3 = new RobotPiece("/resources/images/body.png", posXs.get(2), posYs.get(2), 0, 0);
        RobotPiece cos4 = new RobotPiece("/resources/images/greenBody.png", posXs.get(3), posYs.get(3), 0, 0);
        RobotPiece cos5 = new RobotPiece("/resources/images/pinkBody.png", posXs.get(4), posYs.get(4), 0, 0);
        RobotPiece cos6 = new RobotPiece("/resources/images/pinkBody.png", posXs.get(5), posYs.get(5), 0, 0);

        //Fabricació dels canons
        RobotPiece turret1 = new RobotPiece("/resources/images/realTurret.png", posXs.get(0), posYs.get(0), 8, -10);
        RobotPiece turret2 = new RobotPiece("/resources/images/arnauTurret.png", posXs.get(1), posYs.get(1), 8, -10);
        RobotPiece turret3 = new RobotPiece("/resources/images/turret.png", posXs.get(2), posYs.get(2), 8, -10);
        RobotPiece turret4 = new RobotPiece("/resources/images/greenTurret.png", posXs.get(3), posYs.get(3), 8, -10);
        RobotPiece turret5 = new RobotPiece("/resources/images/pinkTurret.png", posXs.get(4), posYs.get(4), 8, -10);
        RobotPiece turret6 = new RobotPiece("/resources/images/pinkTurret.png", posXs.get(5), posYs.get(5), 8, -10);

        //Fabricació dels radars
        RobotPiece radar1 = new RobotPiece("/resources/images/realRadar.png", posXs.get(0), posYs.get(0), 7, 9);
        RobotPiece radar2 = new RobotPiece("/resources/images/arnauRadar.png", posXs.get(1), posYs.get(1), 7, 9);
        RobotPiece radar3 = new RobotPiece("/resources/images/radar.png", posXs.get(2), posYs.get(2), 7, 9);
        RobotPiece radar4 = new RobotPiece("/resources/images/yellowRadar.png", posXs.get(3), posYs.get(3), 7, 9);
        RobotPiece radar5 = new RobotPiece("/resources/images/arnauRadar.png", posXs.get(4), posYs.get(4), 7, 9);
        RobotPiece radar6 = new RobotPiece("/resources/images/pinkRadar.png", posXs.get(5), posYs.get(5), 7, 9);
        
        for (int i = 0; i < this.selectedRobots.getSize(); i++) {

            String[] nameRobotSplit = selectedRobots.get(i).toString().split("\\.");
            String nameRobot = nameRobotSplit[0];

            try {
                Class robotClass = Class.forName("resources.robots." + nameRobot);
                try{
                    Constructor robotConstructor = robotClass.getConstructor(
                            new Class[] {
                                double.class,
                                double.class,
                                RobotPiece.class,
                                RobotPiece.class,
                                RobotPiece.class
                            }
                    );
                    this.robots.add((SimulatorRobot) robotConstructor.newInstance(
                            this.posXs.get(i),
                            this.posYs.get(i),
                            cos1,
                            turret1,
                            radar1
                    ));   
                } catch(NoSuchMethodException e){
                    e.printStackTrace();
                }   
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return this.robots;

    }
    
}
