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
public class StatesDisplay extends JPanel{
    

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
            
        
          String xr1 = String.valueOf(Math.rint(tank1.getX()*100)/100);
          String yr1 = String.valueOf(Math.rint(tank1.getY()*100)/100);
          String br1 = String.valueOf(tank1.getBulletsLoad());
          String lr1 = String.valueOf(tank1.getLives());

        g.drawString("ROBOT 1", 10, 30);
        g.drawString("X-->", 10, 50);
        g.drawString(xr1, 40, 50);
        g.drawString("Y-->", 100, 50);
        g.drawString(yr1, 130, 50);
        
        g.drawString("LIVES-->", 10, 70);
        g.drawString(lr1, 70, 70);
        g.drawString("BULLETS-->", 10, 90);
        g.drawString(br1, 80, 90);        
        
        String xr2 = String.valueOf(Math.rint(tank2.getX()*100)/100);
        String yr2 = String.valueOf(Math.rint(tank2.getY()*100)/100);
        String br2 = String.valueOf(tank2.getBulletsLoad());
        String lr2 = String.valueOf(tank2.getLives());

        g.drawString("ROBOT 2", 10, 110);
        g.drawString("X-->", 10, 130);
        g.drawString(xr2, 40, 130);
        g.drawString("Y-->", 100, 130);
        g.drawString(yr2, 130, 130);
        g.drawString("LIVES-->", 10, 150);
        g.drawString(lr2, 70, 150);
        g.drawString("BULLETS-->", 10, 170);
        g.drawString(br2, 80, 170);     
        
    }
    
    public StatesDisplay(Graphics g, Double xr1){
       
       
       g.drawString("ROBOT 1", 10, 30);
      
       g.drawString("ROBOT 1", 10, 30);
      
    }
}
