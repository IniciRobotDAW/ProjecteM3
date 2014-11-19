/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import robotlibrary3.*;

/**
 *
 * @author atorrillas
 */
public class IniciRobot extends JPanel{

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);		
        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);

        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
    }
    
    public static void main(String[] args) {
        
        int xIniciR1 = 300;
        int yIniciR1 = 200;
        
        int xIniciR2 = 400;
        int yIniciR2 = 200;
        
        
        //Cos
        RobotPiece cos1 = new RobotPiece("/resources/images/ricardbody.png",xIniciR1, yIniciR1, 0, 0);
        RobotPiece cos2 = new RobotPiece("/resources/images/arnauBody.png",xIniciR2, yIniciR2, 0, 0);
        
        //Turret
        RobotPiece turret1 = new RobotPiece("/resources/images/ricardTurret.png",xIniciR1, yIniciR1, 8, -10);
        RobotPiece turret2 = new RobotPiece("/resources/images/arnauTurret.png",xIniciR2, yIniciR2, 8, -10);
        
        //Radar
        RobotPiece radar1 = new RobotPiece("/resources/images/ricardRadar.png",xIniciR1, yIniciR1, 7, 9);
        RobotPiece radar2 = new RobotPiece("/resources/images/arnauRadar.png",xIniciR2, yIniciR2, 7, 9);
        
        // Robot sencer
        Robot1 r1 = new Robot1(xIniciR1, yIniciR1, cos1, turret1, radar1);
        Robot2 r2 = new Robot2(xIniciR2, yIniciR2, cos2, turret2, radar2);
        
        BattleWindow Panel = new BattleWindow(r1, r2);
    }
}