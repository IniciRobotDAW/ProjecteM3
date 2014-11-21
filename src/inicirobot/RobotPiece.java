/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
//import robotlibrary3.*;
import libraries.*;

/**
 *
 * @author atorrillas
 */
public class RobotPiece extends GraphicObject{

    private Image image;
    
    //desplaçament x i y respecte el body
    private double dx;
    private double dy;
    
    //mida d la imatge
    private int width;
    private int height; 
        
    //Constructor
    public RobotPiece(double x, double y, double angle, Image image, double dx, double dy, int width, int height) {
        super(x, y, angle);
        this.image = image;
        this.dx = dx;
        this.dy = dy;
        this.width = width;
        this.height = height;
    }
      
    public RobotPiece(String path, double x, double y, double dx, double dy){
        super(x, y, 0.0f);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(path));
        this.image = ii.getImage();
        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
        this.dx =dx;
        this.dy=dy; 
    }
      public Image getImage() {
        return image;
         
    }

    public double getDx() {   
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public int getWidth() {
        return width;
    }

    //Getters i Setters
    public int getHeight() {
        return height;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    //Metodes
    @Override
    public void paintObj(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
       
        //Cos
        AffineTransform at = new AffineTransform();
        
        at.translate(x+dx, y+dy);
        at.rotate(Math.toRadians(this.angle), (this.width /2 ), (this.height /2));
        
        g2d.drawImage(this.getImage(), at, c);
        
        
        
    }
      
    public void place (double x, double y){
        this.x = x;
        this.y = y;            
    }  
}
