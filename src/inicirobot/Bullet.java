/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;
import java.awt.*;
import javax.swing.JComponent;
//import robotlibrary3.*;
import libraries.*;

/**
 *
 * @author atorrillas
 */
public class Bullet extends GraphicObject implements SimulatorBullet{
    
    private double speed;
    private double power;
    private Robot owner;

    public Bullet(double x, double y, double angle, Robot owner) {
        
        super(x, y, angle);
        
        this.speed = 3;
        this.power = 5;
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
        
        if(Board.getTank1() == this.owner){
            g2d.setColor(Color.red);
        } else {
            g2d.setColor(Color.orange);
        }
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   
        g2d.fillOval((int)x, (int)y, (int)power, (int)power);
   
    }

    //touchwall
    @Override
    public boolean inBoard() {
    
        if(((x <= Board.WIDTH)&&(x > Board.WIDTH)&&(y <= Board.HEIGHT+1)&&(y > 0))){
           return false;
       } else {
           return true;
       } 
    }

    @Override
    public void move() {
        x = (x + (speed * (Math.sin(Math.toRadians(this.getAngle())))));
        y = (y - (speed * (Math.cos(Math.toRadians(this.getAngle())))));
       
    } 
    
    @Override
    public SimulatorRobot getOwner() {
        return this.owner;
    }
}
