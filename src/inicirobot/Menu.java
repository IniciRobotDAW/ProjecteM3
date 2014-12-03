/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inicirobot;
import java.util.*;

/**
 *
 * @author atorrillas
 */
public class Menu {

    public Menu() {
    }
    
    public int mostraMenu(){
        System.out.println ("Batalla de robots");
        System.out.println ("Quants robots vols (de 2 a 6)?");
        
        Scanner numRobotsS = new Scanner (System.in); //Creación de un objeto Scanner
        
        int numRobots = numRobotsS.nextInt();
        
        while((numRobots<0)||(numRobots>6)){
            System.out.println ("Resposta incorrecte! Quants robots vols (de 2 a 6)?");
            numRobotsS = new Scanner (System.in); //Creación de un objeto Scanner
        
            numRobots = numRobotsS.nextInt();
        }
        
        System.out.println ("Som-hi!");
        return numRobots;
    }
    
}
