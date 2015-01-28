/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
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
    private double angle;
    private ImageIcon ii;
    
    private ArrayList<Integer> inici = caclPosIni();
    
    public HealthPill() {
//        super((Math.random()*Board.getWIDTH()+1), (Math.random()*Board.getHEIGHT()+1), 0.0f);
        super(0,0,0.0f);
        
        this.x = (double) inici.get(0);
        this.y = (double) inici.get(1);
        
        switch(Board.getTheme()){
            
            case "Desert": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertPill.png"));
                break;
                
            case "Forest": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertPill.png"));
                break;
            
            case "Spacial": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertPill.png"));
                break;
            
            case "Sea": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertPill.png"));
                break;
                        
            default: ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desertPill.png"));
                break;                  
            
        }
        
        this.image = ii.getImage();
        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();
        this.value = 2;
//        this.angle = Math.random()*360 + 1;  
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
   
        private ArrayList caclPosIni(){
        
        ArrayList<Integer> pos = new ArrayList();
//        int canto = 0;
        int t;
        
        int canto = (int) (Math.random()*4);
              
        switch (canto){
            
            case 0:
                t = (int) (Math.random()*Board.getWIDTH());   
                pos.add(t);
                pos.add(-20);
                this.angle = (Math.random()*(90-0)-45);
                pos.add(180-(int)this.angle);
                pos.add(canto);
                
                break;
                
            case 1:
                //180
                t = (int) (Math.random()*Board.getHEIGHT());   
                pos.add(Board.getWIDTH()+20);
                pos.add(t);
                this.angle = (Math.random()*(90-0)-45);
                pos.add(270-(int)this.angle);
                pos.add(canto);
                
                break;
                
            case 2:
                t = (int) (Math.random()*Board.getWIDTH());   
                pos.add(t);
                pos.add(Board.getHEIGHT()+20);
                this.angle = (Math.random()*(90-0)-45);
                pos.add(360-(int)this.angle);
                pos.add(canto);
                break;
                
            case 3:
                
                t = (int) (Math.random()*Board.getHEIGHT());   
                pos.add(-20);
                pos.add(t);
                this.angle = (Math.random()*(90-0)-45);
                pos.add(90-(int)this.angle);
                pos.add(canto);
                
                break;
        }
       return pos; 
    }
    
    public void move(){
        
        if((this.x<-40)||(this.x>Board.getWIDTH()+40)||(this.y<-40)||(this.y>Board.getHEIGHT()+40)){
            this.setVisible(false);
        }
        
        switch(inici.get(3)){
            
            case 0:
                this.setX(this.x + 1 * Math.sin(Math.toRadians(this.inici.get(2))));
                this.setY(this.y - 1 * Math.cos(Math.toRadians(this.inici.get(2))));
                break;
  
            case 1:
                this.setX(this.x - 1 * Math.sin(Math.toRadians(this.inici.get(2)))*-1);
                this.setY(this.y - 1 * Math.cos(Math.toRadians(this.inici.get(2))));
                break;
                
            case 2:
                this.setX(this.x + 1 * Math.sin(Math.toRadians(this.inici.get(2))));
                this.setY(this.y - 1 * Math.cos(Math.toRadians(this.inici.get(2)*-1)));
                break;
                  
            case 3:
                this.setX(this.x - 1 * Math.sin(Math.toRadians(this.inici.get(2)))*-1);
                this.setY(this.y - 1 * Math.cos(Math.toRadians(this.inici.get(2))));
                break;
        }      
    }
    
    @Override
    public void paintObj(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        
        AffineTransform at = new AffineTransform();
        
        at.translate(x-15, y-15);
        
       
        at.rotate(Math.toRadians(this.inici.get(2)),26,26);
      
        Point2D p =  new Point2D.Double(at.getTranslateX(),at.getTranslateY());
        g2d.setStroke(new BasicStroke(5f));
        g2d.setColor(Color.green);
      
        g2d.drawImage(this.getImage(), at, c);
        switch(inici.get(3)){
            
            case 0:
                int xf = (int) ((at.getTranslateX()+10)* Math.sin(Math.toRadians(this.inici.get(2))));
                int yf = (int) ((at.getTranslateY()+10)* Math.sin(Math.toRadians(this.inici.get(2))));
                
//               g2d.drawLine((int)at.getTranslateX(), (int)at.getTranslateY(), xf, yf);
                break;
  
            case 1:
               g2d.drawLine((int)at.getTranslateX()+50, (int)at.getTranslateY()+50, (int)at.getTranslateX()+50, 
                 (int)at.getTranslateY()+50);
                break;
                
            case 2:
                g2d.drawLine((int)at.getTranslateX()+50, (int)at.getTranslateY()+50, (int)at.getTranslateX()+50, 
                 (int)at.getTranslateY()+50);
                break;
                  
            case 3:
               g2d.drawLine((int)at.getTranslateX()+50, (int)at.getTranslateY()+50, (int)at.getTranslateX()+50, 
                 (int)at.getTranslateY()+50);
                break;
        }      
  
    }
    
}
