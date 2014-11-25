/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bernat
 */

public class BattleWindow extends JFrame implements ActionListener {
    
    public Board board;
    public statesDisplay display;
    public JPanel info;  
    Timer timer;

    public BattleWindow(ArrayList<SimulatorRobot> r) {

            setSize(1000, 600);    

            board = new Board(r);
            board.setLayout(null);
            board.setBounds(0, 0, 800, 600);
            board.setBackground(Color.BLACK);
            
            
            display = new statesDisplay(r);
            display.setLayout(null);
            display.setBounds(
                    Board.getWIDTH(),
                    Board.getHEIGHT()-Board.getHEIGHT(),
                    this.getWidth()-Board.getWIDTH(),
                    Board.getHEIGHT());
            display.setBackground(Color.cyan);
            
            getContentPane().setLayout(null);
            this.add(board);
            this.add(display);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);

            timer = new Timer(5, this);
            timer.start();
    }

    @Override
    public void paint(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;
            this.board.repaint();
            this.display.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

            board.act();
            board.repaint();

    }

  
}


