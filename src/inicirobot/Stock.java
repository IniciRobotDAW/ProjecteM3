/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicirobot;

import java.util.ArrayList;
import libraries.Board;

/**
 *
 * @author rbarberan
 */
public class Stock {

    private ArrayList<ArrayList> stock;

    public Stock() {
        this.stock = new ArrayList<>();
    }
    
    public ArrayList<ArrayList> getPieces() {

        ArrayList<RobotPiece> bodys = new ArrayList();
        ArrayList<RobotPiece> turrets = new ArrayList();
        ArrayList<RobotPiece> radars = new ArrayList();

        if (Board.getTheme() == "Sea") {

            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/boats/Boat.png", 0, 0, 0, 0));

            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/boats/boatTurret.png", 0, 0, 8, -10));

            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 0, 0));
            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/boats/boatRadar.png", 0, 0, 7, 9));

        } else {

            bodys.add(new RobotPiece("/resources/images/realBody.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/arnauBody.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/body.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/greenBody.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/pinkBody.png", 0, 0, 0, 0));
            bodys.add(new RobotPiece("/resources/images/pinkBody.png", 0, 0, 0, 0));

            turrets.add(new RobotPiece("/resources/images/realTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/arnauTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/turret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/greenTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/pinkTurret.png", 0, 0, 8, -10));
            turrets.add(new RobotPiece("/resources/images/pinkTurret.png", 0, 0, 8, -10));

            radars.add(new RobotPiece("/resources/images/realRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/arnauRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/radar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/yellowRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/arnauRadar.png", 0, 0, 7, 9));
            radars.add(new RobotPiece("/resources/images/pinkRadar.png", 0, 0, 7, 9));

        }

        this.stock.add(bodys);
        this.stock.add(turrets);
        this.stock.add(radars);

        return this.stock;

    }
}
