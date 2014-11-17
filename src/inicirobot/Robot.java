/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import robotlibrary3.*;

/**
 *
 * @author atorrillas, rbarberan abstract
 */
public abstract class Robot extends GraphicObject implements SimulatorRobot {

    private int speed;
    private int lives;
    private RobotPiece body;
    private RobotPiece turret;
    private RobotPiece radar;
    private int width;
    private int height;
    private double lastReload = System.nanoTime();
    private int bulletsLoad; 

    /** Constructor */
    public Robot(double x, double y, float angle, int speed, int lives, RobotPiece body, RobotPiece turret, RobotPiece radar, int width, int height, double lastReload) {
        super(x, y, angle);

        this.speed = speed;
        this.lives = lives;
        this.body = body;
        this.turret = turret;
        this.radar = radar;
        this.width = width;
        this.height = height;
        this.lastReload = System.nanoTime();
        
        this.lives = 20;
        this.bulletsLoad = 40;

    }

    public Robot(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, 0.0f);

        this.body = cos;
        this.turret = turret;
        this.radar = radar;

        this.width = this.body.getWidth();
        this.height = this.body.getHeight();
        
        this.lives = 20;
        this.bulletsLoad = 40;

    }

    //getters i setters
    public int getSpeed() {
        return speed;
    }

    public int getLives() {
        return lives;
    }

    public RobotPiece getBody() {
        return body;
    }

    public RobotPiece getTurret() {
        return turret;
    }

    public RobotPiece getRadar() {
        return radar;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getLastReload() {
        return lastReload;
    }

    public int getBulletsLoad() {
        return bulletsLoad;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setBody(RobotPiece body) {
        this.body = body;
    }

    public void setTurret(RobotPiece turret) {
        this.turret = turret;
    }

    public void setRadar(RobotPiece radar) {
        this.radar = radar;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public void setAngle(double angle) {
        super.setAngle(angle);
        this.body.setAngle(this.angle);
    }

    public void setLastReload(double lastReload) {
        this.lastReload = lastReload;
    }

    public void setBulletsLoad(int bulletsLoad) {
        this.bulletsLoad = bulletsLoad;
    }
    
    //************//
    //**Funcions**//
    //************//
       
    /**
     * Paint the robot / Pinta el robot
     * @param g
     * @param c 
     */
    @Override
    public void paintObj(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        this.body.paintObj(g, c);
        this.turret.paintObj(g, c);
        this.radar.paintObj(g, c);
        

//        g2d.setStroke(new BasicStroke(5f));
        //g2d.setColor(Color.red);
        //Point2D.Double p = new Point2D.Double(500,500);
        //g2d.drawLine((int)p.getX(), (int)p.getY(), (int)p.getX(), (int)p.getY());

        //g2d.setColor(Color.blue);
        //Point2D.Double p2 = this.movePoint((int)p.getX(), (int)p.getY(), 90, 90);
        //g2d.drawLine((int)p2.getX(), (int)p2.getY(), (int)p2.getX(), (int)p2.getY());
        //Point2D.Double pinicial = new Point2D.Double(500, 400);
        //g2d.drawLine((int)pinicial.getX(), (int)pinicial.getY(), (int)pinicial.getX(), (int)pinicial.getY());
//        AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.angle), x + this.width / 2, y + this.height / 2);

        //Punts de fora
//        Point2D p1 = new Point2D.Double(x, y);
//        Point2D p1final = new Point2D.Double();
//        p1final = transformer.transform(p1, p1final);
//
//        Point2D p2 = new Point2D.Double(x + this.width, y);
//        Point2D p2final = new Point2D.Double();
//        p2final = transformer.transform(p2, p2final);
//
//        Point2D p3 = new Point2D.Double(x + this.width, y + this.height);
//        Point2D p3final = new Point2D.Double();
//        p3final = transformer.transform(p3, p3final);
//
//        Point2D p4 = new Point2D.Double(x, y + this.height);
//        Point2D p4final = new Point2D.Double();
//        p4final = transformer.transform(p4, p4final);
//
//        //punts de dins
//        Point2D p1i = new Point2D.Double(x + 2, y + 2);
//        Point2D p1finali = new Point2D.Double();
//        p1finali = transformer.transform(p1i, p1finali);
//
//        Point2D p2i = new Point2D.Double(x + this.width - 2, y + 2);
//        Point2D p2finali = new Point2D.Double();
//        p2finali = transformer.transform(p2i, p2finali);
//
//        Point2D p3i = new Point2D.Double(x + this.width - 2, y + this.height - 2);
//        Point2D p3finali = new Point2D.Double();
//        p3finali = transformer.transform(p3i, p3finali);
//
//        Point2D p4i = new Point2D.Double(x + 2, y + this.height - 2);
//        Point2D p4finali = new Point2D.Double();
//        p4finali = transformer.transform(p4i, p4finali);

        //pintar linies exteriors
//        g2d.setColor(Color.blue);
//        g2d.drawLine((int) p1final.getX(), (int) p1final.getY(), (int) p2final.getX(), (int) p2final.getY());
//        g2d.drawLine((int) p2final.getX(), (int) p2final.getY(), (int) p3final.getX(), (int) p3final.getY());
//        g2d.drawLine((int) p3final.getX(), (int) p3final.getY(), (int) p4final.getX(), (int) p4final.getY());
//        g2d.drawLine((int) p4final.getX(), (int) p4final.getY(), (int) p1final.getX(), (int) p1final.getY());

        //pintar linies interiors
//        g2d.setColor(Color.yellow);
//        g2d.drawLine((int) p1finali.getX(), (int) p1finali.getY(), (int) p2finali.getX(), (int) p2finali.getY());
//        g2d.drawLine((int) p2finali.getX(), (int) p2finali.getY(), (int) p3finali.getX(), (int) p3finali.getY());
//        g2d.drawLine((int) p3finali.getX(), (int) p3finali.getY(), (int) p4finali.getX(), (int) p4finali.getY());
//        g2d.drawLine((int) p4finali.getX(), (int) p4finali.getY(), (int) p1finali.getX(), (int) p1finali.getY());

        //pintar punts exteriors
//        g2d.setColor(Color.red);
//        g2d.drawLine((int) p1final.getX(), (int) p1final.getY(), (int) p1final.getX(), (int) p1final.getY());
//        g2d.drawLine((int) p2final.getX(), (int) p2final.getY(), (int) p2final.getX(), (int) p2final.getY());
//        g2d.drawLine((int) p3final.getX(), (int) p3final.getY(), (int) p3final.getX(), (int) p3final.getY());
//        g2d.drawLine((int) p4final.getX(), (int) p4final.getY(), (int) p4final.getX(), (int) p4final.getY());

    }

    /**
     * Take the following line of where go the robot /
     * Agafa la seguent linia d'on va el robot
     * @param l
     * @return Line2D.Double
     */
    private Line2D.Double nextLine(Line2D.Double l) {

        double xt1 = l.x1 + 1 * Math.sin(Math.toRadians(this.getAngle()));
        double yt1 = l.y1 + 1 * Math.cos(Math.toRadians(this.getAngle()));

        double xt2 = l.x2 + 1 * Math.sin(Math.toRadians(this.getAngle()));
        double yt2 = l.y2 + 1 * Math.cos(Math.toRadians(this.getAngle()));

        Line2D.Double ln = new Line2D.Double(xt1, yt1, xt2, yt2);

        return ln;
    }

    /**
     * Look if you touch another robot while spinning /
     * Mira si toca un robot mentre gira
     * @return boolean
     */ 
    private boolean touchRobotRotate() {
        boolean toca = false;

        if (Board.getTank1() == this) {

            ArrayList<Line2D.Double> linies = this.getBoundLinesToRotate();
            ArrayList<Line2D.Double> liniest2 = Board.getTank2().getBoundLines();

            for (int e = 0; e < 4; e++) {
                Line2D.Double nxtline = nextLine(linies.get(e));
                for (int i = 0; i < 3; i++) {
                    if (nxtline.intersectsLine(liniest2.get(i))) {
                        toca = true;
                    }
                }
            }

        } else {
            ArrayList<Line2D.Double> linies = this.getBoundLinesToRotate();
            ArrayList<Line2D.Double> liniest2 = Board.getTank1().getBoundLines();

            for (int e = 0; e < 4; e++) {
                Line2D.Double nxtline = nextLine(linies.get(e));
                for (int i = 0; i < 3; i++) {

                    if (linies.get(e).intersectsLine(liniest2.get(i))) {
                        toca = true;
                    }
                }
            }
        }
        return toca;
    }

    /**
     * Look if you touch another robot while moving /
     * Mira si toca un robot mentre es mou
     * @param pos
     * @return boolean
     */
    private boolean touchRobotMov(int pos) {
        boolean toca = false;
        
        if (Board.getTank1() == this) {

            ArrayList<Line2D.Double> linies = this.getBoundLines();
            ArrayList<Line2D.Double> liniest2 = Board.getTank2().getBoundLines();

            Line2D.Double nxtline = nextLine(linies.get(pos));
            for (int i = 0; i < 3; i++) {
                if (nxtline.intersectsLine(liniest2.get(i))) {
                    toca = true;
                }
            }

        } else {
            ArrayList<Line2D.Double> linies = this.getBoundLines();
            ArrayList<Line2D.Double> liniest2 = Board.getTank1().getBoundLines();

            Line2D.Double nxtline = nextLine(linies.get(pos));
            for (int i = 0; i < 3; i++) {
                if (nxtline.intersectsLine(liniest2.get(i))) {
                    toca = true;
                }
            }
        }

        return toca;
    }

    /**
     * When touch the wall... /
     * Quan toca la paret...
     */
    public abstract void onTouchWall();

    /**
     * Look if touch the wall /
     * Mira si toca la paret
     * @param xt
     * @param yt
     * @return boolean
     */
    private boolean touchWall(double xt, double yt) {

        if (((xt <= (Board.WIDTH - this.width)) && (xt > this.width) && (yt <= Board.HEIGHT - this.height) && (yt > 0))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The robot going forward /
     * El robot va cap endavant
     * @param d 
     */
    public void ahead(int d) {

        double xi = x;
        double yi = y;

        for (int i = 0; i < d; i++) {

            if ((this.touchWall(this.x, this.y)) || ((this.touchWall((this.x + this.width), this.y)))) {

                double xt = xi + i * Math.sin(Math.toRadians(this.getAngle()));
                double yt = yi - i * Math.cos(Math.toRadians(this.getAngle()));
                this.checkScannedRobot();
                this.place(xt, yt);
                
                
                try {
                    Thread.sleep(4);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                if (this.x > Board.WIDTH - this.width) {
                    this.x = this.x - 2;

                } else if (this.x <= 0) {
                    this.x = this.x + 2;

                }

                if (this.y > Board.HEIGHT - this.height) {
                    this.y = this.y - 2;

                } else if (this.y <= 0) {
                    this.y = this.y + 2;
                }

                this.onTouchWall();
                return;
            }
            if (this.touchRobotMov(0)) {
                this.onTouchRobot();
                return;
            }

            if (this.checkTouchBullet()) {
                this.onHitByBullet();
                return;
            }
        }
    }

    /**
     * The robot backwards /
     * El robot va cap enrere
     * @param d 
     */
    public void back(int d) {

        double xi = x;
        double yi = y;

        for (int i = 0; i < d; i--) {

            if ((this.touchWall(this.x, this.y)) || ((this.touchWall((this.x + this.width), this.y)))) {

                double xt = xi + i * Math.sin(Math.toRadians(this.getAngle()));
                double yt = yi - i * Math.cos(Math.toRadians(this.getAngle()));
                this.checkScannedRobot();
                this.place(xt, yt);

                try {
                    Thread.sleep(4);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                if (this.x > Board.WIDTH - this.width) {
                    this.x = this.x - 2;

                } else if (this.x <= 0) {
                    this.x = this.x + 2;

                }

                if (this.y > Board.HEIGHT - this.height) {
                    this.y = this.y - 2;

                } else if (this.y <= 0) {
                    this.y = this.y + 2;
                }

                this.onTouchWall();
                return;
            }
            if (this.touchRobotMov(3)) {
                this.onTouchRobot();
                return;
            }
            
            if (this.checkTouchBullet()) {
                this.onHitByBullet();
                return;
            }
            
        }
    }

    /**
     * Turns all pieces of the robot /
     * Fa girar totes les peçes del robot
     * @param a 
     */
    private void rotateRobot(float a) {
        this.body.setAngle(this.body.getAngle() + a);
        this.turret.setAngle(this.turret.getAngle() + a);
        this.radar.setAngle(this.radar.getAngle() + a);
        this.angle = this.getAngle() + a;
    }

    /**
     * Turn right the robot /
     * Gira a la dreta tot el robot  
     * @param a 
     */     
    public void right(float a) {

        for (float i = 0; i < a; i++) {

            if (!this.touchRobotRotate()) {
                
                this.rotateRobot(1);
                if (this.checkTouchBullet()) {
                    this.onHitByBullet();
                    return;
                }
                 
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.onTouchRobot();

            }   
        }
    }

    /**
     * Turn left the robot /
     * Gira a l'esquerra tot el robot
     * @param a 
     */
    public void left(float a) {

        for (float i = 0; i < a; i++) {
            if (!this.touchRobotRotate()) {
                
                this.rotateRobot(-1);
                if (this.checkTouchBullet()) {
                    this.onHitByBullet();
                    return;
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.onTouchRobot();
            }
        }
    }

    /**
     * Turn right the turret /
     * Gira a la dreta el cano
     * @param a 
     */
    public void turnTurretRight(float a) {

        for (int i = 0; i < a; i++) {
            this.turret.setAngle(this.turret.getAngle() + 1);
           
            this.turnRadarRight(1);

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Turn left the robot /
     * Gira a la esquerra el cano
     * @param a 
     */
    public void turnTurretLeft(float a) {

        for (int i = 0; i < a; i++) {
            this.turret.setAngle(this.turret.getAngle() - 1);
            this.turnRadarLeft(1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Turn right the radar /
     * Gira a la dreta el radar
     * @param a 
     */
    public void turnRadarRight(float a) {

        for (int i = 0; i < a; i++) {
            
            this.checkScannedRobot();
            
            this.radar.setAngle(this.radar.getAngle()+1);
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Turn left the radar /
     * Gira a la esquerra el radar
     * @param a 
     */
    public void turnRadarLeft(float a) {

        for (int i = 0; i < a; i++) {
            
            this.checkScannedRobot();
            
            this.radar.setAngle(this.radar.getAngle()-1);
            
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Place the robot to coordinates x,y /
     * Posar el robot a x i y  
     * @param x
     * @param y 
     */
    private void place(double x, double y) {
        //Coloco les coordenades del robot general.
        this.x = x;
        this.y = y;

        //Coloquem les peçes
        this.body.place(x, y);
        this.turret.place(x, y);
        this.radar.place(x, y);
    }

    /**
     * Shoot a bullet /
     * Disparar
     */
    public void fire() {
        
        if (this.bulletsLoad>0){
        long reload = System.nanoTime();
        
            if(this.lastReload+415182347<reload){
                AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.turret.getAngle()),
                        x + (this.width / 2) + 2, y + (this.height / 2) + 3);

                Point2D before = new Point2D.Double(x + 15, y + 15);
                Point2D after = new Point2D.Double();
                after = transformer.transform(before, after);
                
                Bullet b = new Bullet(before.getX(), before.getY(), this.turret.getAngle(), this);

                Board.getBullets().add(b);
                this.setLastReload(reload);
                this.setBulletsLoad(this.bulletsLoad-1);

            }
        }

    }

    /**
     * Moving a point /
     * Moure un punt
     * @param x
     * @param y
     * @param angle
     * @param d
     * @return Point2D.double
     */
    public Point2D.Double movePoint(double x, double y, double angle, double d) {

        double fx = (x + (d * (Math.sin(Math.toRadians(angle)))));
        double fy = (y - (d * (Math.cos(Math.toRadians(angle)))));

        return new Point2D.Double(fx, fy);
    }

    /**
     * Gets points of the robot (real) /
     * Obte els punts del robot (real)
     * @return ArrayList<Point2D.Double>
     */
    public ArrayList<Point2D.Double> getBoundPoints() {

        ArrayList<Point2D.Double> punts = new ArrayList<Point2D.Double>();

        AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.angle), x + this.width / 2, y + this.height / 2);

        Point2D p1 = new Point2D.Double(x, y);
        Point2D p1final = new Point2D.Double();
        p1final = transformer.transform(p1, p1final);

        Point2D p2 = new Point2D.Double(x + this.width, y);
        Point2D p2final = new Point2D.Double();
        p2final = transformer.transform(p2, p2final);

        Point2D p3 = new Point2D.Double(x + this.width, y + this.height);
        Point2D p3final = new Point2D.Double();
        p3final = transformer.transform(p3, p3final);

        Point2D p4 = new Point2D.Double(x, y + this.height);
        Point2D p4final = new Point2D.Double();
        p4final = transformer.transform(p4, p4final);

        punts.add((Point2D.Double) p1final);
        punts.add((Point2D.Double) p2final);
        punts.add((Point2D.Double) p3final);
        punts.add((Point2D.Double) p4final);

        return punts;
    }

    /**
     * Gets the limits of the robot (real) /
     * Obte les lines del robot (real)
     * @return ArrayList<Line2D.Double>
     */
    public ArrayList<Line2D.Double> getBoundLines() {

        ArrayList<Point2D.Double> punts = this.getBoundPoints();
        ArrayList<Line2D.Double> linies = new ArrayList<Line2D.Double>();

        Line2D.Double l1 = new Line2D.Double(punts.get(0), punts.get(1));
        Line2D.Double l2 = new Line2D.Double(punts.get(1), punts.get(2));
        Line2D.Double l3 = new Line2D.Double(punts.get(2), punts.get(3));
        Line2D.Double l4 = new Line2D.Double(punts.get(3), punts.get(1));

        linies.add(l1);
        linies.add(l2);
        linies.add(l3);
        linies.add(l4);

        return (linies);
    }

    /**
     * Gets points of the robot (to rotate) /
     * Obte els punts del robot (per rotar)
     * @return ArrayList<Point2D.Double>
     */
    public ArrayList<Point2D.Double> getBoundPointsToRotate() {

        ArrayList<Point2D.Double> punts = new ArrayList<Point2D.Double>();

        AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.angle), x + this.width / 2, y + this.height / 2);

        Point2D p1 = new Point2D.Double(x + 10, y + 10);
        Point2D p1final = new Point2D.Double();
        p1final = transformer.transform(p1, p1final);

        Point2D p2 = new Point2D.Double(x + this.width - 10, y + 10);
        Point2D p2final = new Point2D.Double();
        p2final = transformer.transform(p2, p2final);

        Point2D p3 = new Point2D.Double(x + this.width - 10, y + this.height - 10);
        Point2D p3final = new Point2D.Double();
        p3final = transformer.transform(p3, p3final);

        Point2D p4 = new Point2D.Double(x + 10, y + this.height - 10);
        Point2D p4final = new Point2D.Double();
        p4final = transformer.transform(p4, p4final);

        punts.add((Point2D.Double) p1final);
        punts.add((Point2D.Double) p2final);
        punts.add((Point2D.Double) p3final);
        punts.add((Point2D.Double) p4final);

        return punts;
    }

    /**
     * Gets the limits of the robot (to rotate) /
     * Obte les linies del robot (per rotar)
     * @return ArrayList<Point2D.Double>
     */
    public ArrayList<Line2D.Double> getBoundLinesToRotate() {

        ArrayList<Point2D.Double> punts = this.getBoundPointsToRotate();
        ArrayList<Line2D.Double> linies = new ArrayList<Line2D.Double>();

        Line2D.Double l1 = new Line2D.Double(punts.get(0), punts.get(1));
        Line2D.Double l2 = new Line2D.Double(punts.get(1), punts.get(2));
        Line2D.Double l3 = new Line2D.Double(punts.get(2), punts.get(3));
        Line2D.Double l4 = new Line2D.Double(punts.get(3), punts.get(1));
        

        linies.add(l1);
        linies.add(l2);
        linies.add(l3);
        linies.add(l4);

        return (linies);
    }

    /**
     * Look if touch a bullet /
     * Mirar si toca una bala
     * @return boolean
     */
    public boolean checkTouchBullet() {

        boolean tocat = false;

        ArrayList<Line2D.Double> linies = this.getBoundLines();

        if (!Board.getBullets().isEmpty()) {
            for (int i = 0; i < linies.size(); i++) {
                for (int t = 0; t < Board.getBullets().size(); t++) {
                    if (Board.getBullets().get(t).getOwner() != this) {
                        if (linies.get(i).getBounds().contains(Board.getBullets().get(t).getX(), Board.getBullets().get(t).getY())) {
                            if(Board.getBullets().get(t).isVisible() != false){
                                tocat = true;
                                this.setLives(this.getLives()-1);
                            }
                            Board.getBullets().get(t).setVisible(false);
                        }
                    }
                }
            }
        }
        
        return tocat;  
    }
    
    /**
     * Check if the robot scanned other robot /
     * Comprova si el robot ha escanejat un altre robot
     * @return boolean
     */
    public boolean checkScannedRobot(){
        
        boolean scanned = false;

        
        if(Board.getTank1()==this){
           
            Point2D pfradar = this.movePoint(this.radar.x+18 , this.radar.y+20, this.radar.angle, 800);
            
            Line2D.Double ln = new Line2D.Double((int)this.radar.x+18, (int)this.radar.y+20, (int)pfradar.getX(), (int)pfradar.getY());
            
            ArrayList<Line2D.Double> liniest2 = Board.getTank2().getBoundLines();
            
            for(int e = 0; e<3; e++ ){
                 if(ln.intersectsLine(liniest2.get(e))) {
                      scanned = true;
                      this.onScannedRobot();
                  }
             }
           
        } else {
            Point2D pfradar = this.movePoint(this.radar.x+18 , this.radar.y+20, this.radar.angle, 800);
            
            Line2D.Double ln = new Line2D.Double((int)this.radar.x+18, (int)this.radar.y+20, (int)pfradar.getX(), (int)pfradar.getY());
            
            ArrayList<Line2D.Double> liniest2 = Board.getTank1().getBoundLines();
            
            for(int e = 0; e<3; e++ ){
                 if(ln.intersectsLine(liniest2.get(e))) {
                      scanned = true;
                      this.onScannedRobot();
                  }
             }
        }
        return scanned;
    }
    
    /**
     * When the reobot scans and other robot... /
     * Quan el robot escaneja un altre robot..
     */
    public abstract void onScannedRobot();
    
    /**
     * When the robot touches a bullet /
     * Quan el robot toqui una bala...
     */
    public abstract void onHitByBullet();

    /**
     * When you touch another robot /
     * Quan tocas un altre robot...
     */
    public abstract void onTouchRobot();
    
    /**
     * Running robot /
     * Execució del robot
     */
    public abstract void run();

}
