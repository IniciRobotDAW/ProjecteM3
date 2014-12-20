/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import libraries.*;

/**
 *
 * @author atorrillas
 */
public class Bullet extends GraphicObject implements SimulatorBullet{
    
    private double speed;
    private double power;
    private Robot owner;
    
    private BufferedImage explosionAnimImg;

    public Bullet(double x, double y, double angle, Robot owner) {
        
        super(x, y, angle);
        
        this.speed = 3;
        this.power = 6;
        this.owner = owner;   
    }

    //Getters i setters
    public double getSpeed() {
        return speed;
    }

    public double getPower() {
        return power;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPower(double power) {
        this.power = power;
    }
   
    //metrodes
   
    //paintObj
    @Override
    public void paintObj(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i < Board.robots.size(); i++) {
            g2d.setColor(Color.WHITE);
            if(Board.robots.get(0) == this.owner){
                g2d.setColor(Color.red);
            } else if(Board.robots.get(1) == this.owner){
                g2d.setColor(Color.orange);
            }
        }
//        Random rand = new Random();
//        float rc = rand.nextFloat();
//        float gc = rand.nextFloat();
//        float bc = rand.nextFloat();
//        
//        g2d.setColor(new Color(rc, gc, bc));
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   
        g2d.fillOval((int)x, (int)y, (int)power, (int)power);
        
    }

    @Override
    public boolean touchRobot() {
        boolean touch = false;

        for (int i = 0; i < Board.robots.size(); i++) {
            if (Board.robots.get(i) != this.owner) {
                ArrayList<Line2D.Double> linies = Board.robots.get(i).getBoundLines();
                for (int j = 0; j < linies.size(); j++) {
                    if (linies.get(j).getBounds().contains(this.getX(), this.getY())) {
                        
                        touch = true;
                        
                        URL explosionAnimImgUrl = this.getClass().getResource("/resources/images/exploteBullet.png");
                        try {
                            explosionAnimImg = ImageIO.read(explosionAnimImgUrl);
                        } catch (IOException ex) {
                            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Explote expAnim = new Explote(explosionAnimImg, 60, 60, 46, 7, false, (int)this.x-50, (int)this.y - explosionAnimImg.getHeight()/3, 0);
                        Board.getExpAnim().add(expAnim);
                    }
                }
            }
        }
        return touch;
    }
    
    //touchwall
    @Override
    public boolean inBoard() {
    
        if(((x > -10)&&(x <= Board.WIDTH-10)&&(y > -10)&&(y <= Board.HEIGHT-10))){
           return true;
       } else {
           return false;
       } 
    }

    @Override
    public void move() {
        x = (x + (speed * (Math.sin(Math.toRadians(this.getAngle())))));
        y = (y - (speed * (Math.cos(Math.toRadians(this.getAngle())))));
        this.touchRobot();
    } 
    
    @Override
    public SimulatorRobot getOwner() {
        return this.owner;
    }
}
