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
import static libraries.Board.bullets;
import static libraries.Board.robots;

/**
 *
 * @author rbarberan
 */
public class statesDisplay extends JPanel{
    
//    public static final int WIDTH = 50;
//    public static final int HEIGHT = 50;

    public static ArrayList<SimulatorRobot> robots;
    
    public statesDisplay(ArrayList<SimulatorRobot> r) {
        this.robots = r;
       
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
    }
    
}
