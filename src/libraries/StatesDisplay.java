/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import inicirobot.Ovni;
import java.awt.*;
import java.awt.geom.*;

import java.util.*;
import javax.swing.*;

import java.awt.image.AffineTransformOp;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author rbarberan
 */
public class StatesDisplay extends JPanel {

    public static ArrayList<SimulatorRobot> robots;

    public StatesDisplay(ArrayList<SimulatorRobot> r, int stateW,int stateH) {
        this.robots = r;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int dDibuixRobot = 30;
        
        int dRec = 10;
        int dGetL = 60;
        int dGetB = 35;
        int dGetBd = 42;
       
        int dBpro = 30;
        int dBpro2 = dBpro-2;
        
        int dBliv = 37;
        int dBrec = 65;
        int interlinieat = 90;
        ImageIcon reloadButton;
        ImageIcon plate;
        ImageIcon velo;
        ImageIcon fle;

        switch(Board.getTheme()){
             case "Desert": 
                plate = new ImageIcon(this.getClass().getResource("/resources/images/panel/plate.png"));
                break;
                
            case "Forest": 
                
                plate = new ImageIcon(this.getClass().getResource("/resources/images/panel/plate.png"));
                break;
            
            case "Spacial": 
                plate = new ImageIcon(this.getClass().getResource("/resources/images/panel/plate.png"));
                
                break;
            
            case "Sea": 
                plate = new ImageIcon(this.getClass().getResource("/resources/images/panel/seaState.png"));
                break;
                        
            default: 
                plate = new ImageIcon(this.getClass().getResource("/resources/images/panel/plate.png"));
                
                break;                  
            
        }
        

        for (int i = 0; i < Board.robots.size(); i++) {
            
            g.drawImage(plate.getImage(), 5, dRec, null);
                        
            //Marcador bullets restants
            int angle = (int) (((float)Board.robots.get(i).getBulletsLoad() / (float)Board.robots.get(i).getStartBulletsLoad()) * 180);
//            g.setColor(Color.black);
//            g.fillArc(58, dBpro2, 29, 29, 0, 180);
//            g.setColor(Color.red);
//            g.fillArc(60, dBpro, 25, 25, 0, angle);
           
            velo = new ImageIcon(this.getClass().getResource("/resources/images/panel/velos.png"));
            g.drawImage(velo.getImage(), 55, dBpro, null);
          
            Graphics2D g2d = (Graphics2D) g;
            fle = new ImageIcon(this.getClass().getResource("/resources/images/panel/fletxa.png"));
            AffineTransform at = new AffineTransform();
            
            at.translate(71, dBpro+15);
            at.rotate(Math.toRadians(angle-180),3,3);
            
//            g.fillArc(60, dBpro, 25, 25, 0, angle);
            g2d.drawImage(fle.getImage(),at,null);
            
           
            //Bullets
            String br1 = String.valueOf(Board.robots.get(i).getBulletsLoad());
            g.setColor(Color.white);
            g.drawString(br1, 68, dBpro+33);
            g.setColor(Color.black);
            
//            //Vides
            int lr1 = Board.robots.get(i).getLives();
            int d = 150/Board.robots.get(i).getLives();
//            int despVides = ((lr1*(d*Board.robots.get(i).getStartLives()))/Board.robots.get(i).getStartLives());
            System.out.println(d);
//            g.setColor(Color.red);
//            g.fillRect(100, dBliv, 70, 5);
//            g.setColor(Color.green);
//            g.fillRect(100, dBliv, vides, 5);
//            g.setColor(Color.black);
            velo = new ImageIcon(this.getClass().getResource("/resources/images/panel/panellVides.png"));
            g.drawImage(velo.getImage(), 110, dBliv, null);
            
            velo = new ImageIcon(this.getClass().getResource("/resources/images/panel/videsFletxa.png"));
            g.drawImage(velo.getImage(), 120+d, dBliv+10, null);
            
            
            //Reload
            if (Board.robots.get(i).getLastReload()+Board.robots.get(i).getReloadTime()<System.currentTimeMillis()){
                reloadButton = new ImageIcon(this.getClass().getResource("/resources/images/panel/buttonGreen.png"));
            } else {
                reloadButton = new ImageIcon(this.getClass().getResource("/resources/images/panel/buttonRed.png"));
            }

            g.drawImage(reloadButton.getImage(), 68, dBpro-15, null);
            
            
            //Robots
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

}
