/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


import inicirobot.Explote;
import inicirobot.HealthPill;
import inicirobot.Obstacle;
import inicirobot.Robot;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Bernat
 */
public class Board extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static Vector<SimulatorBullet> bullets;
    public static ArrayList<SimulatorRobot> robots;
    public static ArrayList<SimulatorRobot> deadRobots;
    public static ArrayList<HealthPill> pills;
    public static ArrayList<Explote> expAnim;
    public static ArrayList<Obstacle> obstacles;
    
   private BufferedImage explosionAnimImg;
    
    public Board(ArrayList<SimulatorRobot> r) {

        setDoubleBuffered(true);
        this.bullets = new Vector<SimulatorBullet>();
        this.deadRobots = new ArrayList<SimulatorRobot>();
        this.pills = new ArrayList<HealthPill>();
        this.expAnim = new ArrayList<Explote>();
        this.obstacles = new ArrayList<Obstacle>();
        this.robots = r;
        
        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i) != null) {
                new Thread(robots.get(i)).start();
                pills.add(new HealthPill());
            }
        }
        
        Obstacle obs = new Obstacle();
        obstacles.add(obs);
        
    }
    
    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static ArrayList<SimulatorRobot> getRobots() {
        return robots;
    }

    public static void setRobots(ArrayList<SimulatorRobot> robots) {
        Board.robots = robots;
    }

    public static Vector<SimulatorBullet> getBullets() {
        return bullets;
    }

    public static ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public static void setObstacles(ArrayList<Obstacle> obstacles) {
        Board.obstacles = obstacles;
    }
    
    

    public static void setBullets(Vector<SimulatorBullet> bullets) {
        Board.bullets = bullets;
    }
    
    public static ArrayList<HealthPill> getPills() {
        return pills;
    }

    public static ArrayList<Explote> getExpAnim() {
        return expAnim;
    }

    public static void setExpAnim(ArrayList<Explote> expAnim) {
        Board.expAnim = expAnim;
    }
    
    

    public static void setPills(ArrayList<HealthPill> pills) {
        Board.pills = pills;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
         Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i < pills.size(); i++) {
            pills.get(i).paintObj(g, this);
        }
        
        for (int j = 0; j < bullets.size(); j++) {
            bullets.get(j).paintObj(g, this);
        }
        
        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i) != null) {
                robots.get(i).paintObj(g, this);
            }
        }
       
        for (int i = 0; i < obstacles.size(); i++) {
            obstacles.get(i).paintObj(g, this);
        }
        
        for (int i = 0; i < expAnim.size(); i++) {
            if (expAnim.get(i) != null) {
                expAnim.get(i).Draw(g2d);
            }
        }
        
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void act() {
        SimulatorBullet b = null;
        HealthPill h = null;
        Explote e = null;
        
        for (int i = 0; i < pills.size(); i++) {
            h = pills.get(i);
            if(!h.isVisible()){
                pills.remove(h);
            }
        }
        
        for (int i = 0; i < expAnim.size(); i++) {
            e = expAnim.get(i);
            if(!e.active){
                expAnim.remove(e);
            }
        }
        
        for (int j = 0; j < bullets.size(); j++) {
            b = bullets.get(j);
            if (b.isVisible() && b.inBoard() && !b.touchRobot()) {
                b.move();
            } else {
                if(!b.inBoard()){
                    URL explosionAnimImgUrl = this.getClass().getResource("/resources/images/exploteBullet.png");
                    try {
                         explosionAnimImg = ImageIO.read(explosionAnimImgUrl);
                    } catch (IOException ex) {
                         Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Explote expAnim2 = new Explote(explosionAnimImg, 60, 60, 46, 7, false, (int)b.getX()-20, (int)b.getY()-25, 0);
                    Board.getExpAnim().add(expAnim2);
                }
                Board.bullets.remove(b);
            }
        }
    }
}
