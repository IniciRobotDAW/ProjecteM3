/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bernat
 */

public class BattleWindow extends JFrame implements ActionListener {
    
    public Board board;
    public JPanel info;  
    Timer timer;

    public BattleWindow(SimulatorRobot r1,SimulatorRobot r2) {

            setSize(1000, 700);    

            board = new Board(r1,r2);
            board.setLayout(null);
            board.setBounds(0, 0, 800, 600);
            board.setBackground(Color.BLACK);
            
            getContentPane().setLayout(null);
            this.add(board);

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
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

            board.act();
            board.repaint();

    }

  
}


