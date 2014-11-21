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
public class Board extends JPanel{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

//    private static SimulatorRobot tank1;
//    private static SimulatorRobot tank2;
    public static Vector<SimulatorBullet> bullets;
    public static ArrayList<SimulatorRobot> robots;

    public Board(SimulatorRobot r1,SimulatorRobot r2) {		

            setDoubleBuffered(true);
            bullets = new Vector<SimulatorBullet>();
            robots = new ArrayList<SimulatorRobot>();
//            this.tank1=r1;
//            this.tank2=r2;
            robots.add(r1);
            robots.add(r2);
            for (int i = 0; i < robots.size(); i++) {
                if(robots.get(i)!=null) new Thread(robots.get(i)).start();
            }
            
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);                
        
        for (int i = 0; i < robots.size(); i++){
            if(robots.get(i)!=null)robots.get(i).paintObj(g, this);
        }
        for (int j = 0; j < bullets.size(); j++)bullets.get(j).paintObj(g,this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public static int getWIDTH() {
            return WIDTH;
    }

    public static int getHEIGHT() {
            return HEIGHT;
    }

//    public static SimulatorRobot getTank1() {
//        return tank1;
//    }
//
//    public void setTank1(SimulatorRobot tank1) {
//        this.tank1 = tank1;
//    }
//
//    public static SimulatorRobot getTank2() {
//        return tank2;
//    }
//
//    public void setTank2(SimulatorRobot tank2) {
//        this.tank2 = tank2;
//    }  
    
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
        SimulatorBullet b=null;
//        SimulatorRobot r=null;
        
//        for (int i = 0; i < robots.size(); i++){
//            r=robots.get(i);
//            if (r.isVisible() && r.inBoard()) {
//                r.();
//            } else {  
//                Board.robots.remove(r);
//            }			
//        }
        
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
