/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


import inicirobot.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author Bernat
 */

public class BattleWindow extends JFrame implements ActionListener {
    
    public Board board;
    public StatesDisplay display;
    public JPanel info; 
    
    public ImageIcon ii;
    Timer timer;

    public BattleWindow(ArrayList<SimulatorRobot> r) {

        setSize(1000, 700);   
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
       
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
//        System.out.println(game.getTheme());
//        if(game.getTheme().equals("desert")){
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desert.png"));
//        } else {
//            ImageIcon ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/forest.png"));
//        }
        
        JLabel background=new JLabel(new ImageIcon(ii.getImage()));
	add(background);
	background.setLayout(new FlowLayout());
            
        board = new Board(r);
        board.setLayout(new BorderLayout());
        
        board.setBounds(0, 0, 800, 600);

        board.add(background);

        display = new StatesDisplay(r);

        display.setLayout(null);
        display.setBounds(
                Board.getWIDTH(),
                Board.getHEIGHT()-Board.getHEIGHT(),
                this.getWidth()-Board.getWIDTH(),
                Board.getHEIGHT());
        display.setBackground(Color.LIGHT_GRAY);

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
            display.repaint();

    }

  
}


