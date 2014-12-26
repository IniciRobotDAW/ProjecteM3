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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import libraries.Board;

/**
 *
 * @author atorrillas
 */
public class Ovni extends GraphicObject{
    
    private Image imageR;
    private Image imageO;
    private int width;
    private int height;
    private int value;
    private double degrees;
    private ImageIcon imgreal;
    private ImageIcon imgombra;  
    
    //Anim
    private int frameWidth;
    private int frameHeight;
    private long timeForNextFrame;
    private BufferedImage animImageR;
    private BufferedImage animImageO;
    private int currentFrameNumber;
    private int numberOfFrames;
    private boolean loop;
    private int startingXOfFrameInImage;
    private int endingXOfFrameInImage;
    public boolean active;
    private long showDelay;
    private long timeOfAnimationCration;
    private long startingFrameTime;
    private long frameTime;
    private URL explosionAnimImgUrl1;
    private URL explosionAnimImgUrl2;
    
    //0= pos x | 1 = pos y | 2 = angle | 3 = canto
    private ArrayList<Integer> inici = caclPosIni();

    public Ovni() {
//        super((Math.random()*Board.getWIDTH()+1), (Math.random()*Board.getHEIGHT()+1), 0.0f);
            
            super(0, 0,0.0f);
            this.x = (double) inici.get(0);
            this.y = (double) inici.get(1);
            switch(Board.getTheme()){
            
            case "Desert": 
                
                explosionAnimImgUrl1 = this.getClass().getResource("/resources/images/ovnis/plane.png");
                explosionAnimImgUrl2 = this.getClass().getResource("/resources/images/ovnis/planeo.png");
                this.numberOfFrames = 1;
               
                this.frameWidth = 84;
                this.frameHeight = 84;
                
                try {
                    animImageR = ImageIO.read(explosionAnimImgUrl1);
                    animImageO = ImageIO.read(explosionAnimImgUrl2);
                } catch (IOException ex) {
                    Logger.getLogger(Ovni.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                break;
                
            case "Forest": 
                
                explosionAnimImgUrl1 = this.getClass().getResource("/resources/images/ovnis/plane.png");
                explosionAnimImgUrl2 = this.getClass().getResource("/resources/images/ovnis/planeo.png");
                this.numberOfFrames = 1;
                
                this.frameWidth = 84;
                this.frameHeight = 84;
                
                try {
                    animImageR = ImageIO.read(explosionAnimImgUrl1);
                    animImageO = ImageIO.read(explosionAnimImgUrl2);
                } catch (IOException ex) {
                    Logger.getLogger(Ovni.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            
            case "Spacial": 
                
                explosionAnimImgUrl1 = this.getClass().getResource("/resources/images/ovnis/ovni.png");
                explosionAnimImgUrl2 = this.getClass().getResource("/resources/images/ovnis/ovniombra.png");
                this.numberOfFrames = 6;
                
                this.frameWidth = 84;
                this.frameHeight = 84;
                
                
                try {
                    animImageR = ImageIO.read(explosionAnimImgUrl1);
                    animImageO = ImageIO.read(explosionAnimImgUrl2);
                } catch (IOException ex) {
                    Logger.getLogger(Ovni.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            
            case "Sea": 
                
                explosionAnimImgUrl1 = this.getClass().getResource("/resources/images/ovnis/gavina.png");
                explosionAnimImgUrl2 = this.getClass().getResource("/resources/images/ovnis/gavinaombra.png");
                this.numberOfFrames = 4;
                
                this.frameWidth=32;
                this.frameHeight=32;
                
                
                try {
                    animImageR = ImageIO.read(explosionAnimImgUrl1);
                    animImageO = ImageIO.read(explosionAnimImgUrl2);
                } catch (IOException ex) {
                    Logger.getLogger(Ovni.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
                        
            default: 
                
                explosionAnimImgUrl1 = this.getClass().getResource("/resources/images/ovnis/ovni.png");
                explosionAnimImgUrl2 = this.getClass().getResource("/resources/images/ovnis/ovniombra.png");
                this.numberOfFrames = 6;
                this.frameWidth = 84;
                this.frameHeight = 84;
          
                try {
                    animImageR = ImageIO.read(explosionAnimImgUrl1);
                    animImageO = ImageIO.read(explosionAnimImgUrl2);
                } catch (IOException ex) {
                    Logger.getLogger(Ovni.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;                  
            
        }
            
        this.loop = true;
        this.active = true;
        this.degrees = Math.random()*360 + 1;
        timeOfAnimationCration = System.currentTimeMillis();
        startingXOfFrameInImage = 0;
        endingXOfFrameInImage = frameWidth;

        startingFrameTime = System.currentTimeMillis() + showDelay;
        this.frameTime = 100;
        timeForNextFrame = startingFrameTime + this.frameTime;
        currentFrameNumber = 0;
        active = true;
       
        this.showDelay = 0;
    }

    public Image getImageR() {
        return imageR;
    }

    public Image getImageO() {
        return imageO;
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

    public ImageIcon getImgreal() {
        return imgreal;
    }

    public ImageIcon getImgombra() {
        return imgombra;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public long getTimeForNextFrame() {
        return timeForNextFrame;
    }

    public BufferedImage getAnimImageR() {
        return animImageR;
    }

    public BufferedImage getAnimImageO() {
        return animImageO;
    }

    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public int getNumberOfFrames() {
        return numberOfFrames;
    }

    public boolean isLoop() {
        return loop;
    }

    public int getStartingXOfFrameInImage() {
        return startingXOfFrameInImage;
    }

    public int getEndingXOfFrameInImage() {
        return endingXOfFrameInImage;
    }

    public boolean isActive() {
        return active;
    }

    public long getShowDelay() {
        return showDelay;
    }

    public long getTimeOfAnimationCration() {
        return timeOfAnimationCration;
    }

    public long getStartingFrameTime() {
        return startingFrameTime;
    }

    public long getFrameTime() {
        return frameTime;
    }

    public URL getExplosionAnimImgUrl1() {
        return explosionAnimImgUrl1;
    }

    public URL getExplosionAnimImgUrl2() {
        return explosionAnimImgUrl2;
    }

    public void setImageR(Image imageR) {
        this.imageR = imageR;
    }

    public void setImageO(Image imageO) {
        this.imageO = imageO;
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

    public void setImgreal(ImageIcon imgreal) {
        this.imgreal = imgreal;
    }

    public void setImgombra(ImageIcon imgombra) {
        this.imgombra = imgombra;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public void setTimeForNextFrame(long timeForNextFrame) {
        this.timeForNextFrame = timeForNextFrame;
    }

    public void setAnimImageR(BufferedImage animImageR) {
        this.animImageR = animImageR;
    }

    public void setAnimImageO(BufferedImage animImageO) {
        this.animImageO = animImageO;
    }

    public void setCurrentFrameNumber(int currentFrameNumber) {
        this.currentFrameNumber = currentFrameNumber;
    }

    public void setNumberOfFrames(int numberOfFrames) {
        this.numberOfFrames = numberOfFrames;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setStartingXOfFrameInImage(int startingXOfFrameInImage) {
        this.startingXOfFrameInImage = startingXOfFrameInImage;
    }

    public void setEndingXOfFrameInImage(int endingXOfFrameInImage) {
        this.endingXOfFrameInImage = endingXOfFrameInImage;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setShowDelay(long showDelay) {
        this.showDelay = showDelay;
    }

    public void setTimeOfAnimationCration(long timeOfAnimationCration) {
        this.timeOfAnimationCration = timeOfAnimationCration;
    }

    public void setStartingFrameTime(long startingFrameTime) {
        this.startingFrameTime = startingFrameTime;
    }

    public void setFrameTime(long frameTime) {
        this.frameTime = frameTime;
    }

    public void setExplosionAnimImgUrl1(URL explosionAnimImgUrl1) {
        this.explosionAnimImgUrl1 = explosionAnimImgUrl1;
    }

    public void setExplosionAnimImgUrl2(URL explosionAnimImgUrl2) {
        this.explosionAnimImgUrl2 = explosionAnimImgUrl2;
    }
    
    private ArrayList caclPosIni(){
        
        ArrayList<Integer> pos = new ArrayList();
//        int canto = 2;
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
    
    private void Update(){
        if(timeForNextFrame <= System.currentTimeMillis()){
            // Next frame.
            currentFrameNumber++;

            // If the animation is reached the end, we restart it by seting current frame to zero. If the animation isn't loop then we set that animation isn't active.
            if(currentFrameNumber >= numberOfFrames)
            {
                currentFrameNumber = 0;

                // If the animation isn't loop then we set that animation isn't active.
                if(!loop)
                    active = false;
            }

            // Starting and ending coordinates for cuting the current frame image out of the animation image.
            startingXOfFrameInImage = currentFrameNumber * frameWidth;
            endingXOfFrameInImage = startingXOfFrameInImage + frameWidth;

            // Set time for the next frame.
            startingFrameTime = System.currentTimeMillis();
            timeForNextFrame = startingFrameTime + frameTime;
        }
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
    public void paintObj(Graphics g, JComponent j) {
        this.Update();
        
        Graphics2D g2d = (Graphics2D) g;
       
        if(this.timeOfAnimationCration + this.showDelay <= System.currentTimeMillis()){
            g2d.rotate(Math.toRadians(this.inici.get(2)), x, y);
            g2d.drawImage(animImageO, (int)this.x+20, (int)this.y+20, (int)this.x+ frameWidth, (int)this.y+ frameHeight, startingXOfFrameInImage, 0, endingXOfFrameInImage, frameHeight, null); 
            g2d.drawImage(animImageR, (int)this.x, (int)this.y, (int)this.x+ frameWidth, (int)this.y+ frameHeight, startingXOfFrameInImage, 0, endingXOfFrameInImage, frameHeight, null);           
        
        }
    }
}
