/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JPanel;


/**
 *
 * @author Bernat
 */
public class Board extends JPanel{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private static SimulatorRobot tank1;
    private static SimulatorRobot tank2;
    public static Vector<SimulatorBullet> bullets;

    public Board(SimulatorRobot r1,SimulatorRobot r2) {		

            setDoubleBuffered(true);
            bullets = new Vector<SimulatorBullet>();
            this.tank1=r1; 
            this.tank2=r2; 
            if(tank1!=null) new Thread(tank1).start();
            if(tank2!=null)new Thread(tank2).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);                
        if(tank1!=null)tank1.paintObj(g, this);
        if(tank2!=null)tank2.paintObj(g, this);
        for (int j = 0; j < bullets.size(); j++)
			bullets.get(j).paintObj(g,this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public static int getWIDTH() {
            return WIDTH;
    }

    public static int getHEIGHT() {
            return HEIGHT;
    }

    public static SimulatorRobot getTank1() {
        return tank1;
    }

    public void setTank1(SimulatorRobot tank1) {
        this.tank1 = tank1;
    }

    public static SimulatorRobot getTank2() {
        return tank2;
    }

    public void setTank2(SimulatorRobot tank2) {
        this.tank2 = tank2;
    }  

    public static Vector<SimulatorBullet> getBullets() {
        return bullets;
    }

    public static void setBullets(Vector<SimulatorBullet> bullets) {
        Board.bullets = bullets;
    }    
    
    public void act() {        
        SimulatorBullet b=null;        
        for (int j = 0; j < bullets.size(); j++){
            b=bullets.get(j);
            if (b.isVisible() && b.inBoard()) {
                b.move();
            } else {  
                Board.bullets.remove(b);
            }			
        }
    }
    
}
