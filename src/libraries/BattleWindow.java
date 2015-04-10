/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;


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
    
    private ImageIcon ii;
    private int boardW;
    private int boardH;
    private int stateW;
    private int stateH;
    
    Timer timer;

    public BattleWindow(ArrayList<SimulatorRobot> r, String theme) {

        //mida de la finestra
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBarSize = scnMax.bottom;
        
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight()- taskBarSize);          
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        switch(theme){
            
            case "Desert": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/desert.png"));
                break;
                
            case "Forest": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/forest.png"));
                break;
            
            case "Spacial": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/spacial.jpg"));
                break;
            
            case "Sea": ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/sea.png"));
                break;
                        
            default: ii = new ImageIcon(this.getClass().getResource("/resources/images/scenarios/forest.png"));
                break;                  
            
        }
        //board
        //g.drawRect( 0,0, (int)screenSize.getWidth()-300, (int)screenSize.getHeight()-150);
        this.boardW = (int)screenSize.getWidth()-199;
        this.boardH = (int)screenSize.getHeight()-150; 
        
        //display
        //g.drawRect((int)screenSize.getWidth()-299 ,0, 500, (int)screenSize.getHeight()-150);
        this.stateW = (int)screenSize.getWidth()-this.stateW;
        this.stateH = (int)screenSize.getHeight()-150;
                
                
        JLabel background=new JLabel(new ImageIcon(ii.getImage()));
	add(background);
        
        add(background);
	setLocationRelativeTo(null);
        background.setLayout(new FlowLayout());
            
        board = new Board(r, theme, this.boardW, this.boardH);
        board.setLayout(new BorderLayout());
        
        board.setBounds(0, 0, this.boardW, this.boardH);
        

        board.add(background);

        display = new StatesDisplay(r, this.stateW, this.stateH);
       
        display.setLayout(null);
        display.setBounds(this.boardW+1, 0, this.stateW, this.stateH);
        
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


