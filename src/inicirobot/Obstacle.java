/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import libraries.Board;

/**
 *
 * @author atorrillas
 */
public class Obstacle extends GraphicObject{
    
    private Image image;
    private int width;
    private int height;
    private int value;
    private double degrees;
    
    public Obstacle(){
        super((Math.random()*Board.getWIDTH()-Board.robots.get(0).getWidth()), (Math.random()*Board.getHEIGHT()-Board.robots.get(0).getHeight()), 0.0f);
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertObject.png"));
       
        this.image = ii.getImage();
        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
        this.value = 2;
//        this.degrees = Math.random()*360 + 1;  
        this.degrees = 0;
    }
    
    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getValue() {
        return value;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
    
    
    
    @Override
    public void paintObj(Graphics g, JComponent j) {
        Graphics2D g2d = (Graphics2D) g;
 
        g2d.drawImage(this.getImage(),(int)this.x, (int)this.y, null);
    }
    
}
