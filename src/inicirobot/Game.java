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
import java.util.HashMap;
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
        
//        Stock stock = new Stock();
        
        int W = Board.WIDTH - 30;
        int H = Board.HEIGHT - 30;

        posXs.add(Math.random() * W + 1);
        posYs.add(Math.random() * H + 1);

        for (int i = 0; i < 5; i++) {

            tposXs = Math.random() * W + 1;
            tposYs = Math.random() * H + 1;

            for (int j = 0; j < posXs.size(); j++) {

                Line ln = new Line(posXs.get(j), posYs.get(j), posXs.get(j) + 20, posYs.get(j) + 20);

                while (ln.contains(tposXs, tposYs)) {
                    tposXs = Math.random() * W + 1;
                    tposYs = Math.random() * H + 1;
                }
            }

            this.posXs.add(tposXs);
            this.posYs.add(tposYs);
            System.out.println(this.posXs.size());
        }

        for (int i = 0; i < this.selectedRobots.getSize(); i++) {

            String[] nameRobotSplit = selectedRobots.get(i).toString().split("\\.");
            String nameRobot = nameRobotSplit[0];
            
            try {
                Class robotClass = Class.forName("resources.robots." + nameRobot);
                try {
                    Constructor robotConstructor = robotClass.getConstructor(
                            new Class[]{
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
                            new RobotPiece("/resources/images/realBody.png", posXs.get(i), posYs.get(i), 0, 0),
                            new RobotPiece("/resources/images/realTurret.png", posXs.get(i), posYs.get(i), 8, -10),
                            new RobotPiece("/resources/images/realRadar.png", posXs.get(i), posYs.get(i), 7, 9)
                    ));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return this.robots;

    }

}
