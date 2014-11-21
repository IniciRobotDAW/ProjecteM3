/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Bernat
 */
public interface SimulatorObject {
    public abstract void paintObj(Graphics g, JComponent c);
    
    public abstract double getX();

    public abstract double getY();   
    
    public abstract boolean isVisible();

    


  
    
}
