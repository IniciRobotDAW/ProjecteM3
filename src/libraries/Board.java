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
import inicirobot.Ovni;
<<<<<<< HEAD

=======
import java.awt.Dimension;
>>>>>>> parent of f4468ed... Merda
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static libraries.Board.robots;

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
    public static ArrayList<Ovni> ovnis;
    private long lastOvni = System.currentTimeMillis();

    private int nextOvni = (int)((Math.random()*(10000-5000)+5000));
//    private int nextOvni = 0;
    
    public static String theme;
    public int numObstacles;
    private BufferedImage explosionAnimImg;
<<<<<<< HEAD
 
=======
    
    public Board(ArrayList<SimulatorRobot> r, String theme, int taskBarSize) {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int)screenSize.getWidth();
        HEIGHT = (int)screenSize.getHeight()-taskBarSize*2;
        
        setDoubleBuffered(true);
        this.bullets = new Vector();
        this.deadRobots = new ArrayList();
        this.pills = new ArrayList();
        this.expAnim = new ArrayList();
        this.obstacles = new ArrayList();
        this.ovnis = new ArrayList();
        this.robots = r;
        this.theme = theme;

        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i) != null) {
                new Thread(robots.get(i)).start();
                pills.add(new HealthPill());
            }
        }

        numObstacles = 1;
        
        for(int i=0; i<numObstacles; i++){
           
            boolean in = false;
            while(!in){
                Obstacle obs = new Obstacle();
                Rectangle2D robstacle = new Rectangle((int)obs.getX(), (int)obs.getY(), obs.getWidth(), obs.getHeight());

                for(int c=0; c<Board.robots.size(); c++){

                    Rectangle2D rrobot = new Rectangle((int)Board.robots.get(c).getX(), (int)Board.robots.get(c).getY(), Board.robots.get(c).getWidth(), Board.robots.get(c).getHeight());

                    if(!rrobot.intersects(robstacle)){
                        obstacles.add(obs);
                        in = true;
                        return;
                    } 
                }
            }
        }

>>>>>>> parent of f4468ed... Merda
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

    public static String getTheme() {
        return theme;
    }

    public int getNumObstacles() {
        return numObstacles;
    }

    public void setTheme(String theme) {
        Board.theme = theme;
    }

    public void setNumObstacles(int numObstacles) {
        this.numObstacles = numObstacles;
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
        
        for (int j = 0; j < ovnis.size(); j++) {
            ovnis.get(j).paintObj(g, this);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }
    
    public void act() {
        
        SimulatorBullet b = null;
        HealthPill h = null;
        Explote e = null;
        Ovni o = null;
        
        long now = System.currentTimeMillis();
        

        if((ovnis.isEmpty())&&(now>this.lastOvni+this.nextOvni)){


//        if(ovnis.size()==0){

            Ovni ov = new Ovni();
            ovnis.add(ov);
           
            this.lastOvni=now;
            this.nextOvni = (int)((Math.random()*(30000-10000)+10000));
        }
        
        for (int i = 0; i < pills.size(); i++) {
            h = pills.get(i);
            if(!h.isVisible()){
                pills.remove(h);
            }
        }
        
         for (int i = 0; i < ovnis.size(); i++) {
            o = ovnis.get(i);
            if(!o.isVisible()){
                ovnis.remove(o);
            } else {
                o.move();
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
            if (b.isVisible() && b.inBoard() && !b.touchRobot()&& !b.touchObject()) {
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
