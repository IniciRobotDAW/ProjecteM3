/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;
/**
 *
 * @author Bernat
 */
public interface SimulatorBullet extends SimulatorObject {
    
    public abstract boolean inBoard();
    public abstract void move();
    public abstract void setVisible(boolean visible);
    public abstract SimulatorRobot getOwner();
    public abstract boolean touchRobot();
    public abstract boolean touchObject();
    
}
