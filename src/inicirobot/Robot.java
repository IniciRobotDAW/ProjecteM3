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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import libraries.*;

/**
 *
 * @author atorrillas, rbarberan
 */
public abstract class Robot extends GraphicObject implements SimulatorRobot {

    private int speed;
    private RobotPiece body;
    private RobotPiece turret;
    private RobotPiece radar;
    private int width;
    private int height;
    private long lastReload = System.currentTimeMillis();
    private int reloadTime = 500;
    private int startLives = 5;
    private int lives = this.startLives;
    private int startBulletsLoad = 50; 
    private int bulletsLoad =  this.startBulletsLoad;
    private int velMov = 5;
    private int velComp = 0;
    private BufferedImage explosionAnimImg;
   

    /**
     * Constructor
     * @param x
     * @param y
     * @param angle
     * @param speed
     * @param lives
     * @param body
     * @param turret
     * @param radar
     * @param width
     * @param height
     * @param lastReload 
     */
    public Robot(double x, double y, float angle, int speed, int lives, RobotPiece body, RobotPiece turret, RobotPiece radar, int width, int height, double lastReload) {
        super(x, y, angle);

        this.speed = speed;
        this.lives = lives;
        this.body = body;
        this.turret = turret;
        this.radar = radar;
        this.width = width;
        this.height = height;
        this.startLives = 5;
        this.lives = this.startLives;
        
    }

    public Robot(double x, double y, RobotPiece cos, RobotPiece turret, RobotPiece radar) {
        super(x, y, 0.0f);
        
        this.body = cos;
        this.turret = turret;
        this.radar = radar;
        this.width = this.body.getWidth();
        this.height = this.body.getHeight();

    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public RobotPiece getBody() {
        return body;
    }

    @Override
    public RobotPiece getTurret() {
        return turret;
    }

    @Override
    public RobotPiece getRadar() {
        return radar;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public long getLastReload() {
        return lastReload;
    }

    @Override
    public int getBulletsLoad() {
        return bulletsLoad;
    }

    @Override
    public int getStartLives() {
        return startLives;
    }

    @Override
    public int getStartBulletsLoad() {
        return startBulletsLoad;
    }

    @Override
    public int getReloadTime() {
        return reloadTime;
    }

    public int getVelMov() {
        return velMov;
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

    public void setLastReload(long lastReload) {
        this.lastReload = lastReload;
    }

    public void setBulletsLoad(int bulletsLoad) {
        this.bulletsLoad = bulletsLoad;
    }

    public void setStartLives(int startLives) {
        this.startLives = startLives;
    }

    public void setStartBulletsLoad(int startBulletsLoad) {
        this.startBulletsLoad = startBulletsLoad;
    }

    public void setReloadTime(int reloadTime) {
        this.reloadTime = reloadTime;
    }

    public void setVelMov(int velMov) {
        this.velMov = velMov;
    }

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
        
        for (SimulatorRobot robot : Board.robots) {
            if (robot != this) {
                ArrayList<Line2D.Double> linies = this.getBoundLinesToRotate();
                ArrayList<Line2D.Double> liniest2 = robot.getBoundLines();
                for (int e = 0; e < 4; e++) {
                    Line2D.Double nxtline = nextLine(linies.get(e));
                    for (int j = 0; j < 4; j++) {
                        if (nxtline.intersectsLine(liniest2.get(j))) {
                            toca = true;
                        }
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
        
        for (SimulatorRobot robot : Board.robots) {
            if (robot != this) {
                ArrayList<Line2D.Double> linies = this.getBoundLines();
                ArrayList<Line2D.Double> liniest2 = robot.getBoundLines();
                Line2D.Double nxtline = nextLine(linies.get(pos));                
                for (int j = 0; j < 4; j++) {
                    if (nxtline.intersectsLine(liniest2.get(j))) {                        
                        toca = true;
                    }
                }
            }
        }
        return toca;
    }
    
    /**
     * Look if touch the wall /
     * Mira si toca la paret
     * @param xt
     * @param yt
     * @return boolean
     */
    private boolean touchWall(double xt, double yt) {

        return (xt <= (Board.WIDTH - this.width)) && (xt > this.width) && (yt <= Board.HEIGHT - this.height) && (yt > 0);
    }
    
    /**
     * Chenge de pos of robot /
     * Cambia 2px la pos del robot
     */
    private void reposRobot(){
        if(this.x<this.x+2){
            double xt = this.x + 2 * Math.sin(Math.toRadians(this.getAngle()));
            double yt = this.y + 2 * Math.cos(Math.toRadians(this.getAngle()));
            this.place(xt, yt);

        } else {
            double xt = this.x - 2 * Math.sin(Math.toRadians(this.getAngle()));
            double yt = this.y - 2 * Math.cos(Math.toRadians(this.getAngle()));
            this.place(xt, yt);
        }

        if(this.y<this.y+2){
            double xt = this.x - 2 * Math.sin(Math.toRadians(this.getAngle()));
            double yt = this.y - 2 * Math.cos(Math.toRadians(this.getAngle()));
            this.place(xt, yt);

        } else {
            double xt = this.x + 2 * Math.sin(Math.toRadians(this.getAngle()));
            double yt = this.y + 2 * Math.cos(Math.toRadians(this.getAngle()));
            this.place(xt, yt);
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
                    Thread.sleep(this.velMov);
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
            
            if(this.checkTouchObject(0)){
                this.reposRobot();
                this.onTouchWall();
                return;
            }
            
            if (this.touchRobotMov(0)) {
                
               this.reposRobot();
               this.onTouchRobot();
               return;
            }

            if (this.checkTouchBullet()) {
                
                this.onHitByBullet();
                return;
            }
            
            if (this.checkWin()) {
                this.win();
                return;
            }
            
            this.checkTouchPill();
            
            
        }
    }
    
    /**
     * The robot going forward /
     * El robot va cap endavant
     * @param d 
     */
    private void aheadComp(int d, int vel) {

        double xi = x;
        double yi = y;

        for (int i = 0; i < d; i++) {

            if ((this.touchWall(this.x, this.y)) || ((this.touchWall((this.x + this.width), this.y)))) {

                double xt = xi + i * Math.sin(Math.toRadians(this.getAngle()));
                double yt = yi - i * Math.cos(Math.toRadians(this.getAngle()));
                this.checkScannedRobot();
                this.place(xt, yt);
                
                
                try {
                    Thread.sleep(vel);
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
            
            if(this.checkTouchObject(0)){
                this.reposRobot();
                this.onTouchWall();
                return;
            }
            
            if (this.touchRobotMov(0)) {
                
               this.reposRobot();
               this.onTouchRobot();
               return;
            }

            if (this.checkTouchBullet()) {
                
                this.onHitByBullet();
                return;
            }
            
            if (this.checkWin()) {
                this.win();
                return;
            }
            
            this.checkTouchPill();
            
            
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

         for (int i = d; i > 0; i--) {

            if ((this.touchWall(this.x, this.y)) || ((this.touchWall((this.x + this.width), this.y)))) {

                double xt = xi + (i-d) * Math.sin(Math.toRadians(this.getAngle()));
                double yt = yi - (i-d) * Math.cos(Math.toRadians(this.getAngle()));
               
                this.place(xt, yt);
                
                this.checkScannedRobot();
                
                try {
                    Thread.sleep(this.velMov);
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

            if (this.touchRobotMov(2)) {
                this.reposRobot();
                this.onTouchRobot();
                return;
               
            }

            if (this.checkTouchBullet()) {
                this.onHitByBullet();
                return;
            }
            
            if (this.checkWin()) {
                this.win();
                return;
            }
            
            this.checkTouchPill();
            
            if(this.checkTouchObject(2)){
                this.reposRobot();
                this.onTouchWall();
                return;
            }
     
        }
    }
    
    /**
     * The robot backwards /
     * El robot va cap enrere
     * @param d 
     */
    private void backComp(int d, int vel) {

        double xi = x;
        double yi = y;

        for (int i = d; i > 0; i--) {

            if ((this.touchWall(this.x, this.y)) || ((this.touchWall((this.x + this.width), this.y)))) {

                double xt = xi - i * Math.sin(Math.toRadians(this.getAngle()));
                double yt = yi + i * Math.cos(Math.toRadians(this.getAngle()));
                this.checkScannedRobot();
                this.place(xt, yt);
                
                try {
                    Thread.sleep(vel);
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

            if (this.touchRobotMov(2)) {
                this.reposRobot();
                this.onTouchRobot();
                return;
               
            }

            if (this.checkTouchBullet()) {
                this.onHitByBullet();
                return;
            }
            
            if(this.checkTouchObject(2)){
                this.reposRobot();
                this.onTouchWall();
                return;
            }
            
            if (this.checkWin()) {
                this.win();
                return;
            }
            
            this.checkTouchPill();
            
     
        }
    }

    /**
     * Turns all pieces of the robot /
     * Fa girar totes les peÃ§es del robot
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
                    Thread.sleep(this.velMov);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.onTouchRobot();

            }   
        }
    }
    
    /**
     * Turn right the robot /
     * Gira a la dreta tot el robot  
     * @param a 
     */     
    private void rightComp(float a, int vel) {

        for (float i = 0; i < a; i++) {

            if (!this.touchRobotRotate()) {
                
                this.rotateRobot(1);
                if (this.checkTouchBullet()) {
                    this.onHitByBullet();
                    return;
                }
                 
                try {
                    Thread.sleep(vel);
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
                    Thread.sleep(this.velMov);
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
    private void leftComp(float a, int vel) {

        for (float i = 0; i < a; i++) {
            if (!this.touchRobotRotate()) {
                
                this.rotateRobot(-1);
                if (this.checkTouchBullet()) {
                    this.onHitByBullet();
                    return;
                }

                try {
                    Thread.sleep(vel);
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
                Thread.sleep(this.velMov);
            } catch (InterruptedException ex) {
                Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Turn right the turret /
     * Gira a la dreta el cano
     * @param a 
     */
    private void turnTurretRightComp(float a, int vel) {

        for (int i = 0; i < a; i++) {
            this.turret.setAngle(this.turret.getAngle() + 1);
           
            this.turnRadarRight(1);

            try {
                Thread.sleep(vel);
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
                Thread.sleep(this.velMov);
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
    private void turnTurretLeftComp(float a, int vel) {

        for (int i = 0; i < a; i++) {
            this.turret.setAngle(this.turret.getAngle() - 1);
            this.turnRadarLeft(1);
            try {
                Thread.sleep(vel);
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
                Thread.sleep(this.velMov);
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
    private void turnRadarRightComp(float a, int vel) {

        for (int i = 0; i < a; i++) {
            
            this.checkScannedRobot();
            
            this.radar.setAngle(this.radar.getAngle()+1);
            try {
                Thread.sleep(vel);
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
                Thread.sleep(this.velMov);
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
    private void turnRadarLeftComp(float a, int vel) {

        for (int i = 0; i < a; i++) {
            
            this.checkScannedRobot();
            
            this.radar.setAngle(this.radar.getAngle()-1);
            
            try {
                Thread.sleep(vel);
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

        //Coloquem les peÃ§es
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
        
        long reload = System.currentTimeMillis();
   
            if(this.lastReload+this.reloadTime<reload){
                AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.turret.getAngle()),
                        x + (this.width / 2) + 2, y + (this.height / 2) + 3);

                Point2D before = new Point2D.Double(x + 15, y + 15);
                Point2D after = new Point2D.Double();
                transformer.transform(before, after);
                
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
    private Point2D.Double movePoint(double x, double y, double angle, double d) {

        double fx = (x + (d * (Math.sin(Math.toRadians(angle)))));
        double fy = (y - (d * (Math.cos(Math.toRadians(angle)))));

        return new Point2D.Double(fx, fy);
    }

    /**
     * Gets points of the robot (real) /
     * Obte els punts del robot (real)
     * @return ArrayList<Point2D.Double>
     */
    @Override
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
    @Override
    public ArrayList<Line2D.Double> getBoundLines() {

        ArrayList<Point2D.Double> punts = this.getBoundPoints();
        ArrayList<Line2D.Double> linies = new ArrayList<>();

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

        ArrayList<Point2D.Double> punts = new ArrayList<>();

        AffineTransform transformer = AffineTransform.getRotateInstance(Math.toRadians(this.angle), x + this.width / 2, y + this.height / 2);

        Point2D p1 = new Point2D.Double(x + 15, y + 15);
        Point2D p1final = new Point2D.Double();
        p1final = transformer.transform(p1, p1final);

        Point2D p2 = new Point2D.Double(x + this.width - 15, y + 15);
        Point2D p2final = new Point2D.Double();
        p2final = transformer.transform(p2, p2final);

        Point2D p3 = new Point2D.Double(x + this.width - 15, y + this.height - 15);
        Point2D p3final = new Point2D.Double();
        p3final = transformer.transform(p3, p3final);

        Point2D p4 = new Point2D.Double(x + 15, y + this.height - 15);
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
        ArrayList<Line2D.Double> linies = new ArrayList<>();

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
     * check if you win /
     * Verificar si has guanyat
     */
    private boolean checkWin(){
        
        boolean win = false;
        int deads = 0;
        
        for (SimulatorRobot robot : Board.robots) {
            if (robot.getLives() <= 0) {
                deads++;
                if(deads == Board.robots.size() -1 ){
                    win = true;
                }
            }
        }
        
        return win;
        
    }
    
    /**
     * Dicta el que pasa al morir
     */
    private void die(){

        this.setVisible(false);
        
        ImageIcon db = new ImageIcon(this.getClass().getResource("/resources/images/deathBody.png"));
        this.body.setImage(db.getImage());
        
        ImageIcon dt = new ImageIcon(this.getClass().getResource("/resources/images/deathTurret.png"));
        this.turret.setImage(dt.getImage());
        
        ImageIcon dr = new ImageIcon(this.getClass().getResource("/resources/images/deathRadar.png"));
        this.radar.setImage(dr.getImage());
        
        try{
            Thread.sleep(999999);
        }catch(InterruptedException ex){
            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
    /**
     * Look if touch a bullet /
     * Mirar si toca una bala
     * @return boolean
     */
    private boolean checkTouchBullet() {

        boolean tocat = false;
        this.setVisible(true);

        ArrayList<Line2D.Double> linies = this.getBoundLines();

        if (!Board.getBullets().isEmpty()) {
            for (int i = 0; i < linies.size(); i++) {
                for (int t = 0; t < Board.getBullets().size(); t++) {
                    if (Board.getBullets().get(t).getOwner() != this) {
                        if (linies.get(i).getBounds().contains(Board.getBullets().get(t).getX(), Board.getBullets().get(t).getY())) {
                            if(Board.getBullets().get(t).isVisible() != false){
                               
                                this.setLives(this.getLives()-1);
                                    
                                if(this.lives <= 0){
                                    URL explosionAnimImgUrl = this.getClass().getResource("/resources/images/exploteDeath.png");
                                    try {
                                        explosionAnimImg = ImageIO.read(explosionAnimImgUrl);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    Explote expAnim = new Explote(explosionAnimImg, 130, 130, 64, 20, false, (int)this.x-50, (int)this.y - explosionAnimImg.getHeight()/3, 0);
                                    Board.getExpAnim().add(expAnim);
                                    
                                    this.die();
                                }
                               
                            }
                            Board.getBullets().get(t).setVisible(false);
                        }
                    }
                }
            }
        }
        return tocat;  
    }
    
    private void checkTouchPill(){
        
        ArrayList<Line2D.Double> linies = this.getBoundLines();
        if(this.getLives() < this.getStartLives()){
            for (int i = 0; i < linies.size(); i++) {
                for (int j = 0; j < Board.getPills().size(); j++) {
                    if(linies.get(i).getBounds().contains(Board.getPills().get(j).getX(), Board.getPills().get(j).getY())){    
                        this.setLives(this.getStartLives());
                        Board.getPills().get(j).setVisible(false);
                    }
                }
            }
        }
    }
    
    private boolean checkTouchObject(int pos){
        
       ArrayList<Line2D.Double> linies = this.getBoundLines();
       boolean toca = false;
        for (int i = 0; i < linies.size(); i++) {
            for (int j = 0; j < Board.getObstacles().size(); j++) {
                Rectangle r = new Rectangle((int)Board.getObstacles().get(j).getX(),(int)Board.getObstacles().get(j).getY(),Board.getObstacles().get(j).getWidth(),Board.getObstacles().get(j).getHeight());
   
                if(linies.get(pos).getBounds().intersects(r)){
                  
                    toca = true;
                }
            }
        }
        return toca;
   
    }
    
    /**
     * Check if the robot scanned other robot /
     * Comprova si el robot ha escanejat un altre robot
     * @return boolean
     */
    private boolean checkScannedRobot(){
        
        boolean scanned = false;

        for (int i = 0; i < Board.robots.size(); i++) {
        
            if(Board.robots.get(i) != this){

                Point2D pfradar = this.movePoint(this.radar.x+18 , this.radar.y+20, this.radar.angle, 800);

                Line2D.Double ln = new Line2D.Double((int)this.radar.x+18, (int)this.radar.y+20, (int)pfradar.getX(), (int)pfradar.getY());

                ArrayList<Line2D.Double> liniest2 = Board.robots.get(i).getBoundLines();
                
                if(Board.robots.get(i).isVisible()){
                    for(int e = 0; e<4; e++ ){
                        if(ln.intersectsLine(liniest2.get(e))) {
                            scanned = true;
                            this.onScannedRobot();
                        }
                    }
                }
            }
        }
        return scanned;
    }

    public void movComp(String[] strs, int d){
        
        for (int i = 0; i < d; i++) {
            for (String s:strs) {
                switch(s){
                    
                    case "this.ahead":
                    case "ahead": 
                        this.aheadComp(2,this.velComp);
                    break;
                        
                    case "this.back":
                    case "back":
                        this.backComp(1, this.velComp);
                    break;
                    
                    case "this.left":
                    case "left": 
                        this.leftComp(1, this.velComp);
                    break;
                        
                    case "this.right": 
                    case "right": 
                        this.rightComp(1, this.velComp);
                    break;
                    
                    case "this.turnTurretRight":
                    case "turnTurretRight":
                        this.turnTurretRightComp(1, this.velComp);
                    break;
                        
                    case "this.turnTurretLeft":
                    case "turnTurretLeft":
                        this.turnTurretLeftComp(1, this.velComp);
                    break;
                        
                    case "this.turnRadarRight":
                    case "turnRadarRight":
                        this.turnRadarRightComp(1, this.velComp);
                    break;
                        
                    case "this.turnRadarLeft":
                    case "turnRadarLeft":
                        this.turnRadarLeftComp(1, this.velComp);
                    break;
                    
                }
            }
        }
        
    }
    
    /**
     * When you win... /
     * Quan guanyes...
     */
    public abstract void win();
    
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
     * When touch the wall... /
     * Quan toca la paret...
     */
    public abstract void onTouchWall();
    
    /**
     * Running robot /
     * Execució del robot
     */
    @Override
    public abstract void run();

}
