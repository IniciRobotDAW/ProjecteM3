/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.Graphics;
import javax.swing.JComponent;


/**
 *
 * @author atorrillas
 */
public abstract class GraphicObject {
 
    protected double x;
    protected double y;
    protected double angle;
    protected boolean visible; 
    
    //Constructor
    public GraphicObject(double x, double y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.visible = true;
    }
    
    public GraphicObject(double x, double y, double angle, boolean visible) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.visible = true;
    }

    //Getters i setters
     public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAngle(double angle) {
        if(this.angle>=360) this.angle=angle-360;
        else if (this.angle <= -360) this.angle=angle+360;
        else this.angle = angle;
        //this.angle = angle;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

   
    public abstract void paintObj(Graphics g, JComponent j);
    
}
