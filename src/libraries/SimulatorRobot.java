/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import inicirobot.RobotPiece;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Bernat
 */
public interface SimulatorRobot extends SimulatorObject,Runnable{
   
    public abstract ArrayList<Point2D.Double> getBoundPoints(); 
    public abstract ArrayList<Line2D.Double> getBoundLines();
    public abstract int getLives();
    public abstract int getStartLives();
    public abstract int getBulletsLoad();
    public abstract int getStartBulletsLoad();
    public abstract double getX();
    public abstract double getY();
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract RobotPiece getBody();
    public abstract RobotPiece getTurret();
    public abstract RobotPiece getRadar();
    public abstract long getLastReload();
    public abstract int getReloadTime();
    
}
