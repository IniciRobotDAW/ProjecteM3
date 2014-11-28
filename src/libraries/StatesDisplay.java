/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.lang.*;

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

        int dDibuixRobot = 45;
        
        int dRec = 10;
        int dGetL = 60;
        int dGetB = 35;
        int dGetBd = 42;
        int dBpro2 = 38;
        int dBpro = 40;
        int dBliv = 49;
        int dBrec = 17;
        int interlinieat = 90;
        
        for (int i = 0; i < Board.robots.size(); i++) {
             
            Color colors = new Color (35, 52, 5);
            g.setColor(colors);
            g.fillRect(5, dRec, 180, 80);
                        
            //Rodona bullets
            int angle = (int) (((float)Board.robots.get(i).getBulletsLoad() / (float)Board.robots.get(i).getStartBulletsLoad()) * 360);
            g.setColor(Color.gray);
            g.fillArc(58, dBpro2, 29, 29, 50, 360);
            g.setColor(Color.black);
            g.fillArc(60, dBpro, 25, 25, 50, angle);
            
            //Vides
            int lr1 = Board.robots.get(i).getLives();
            int vides = ((lr1*70)/Board.robots.get(i).getStartLives());
            g.setColor(Color.red);
            g.fillRect(100, dBliv, 70, 5);
            g.setColor(Color.green);
            g.fillRect(100, dBliv, vides, 5);
            g.setColor(Color.black);
            
            //Reload
            if (Board.robots.get(i).getLastReload()+Board.robots.get(i).getReloadTime()<System.currentTimeMillis()){
               g.setColor(Color.green);
              
            } else {
                g.setColor(Color.red);   
            }

            g.fillArc(22, dBrec, 10, 11, 0, 360);
            g.setColor(Color.black);
            
            //Bullets
            String br1 = String.valueOf(Board.robots.get(i).getBulletsLoad());
            g.setColor(Color.white);
            g.drawString(br1, 66, dBpro+17);
            g.setColor(Color.black);
            g.drawImage(Board.robots.get(i).getBody().getImage(), 10, dDibuixRobot, null);
            
            //Desplaçament del Turret + turret
            double dxt = Board.robots.get(i).getTurret().getDx();
            int dxtf = (int)dxt;
            double dxy = Board.robots.get(i).getTurret().getDy();
            int dytf = (int)dxy; 
            g.drawImage(Board.robots.get(i).getTurret().getImage(), 10+dxtf, dDibuixRobot+dytf, null);
            
            //Desplaçament del radar + radar
            double dxr = Board.robots.get(i).getRadar().getDx();
            int dxrf = (int)dxr;
            double dyr = Board.robots.get(i).getRadar().getDy();
            int dyrf = (int)dyr;
            g.drawImage(Board.robots.get(i).getRadar().getImage(), 10+dxrf, dDibuixRobot+dyrf, null);
            
            //Suma posicio
            dRec = dRec + interlinieat;
            dDibuixRobot = dDibuixRobot + interlinieat;
            dGetL = dGetL + interlinieat;
            dGetB = dGetB + interlinieat;
            dBpro = dBpro + interlinieat;
            dBpro2 = dBpro2 + interlinieat;
            dBliv = dBliv +  interlinieat;
            dBrec = dBrec +  interlinieat;
            dGetBd = dGetBd +interlinieat;
        }
        
    }

    public StatesDisplay(Graphics g, Double xr1) {

        g.drawString("ROBOT 1", 10, 30);

        g.drawString("ROBOT 1", 10, 30);

    }
}
