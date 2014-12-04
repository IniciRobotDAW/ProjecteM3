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
 * @author rbarberan
 */
public class HealthPill extends GraphicObject{
    
    private Image image;
    private int width;
    private int height;
    private int value;
    
    public HealthPill() {
        super((Math.random()*Board.getWIDTH()+1), (Math.random()*Board.getHEIGHT()+1), 0.0f);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/resources/images/HealthPill.png"));
        this.image = ii.getImage();
        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
        this.value = 2;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public void paintObj(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at = new AffineTransform();
        
        at.translate(x, y);
        at.rotate(Math.toRadians(this.angle), (this.width /2 ), (this.height /2));
        
        
        g2d.drawImage(this.getImage(), at, c);
  
    }
    
}