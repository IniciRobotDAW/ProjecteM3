/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author rbarberan
 */
public class statesDisplay extends JPanel {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
//    private static SimulatorRobot tank1;
//    private static SimulatorRobot tank2;
//
//    public statesDisplay(SimulatorRobot r1,SimulatorRobot r2) {		
//            setDoubleBuffered(true);
//            tank1=r1; 
//            tank2=r2; 
//    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);                
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public static int getWIDTH() {
            return WIDTH;
    }

    public static int getHEIGHT() {
            return HEIGHT;
    }
}
