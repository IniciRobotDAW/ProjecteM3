/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Bernat
 */
public class Board extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static Vector<SimulatorBullet> bullets;
    public static ArrayList<SimulatorRobot> robots;
    public static ArrayList<SimulatorRobot> deadRobots;

    public Board(ArrayList<SimulatorRobot> r) {

        setDoubleBuffered(true);
        this.bullets = new Vector<SimulatorBullet>();
        this.deadRobots = new ArrayList<SimulatorRobot>();
        this.robots = r;

        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i) != null) {
                new Thread(robots.get(i)).start();
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i) != null) {
                robots.get(i).paintObj(g, this);
            }
        }
        for (int j = 0; j < bullets.size(); j++) {
            bullets.get(j).paintObj(g, this);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static ArrayList<SimulatorRobot> getRobots() {
        return robots;
    }

    public static void setRobots(ArrayList<SimulatorRobot> robots) {
        Board.robots = robots;
    }

    public static Vector<SimulatorBullet> getBullets() {
        return bullets;
    }

    public static void setBullets(Vector<SimulatorBullet> bullets) {
        Board.bullets = bullets;
    }

    public void act() {
        SimulatorBullet b = null;

        for (int j = 0; j < bullets.size(); j++) {
            b = bullets.get(j);
            if (b.isVisible() && b.inBoard() && !b.touchRobot()) {
                b.move();
            } else {
                Board.bullets.remove(b);
            }
        }

    }

}
