/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

import inicirobot.*;
import java.lang.String;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;

import static libraries.Board.bullets;
import static libraries.Board.robots;

/**
 *
 * @author rbarberan
 */
public class StatesDisplay extends JPanel {

    private static SimulatorRobot tank1;
    private static SimulatorRobot tank2;

//    public static final int WIDTH = 50;
//    public static final int HEIGHT = 50;
    public static ArrayList<SimulatorRobot> robots;

    public StatesDisplay(ArrayList<SimulatorRobot> r) {
        this.robots = r;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < Board.robots.size(); i++) {
            String xr1 = String.valueOf(Math.rint(Board.robots.get(i).getX() * 100) / 100);
            String yr1 = String.valueOf(Math.rint(Board.robots.get(i).getY() * 100) / 100);
            String br1 = String.valueOf(Board.robots.get(i).getBulletsLoad());
            String lr1 = String.valueOf(Board.robots.get(i).getLives());

            g.drawString("ROBOT 1", 10, 30);
            g.drawString("X-->", 10, 50);
            g.drawString(xr1, 40, 50);
            g.drawString("Y-->", 100, 50);
            g.drawString(yr1, 130, 50);

            g.drawString("LIVES-->", 10, 70);
            g.drawString(lr1, 70, 70);
            g.drawString("BULLETS-->", 10, 90);
            g.drawString(br1, 80, 90);

        }

    }

    public StatesDisplay(Graphics g, Double xr1) {

        g.drawString("ROBOT 1", 10, 30);

        g.drawString("ROBOT 1", 10, 30);

    }
}
